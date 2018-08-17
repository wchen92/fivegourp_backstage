package com.jk.service.wchen;

import com.jk.mapper.wchen.IWchenMapper;
import com.jk.model.KeCheng;
import com.jk.model.Log;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
