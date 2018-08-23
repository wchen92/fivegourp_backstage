package com.jk.controller.lshun;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.jk.mapper.lshun.ILshunMapper;
import com.jk.model.*;
import com.jk.service.lshun.ILshunService;
import com.jk.service.wchen.IWchenService;
import org.apache.ibatis.annotations.Mapper;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ 创建者：王晨.
 * @ 创建时间：2018/8/7 19:23
 * @ Description：
 * @ Version:
 */
@RestController
@RequestMapping("liushun")
public class LshunController {
    @Resource
    private ILshunService LshunService;
    @Resource
    private SolrClient solrClient;
    @Resource
    private   IWchenService WchenService;
    @Resource
    private ILshunMapper LshunMapper;
    //后台登陆控制层
    @RequestMapping("login")
    public String  login(User people, HttpServletRequest request) {
        Map<String, Object> map = LshunService.login(people);
        User user2 = (User) map.get("user2");
        if (user2 != null) {
            request.getSession().setAttribute("loginUser", user2);
        }
        return map.get("flag").toString();
    }
    //查询广告信息
    @RequestMapping("queryAdvertisementList")
    public Map<String,Object > queryAdvertisementList(int page,int rows,GuangGaoBiao guanggao){

        return      LshunService.queryAdvertisementList(page,rows,guanggao);
    }
    //OSS上传
    @RequestMapping("uploadImg")
    public  String uploadImg(MultipartFile imgs,
                             HttpServletRequest request,HttpServletResponse response) throws IOException {
        String uploadImg = LshunService.uploadImg(imgs);
        System.out.println(uploadImg);

        return uploadImg ;
    }
    //新增广告
    @RequestMapping("InsertAdvertisementList")
    public  String InsertAdvertisementList(GuangGaoBiao guanggao,HttpServletRequest request){
        LshunService.InsertAdvertisementList(guanggao,request);
        return  "1";

    }
    //删除
    @RequestMapping("DeleteAdvertisementList")
    public  String DeleteAdvertisementList(String ids){

          LshunService.DeleteAdvertisementList(ids);

        return "1";
    }
    //修改
    @RequestMapping("UpdateAdvertisement")
    public String UpdateAdvertisement(GuangGaoBiao gaoBiao,HttpServletRequest request){

        LshunService.UpdateAdvertisement(gaoBiao,request);

        return "1";
    }

    @RequestMapping("selectkechenglist")
    public List<KeCheng> selectkechenglist(String allsolrselect){
        List<KeCheng> keChengs = new ArrayList<>();
        String staus = "";
        if(!"".equals(allsolrselect)){
            List<KeCheng> getselecsolr = new ArrayList<>();
            SolrQuery solrQuery = new SolrQuery();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(" kechengname:"+allsolrselect+" OR kechengjieshao:"+allsolrselect+" OR jiangshi:"+allsolrselect+" OR banxing:"+allsolrselect+" OR huiyuanstatus:"+allsolrselect+" ");
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
                getselecsolr.add(keCheng);
            }
            for(KeCheng kc : getselecsolr){
                Liuyan selectkcorcs = LshunMapper.selectkcorcs(kc.getKechengid());
                kc.setLiulanliang(selectkcorcs.getLiulanshuliang().toString());
            }

            keChengs = getselecsolr;

        }else{

        List<KeCheng> selectsolr = WchenService.selectsolr(solrClient, staus);
        for(KeCheng kc : selectsolr){
            Liuyan selectkcorcs = LshunMapper.selectkcorcs(kc.getKechengid());
            kc.setLiulanliang(selectkcorcs.getLiulanshuliang().toString());
        }
            keChengs = selectsolr;
        }
        return  keChengs;
    }

    @RequestMapping("selectdaganglist")
    public   List <ZhangJie> selectdaganglist(){

        List <ZhangJie> list = LshunService.selectdaganglist();
        return  list;
    }
    @RequestMapping("selectxiangqinglist")
    public  List<KeCheng> selectxiangqinglist(){

        List<KeCheng> list = LshunService.selectxiangqinglist();

        return  list;
    }

    @RequestMapping("selectpricelist")
    public  KeCheng selectpricelist(String wchenkcdi){
        KeCheng list = LshunService.selectpricelist(wchenkcdi);
        return  list;
    }
    @RequestMapping("selectshipin")
    public String selectshipin(String wchenkcdi){
        return LshunService.selectshipin(wchenkcdi);
    }
    @RequestMapping("selectzhangjieorid")
    public String selectzhangjieorid(String zhanjieid ){

        return LshunService.selectzhangjieorid(zhanjieid);
    }

}
