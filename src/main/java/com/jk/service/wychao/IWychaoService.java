package com.jk.service.wychao;


import com.jk.model.Dianji;
import com.jk.model.GouMaiBiao;
import com.jk.model.GuangGaoBiao;
import com.jk.model.KeCheng;

import java.util.List;
import java.util.Map;

public interface IWychaoService {


    Map<String,Object> querydianji();

    Map<String,Object> querygoumai();

    Map<String,Object> queryshiji();

    Map<String,Object> queryguanggao();

    List<Dianji> getProductList(Dianji dianji);

    Integer getProductCount();

    Integer getGouMaiBiaoCount();

    List<GouMaiBiao> getGoumaiList(GouMaiBiao gouMaiBiao);


    

    List<GuangGaoBiao> getguangGaoBiaoList(GuangGaoBiao guangGaoBiao);

    Integer getGuangGaoBiaoCount();


    List<KeCheng> getkeChengList(KeCheng keCheng);

    Integer getkechengCount();
}
