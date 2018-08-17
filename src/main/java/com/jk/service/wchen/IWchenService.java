package com.jk.service.wchen;

import com.jk.model.KeCheng;
import com.jk.model.Log;
import org.apache.solr.client.solrj.SolrClient;

import java.util.List;
import java.util.Map;

public interface IWchenService {
    Map<String,Object> selectlog(Integer page, Integer rows);

    List<KeCheng> selectmysqladdgosolr();

    void addsolr(SolrClient solrClient, List<KeCheng> allmysql);

    List<KeCheng> selectsolr(SolrClient solrClient,String staus);
}
