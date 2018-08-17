package com.jk.controller.wchen;

import com.jk.model.KeCheng;
import com.jk.service.wchen.IWchenService;
import org.apache.solr.client.solrj.SolrClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ 创建者：王晨.
 * @ 创建时间：2018/8/16 8:44
 * @ Description：
 * @ Version:
 */
@RestController
@RequestMapping("wchensolr")
public class SolrController {
    @Resource
    private SolrClient solrClient;
    @Resource
    private IWchenService WchenService;
    //查询数据库信息添加到solr
    @RequestMapping("selectmysqladdgosolr")
    public String selectmysqladdgosolr(){
        //查询数据库课程数据
        List<KeCheng> allmysql = WchenService.selectmysqladdgosolr();
        //添加solr
        WchenService.addsolr(solrClient,allmysql);
        return "ok";
    }
    @RequestMapping("selectsolr")
    public List<KeCheng> selectsolr(String staus){
        return WchenService.selectsolr(solrClient,staus);
    }

}
