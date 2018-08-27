package com.jk.service.wchen;

import com.jk.mapper.wchen.IWchenMapper;
import com.jk.model.*;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ 创建者：王晨.
 * @ 创建时间：2018/8/10 15:20
 * @ Description：
 * @ Version:
 */
@Service
public class WchenServiceImpl implements IWchenService{
    @Resource
    private MongoTemplate mongoTemplate;
    @Resource
    private IWchenMapper WchenMapper;
    @Override
    public Map<String,Object> selectlog(Integer page, Integer rows) {
        Query query = new Query();
        //skip 跳过  设置分页查询的起始位置
        query.skip((page-1)*rows);
        query.limit(rows);
        long count = mongoTemplate.count(new Query(),Log.class);
        List<Log> all = mongoTemplate.find(query,Log.class);
        Map<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("total",count);
        stringObjectHashMap.put("rows",all);
        return stringObjectHashMap;
    }

    @Override
    public List<KeCheng> selectmysqladdgosolr() {
        return WchenMapper.selectmysqladdgosolr();
    }

    @Override
    public void addsolr(SolrClient solrClient, List<KeCheng> allmysql) {
        try {
            solrClient.deleteByQuery("*:*");
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            solrClient.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (KeCheng kc : allmysql){
            SolrInputDocument solrInputDocument=new SolrInputDocument();
            solrInputDocument.addField("id",kc.getKechengid());
            solrInputDocument.addField("kechengname",kc.getKechengname());
            solrInputDocument.addField("kechengprice",kc.getKechengprice());
            solrInputDocument.addField("keshishu",kc.getKeshishu());
            solrInputDocument.addField("kechengphoto",kc.getKechengphoto());
            solrInputDocument.addField("kechengjieshao",kc.getKechengjieshao());
            solrInputDocument.addField("huiyuanstatus",kc.getHuiyuanstatus());
            solrInputDocument.addField("shenhestatus",kc.getShenhestatus());
            solrInputDocument.addField("jiangshi",kc.getJiangshi());
            solrInputDocument.addField("banxing",kc.getBanxing());
            solrInputDocument.addField("adddate",new Date());
            try {
                solrClient.add(solrInputDocument);
            } catch (SolrServerException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                solrClient.commit();
            } catch (SolrServerException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

    @Override
    public List<KeCheng> selectsolr(SolrClient solrClient,String staus){
        List<KeCheng> keChengs = new ArrayList<>();
        //查询所有solr数据
        SolrQuery solrQuery = new SolrQuery();
        StringBuffer stringBuffer = new StringBuffer();
        if("".equals(staus)){
            stringBuffer.append("*:*");
        }
        if("1".equals(staus)){
            stringBuffer.append("*:*");
            solrQuery.setStart(0);
            solrQuery.setRows(4);
        }
        if("2".equals(staus)){
            stringBuffer.append("*:*");
            solrQuery.setStart(0);
            solrQuery.setRows(8);
        }
        solrQuery.setQuery(stringBuffer.toString());
        QueryResponse queryResponse = null;
        try {
            queryResponse = solrClient.query(solrQuery);
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SolrDocumentList results = queryResponse.getResults();
         for (SolrDocument result :results){
             KeCheng keCheng = new KeCheng();
             keCheng.setKechengid(result.get("id").toString());
             keCheng.setKechengname(result.get("kechengname").toString());
             keCheng.setKechengprice(result.get("kechengprice").toString());
             keCheng.setKeshishu(result.get("keshishu").toString());
             keCheng.setKechengphoto(result.get("kechengphoto").toString());
             keCheng.setKechengjieshao(result.get("kechengjieshao").toString());
             if("1".equals(result.get("huiyuanstatus").toString())){
                 keCheng.setHuiyuanstatus("会员");
             }
             if("2".equals(result.get("huiyuanstatus").toString())){
                 keCheng.setHuiyuanstatus("非会员");
             }
             keCheng.setShenhestatus(result.get("shenhestatus").toString());
             keChengs.add(keCheng);
         }
        return keChengs;
    }

    @Override
    public void addkctopinlun(String kcid, String juzito,String userid) {
        PlTokc plTokc = new PlTokc();
        plTokc.setKcid(kcid);
        plTokc.setPinlun(juzito);
        plTokc.setUserid(userid);
        plTokc.setTime(new Date());
        mongoTemplate.save(plTokc);
    }

    @Override
    public List<PlTokc> selectkctopl(String kcid) {
        ArrayList<PlTokc> plTokcs1 = new ArrayList<>();

        Query query = new Query();
        query.addCriteria(new Criteria("kcid").is(kcid));
        List<PlTokc> plTokcs = mongoTemplate.find(query, PlTokc.class);
            for (PlTokc pl : plTokcs){
                PlTokc plTokc = new PlTokc();
                QianTaiYongHu user = WchenMapper.pluseridselecttomysql(pl.getUserid());
                plTokc.setUserid(user.getYonghuname());
                plTokc.setPinlun(pl.getPinlun());
                plTokc.setKcid(pl.getKcid());
                plTokc.setId(pl.getId());
                plTokc.setZhaopian(user.getYonghutouxiang());
                DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                plTokc.setGetdate(format2.format(pl.getTime()));
                plTokcs1.add(plTokc);
        }

        return plTokcs1;
    }

    @Override
    public QianTaiYongHu selecttitle(String showuserid) {
        return WchenMapper.selecttitle(showuserid);
    }

    @Override
    public List<BanXing> allselectbanxing() {
        return WchenMapper.allselectbanxing();
    }

    @Override
    public List<JiangShi> allselectjiaoshi() {
        return WchenMapper.allselectjiaoshi();
    }

    @Override
    public void addpeixun(peixun px) {
          //查询拥有客服人员的角色id
        List<String> userid = WchenMapper.selectorroletouserid();

        // 初始化随机数
        Random rand = new Random();
        // 存放乱序结果的集合
        List<String> result = new ArrayList<>();
      // 取得集合的长度，for循环使用
        int size = userid.size();

        // 遍历整个items数组
        for (int i = 0; i < size; i++) {
            // 任意取一个0~size的整数，注意此处的items.size()是变化的，所以不能用前面的size会发生数组越界的异常
            int myRand = rand.nextInt(userid.size());
            //将取出的这个元素放到存放结果的集合中
            result.add(userid.get(myRand));
            //从原始集合中删除该元素防止重复。注意，items数组大小发生了改变
            userid.remove(myRand);
        }

        //便利输出结果
        for (int i = 0; i < 1; i++) {
            px.setId(UUID.randomUUID().toString());
            px.setZhidingchuliid(result.get(i));
            px.setChulizhuangtai(1);
            WchenMapper.addpeixun(px);
        }
    }

    @Override
    public Map<String, Object> selectpeixun(Integer page, Integer rows, String userid) {
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        int start = (page-1)*rows;
        //根据用户id查询对应分配条数
        long tiaohus = WchenMapper.selectfenpeicount(userid);
        stringObjectHashMap.put("total",tiaohus);
        //查询数据
        List<peixun> peixunlist = WchenMapper.selectpeixun(userid,start,rows);
        stringObjectHashMap.put("rows",peixunlist);
        return stringObjectHashMap;
    }

    @Override
    public void peixunok(String id,String jieguo) {
        //修改处理状态
        WchenMapper.peixunok(id);
        //添加结果
        WchenMapper.addjieguo(id,jieguo);
    }

    @Override
    public Map<String, Object> selectpeixunok(Integer page, Integer rows, String userid) {
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        int start = (page-1)*rows;
        //根据用户id查询对应分配条数
        long tiaohus = WchenMapper.selectfenpeicountok(userid);
        stringObjectHashMap.put("total",tiaohus);
        //查询数据
        List<peixun> peixunlist = WchenMapper.selectpeixunok(userid,start,rows);
        stringObjectHashMap.put("rows",peixunlist);
        return stringObjectHashMap;
    }

}
