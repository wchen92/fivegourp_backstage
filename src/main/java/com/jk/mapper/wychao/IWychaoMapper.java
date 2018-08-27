package com.jk.mapper.wychao;


import com.jk.model.Dianji;
import com.jk.model.GouMaiBiao;
import com.jk.model.GuangGaoBiao;
import com.jk.model.KeCheng;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IWychaoMapper {

   @Select("SELECT t1.kechengdianjiliang, t2.kechengname FROM dianjiliang t1, kecheng t2 WHERE t1.kechengid =t2.kechengid GROUP BY t2.kechengname")
    List<Dianji> querydianji();

    @Select("select  t1.goumaishuliang ,t2.kechengname from goumaibiao t1 , kecheng t2 WHERE t1.kechengid =t2.kechengid GROUP BY t2.kechengname" )

    List<GouMaiBiao> querygoumai();

    @Select("SELECT  DATE_FORMAT(t1.goumaidate,\"%Y-%m\"),t1.goumaishuliang FROM goumaibiao t1  GROUP BY DATE_FORMAT(t1.goumaidate,\"%Y-%m\")" )
    List<GouMaiBiao> queryshiji();



 @Select(" select * from  dianjiliang LIMIT #{page},#{rows} ")
 List<Dianji> getProductList(Dianji dianji);

    @Select("select count(*) from dianjiliang")
    Integer getProductCount();

    @Select(" select * from  goumaibiao LIMIT #{page},#{rows} ")
    List<GouMaiBiao> getGoumaiList(GouMaiBiao gouMaiBiao);

    @Select("select count(*) from goumaibiao")
    Integer getGouMaiBiaoCount();

    @Select(" select * from  guanggaobiao LIMIT #{page},#{rows} ")
    List<GuangGaoBiao> getguangGaoBiaoList(GuangGaoBiao guangGaoBiao);

    @Select("select count(*) from guanggaobiao")
    Integer getGuangGaoBiaoCount();

@Select("SELECT t1.guanggaoname ,t1.money from guanggaobiao t1 ")
    List<GuangGaoBiao> queryguanggao();

    @Select(" select * from  kecheng LIMIT #{page},#{rows} ")
    List<KeCheng> getkeChengList(KeCheng keCheng);

    @Select("select count(*) from kecheng")
    Integer getkechengCount();




    @Select("select count(*) from dianjiliang")
    Integer queryReservationsCount();
    @Select(" select * from  goumaibiao LIMIT #{page},#{rows} ")
    List<Dianji> queryReservationsList(Dianji dianji);

    @Select("select * from dianjiliang")
    List<Dianji> queryShenqing();
    @Select("select * from guanggaobiao")
    List<GuangGaoBiao> queryguang();
    @Select("select * from kecheng")
    List<KeCheng> querykeCheng();
    @Select("select * from goumaibiao")
    List<GouMaiBiao> queryGouMaiBiao();
}
