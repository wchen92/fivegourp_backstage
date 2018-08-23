package com.jk.service.zqshun;

import com.jk.mapper.zqshun.IZqshunMapper;
import com.jk.model.*;
import com.jk.service.wchen.IWchenService;
import com.jk.uitl.MinGanUtil;
import com.jk.uitl.OSSClientUtil;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.solr.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

/**
 * @ 创建者：王晨.
 * @ 创建时间：2018/8/7 19:32
 * @ Description：
 * @ Version:
 */
@Service
public class ZqshunServiceImpl implements IZqshunService{
    @Resource
    private IZqshunMapper ZqshunMapper;
    @Resource
    private SolrClient solrClientl;
    @Resource
    private IWchenService WchenService;

    /*@Autowired
    private MongoTemplate mongoTemplate;*/

    //班型分页查询
    @Override
    public Map<String,Object> querybanxing(Integer page,Integer rows,BanXing banxing) {
        HashMap<String, Object> stirngObjectHashMap = new HashMap<String, Object>();
        int start = (page-1) * rows;
        List<BanXing> userlist = ZqshunMapper.querybanxing(start,rows,banxing);

        stirngObjectHashMap.put("rows",userlist);
        long total = ZqshunMapper.total(banxing);
        stirngObjectHashMap.put("total",total);
        return stirngObjectHashMap;
    }

    //班型删除
    @Override
    public void deletebanxing(String ids) {
        ZqshunMapper.deletebanxing(ids);
    }

    //班型新增
    @Override
    public void addbanxing(BanXing banxing) {
        banxing.setBanxingid(UUID.randomUUID().toString().replaceAll("-",""));
        ZqshunMapper.addbanxing(banxing);
    }
    //班型回显
    @Override
    public BanXing selectbanxing(String zid) {

        return ZqshunMapper.selectbanxing(zid);
    }

    //班型修改
    @Override
    public void updatebanxing(BanXing banXing) {

        ZqshunMapper.updatebanxing(banXing);
    }
    //课程查询
    @Override
    public Map<String, Object> querykecheng(Integer page, Integer rows, KeCheng kecheng) {
        HashMap<String, Object> stirngObjectHashMap = new HashMap<String, Object>();
        int start = (page-1) * rows;
        List<KeCheng> userlist = ZqshunMapper.querykecheng(start,rows,kecheng);
        stirngObjectHashMap.put("rows",userlist);
        long total = ZqshunMapper.totalkecheng(kecheng);
        stirngObjectHashMap.put("total",total);
        return stirngObjectHashMap;
    }

    //课程删除
    @Override
    public void deletekecheng(String ids) {
        String[] split = ids.split(",");
        for(int i   = 0 ;i < split.length; i++) {
            ZqshunMapper.deletekecheng(split[i]);
            try {
                solrClientl.deleteByQuery("id:" + ids);
            } catch (SolrServerException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                solrClientl.commit();
            } catch (SolrServerException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //课程新增
    @Override
    public void addkecheng(KeCheng keCheng) {

        keCheng.setKechengid(UUID.randomUUID().toString().replaceAll("-",""));
        keCheng.setShenhestatus("2");
        keCheng.setKeshishu("0");
        ZqshunMapper.addkecheng(keCheng);
        Liuyan liuyan = new Liuyan();
        liuyan.setLiulanid(UUID.randomUUID().toString());
        liuyan.setKechengid(keCheng.getKechengid());
        liuyan.setLiulanshuliang(0);
        ZqshunMapper.addliulkan(liuyan);
    }

    //课程回显
    @Override
    public KeCheng selectkecheng(String sid) {
        return ZqshunMapper.selectkecheng(sid);
    }

    //课程修改
    @Override
    public void updatekecheng(KeCheng keCheng) {
        ZqshunMapper.updatekecheng(keCheng);
        List<KeCheng> selectmysqladdgosolr = WchenService.selectmysqladdgosolr();
        WchenService.addsolr(solrClientl,selectmysqladdgosolr);
    }

    //上传图片
        @Override
        public String uploadImg(MultipartFile file) throws IOException{
            if (file == null || file.getSize() <= 0) {
                throw new IOException("file不能为空");
            }
            OSSClientUtil ossClient=new OSSClientUtil();
            String name = ossClient.uploadImg2Oss(file);
            String imgUrl = ossClient.getImgUrl(name);
            String[] split = imgUrl.split("\\?");

            return split[0];
    }

    //查询章节管理
    @Override
    public Map<String, Object> queryzhangjie(Integer page, Integer rows, ZhangJie zhangJie) {
        HashMap<String, Object> stirngObjectHashMap = new HashMap<String, Object>();
        int start = (page-1) * rows;
        List<ZhangJie> userlist = ZqshunMapper.queryzhangjie(start,rows,zhangJie);
        stirngObjectHashMap.put("rows",userlist);
        long total = ZqshunMapper.totalzhangJie(zhangJie);
        stirngObjectHashMap.put("total",total);
        return stirngObjectHashMap;
    }
    //新增章节管理
    @Override
    public void addzhangjie(ZhangJie zhangJie) {
        zhangJie.setZhangjieid(UUID.randomUUID().toString());
        ZqshunMapper.addzhangjie(zhangJie);
        //新增课时数
        KeCheng keCheng = new KeCheng();
        keCheng.setKechengid(zhangJie.getKecheid());
        ZqshunMapper.addkechengzhangjieliang(keCheng);
            //新增课程章节
        KechengAndZhangjie kechengAndZhangjie = new KechengAndZhangjie();
        kechengAndZhangjie.setKeandzhangid(UUID.randomUUID().toString());
        kechengAndZhangjie.setZhangjieid(zhangJie.getZhangjieid());
        kechengAndZhangjie.setKechengid(zhangJie.getKecheid());
        ZqshunMapper.savekechengandzhangjie(kechengAndZhangjie);

    }

    //上传视频
    @Override
    public HashMap<String, Object> Upload(MultipartFile file) throws IOException  {
        if (file == null || file.getSize() <= 0) {
            throw new IOException("file不能为空");
        }
        OSSClientUtil ossClient=new OSSClientUtil();
        String name = ossClient.uploadImg2Oss(file);
        String imgUrl = ossClient.getImgUrl(name);
        String[] split = imgUrl.split("\\?");
        HashMap<String, Object> map=new HashMap<>();
        map.put("imgname", split[0]);
        return map;
    }

    //删除章节管理
    @Override
    public void deletezhangcheng(String ids) {
        ZqshunMapper.deletezhangcheng(ids);
    }

    //回显章节管理
    @Override
    public ZhangJie zhangjieupdate(String zjid) {
        return ZqshunMapper.zhangjieupdate(zjid);
    }

    //修改章节管理
    @Override
    public void updatezhangjie(ZhangJie zhangJie) {
        ZqshunMapper.updatezhangjie(zhangJie);
    }

    //课程下所属章节
    @Override
    public List<ZhangJie> selectzhangjie(String idzj) {
        return ZqshunMapper.selectzhangjie(idzj);
    }

    //过滤敏感词
    @Override
    public void mingan(String str) {

        String mingan = MinGanUtil.get1ju(str,ZqshunMapper);
        System.out.println(mingan);
    }

    @Override
    public Integer selecthy(String id) {
        return ZqshunMapper.selecthy(id);
    }

    @Override
    public List<JiangShi> selecttiche() {
        return ZqshunMapper.selecttiche();
    }

    @Override
    public List<BanXing> selectkctobanxing() {
        return ZqshunMapper.selectkctobanxing();
    }


}
