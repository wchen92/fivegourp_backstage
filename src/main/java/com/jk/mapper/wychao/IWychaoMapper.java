package com.jk.mapper.wychao;


import com.jk.model.Dianji;
import com.jk.model.GouMaiBiao;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IWychaoMapper {

   @Select("SELECT t1.kechengdianjiliang ,t2.kechengname FROM dianjiliang t1 ,kecheng t2 WHERE t1.kechengid=t2.kechengid GROUP by t2.kechengname")
    List<Dianji> querydianji();

    @Select("SELECT  t1.goumaishuliang ,t2.kechengname FROM  goumaibiao t1, kecheng t2 WHERE t1.kechengid=t2.kechengid GROUP BY t2.kechengname" )

    List<GouMaiBiao> querygoumai();

    @Select("SELECT SUM(goumaishuliang), DATE_FORMAT(t1.goumaidate,\"%Y-%m\") FROM goumaibiao t1  GROUP BY DATE_FORMAT(t1.goumaidate,\"%Y-%m\")" )
    List<GouMaiBiao> queryshiji();
}
