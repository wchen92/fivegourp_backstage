package com.jk.service.wchen;

import com.jk.model.*;
import org.apache.solr.client.solrj.SolrClient;

import java.util.List;
import java.util.Map;

public interface IWchenService {
    Map<String,Object> selectlog(Integer page, Integer rows);

    List<KeCheng> selectmysqladdgosolr();

    void addsolr(SolrClient solrClient, List<KeCheng> allmysql);

    List<KeCheng> selectsolr(SolrClient solrClient,String staus);

    void addkctopinlun(String kcid, String juzito,String userid );

    List<PlTokc> selectkctopl(String kcid);

    QianTaiYongHu selecttitle(String showuserid);

    List<BanXing> allselectbanxing();

    List<JiangShi> allselectjiaoshi();

    void addpeixun(peixun px);

    Map<String,Object> selectpeixun(Integer page, Integer rows, String userid);

    void peixunok(String id,String jieguo);

    Map<String,Object> selectpeixunok(Integer page, Integer rows, String userid);
}
