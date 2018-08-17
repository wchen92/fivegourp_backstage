package com.jk.service.wychao;

import com.jk.mapper.wychao.IWychaoMapper;
import com.jk.model.Dianji;
import com.jk.model.GouMaiBiao;
import com.jk.model.GuangGaoBiao;
import com.jk.model.KeCheng;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ 创建者：王晨.
 * @ 创建时间：2018/8/7 19:31
 * @ Description：
 * @ Version:
 */
@Service
public class WychaoServiceImpl implements IWychaoService{
    /**
     *
     */
    @Resource
    private IWychaoMapper WychaoMapper;


    @Override
    public Map<String, Object> querydianji() {

        List<Dianji> list=WychaoMapper.querydianji();
        List<String> xlist=new ArrayList<>();
        List<Integer> ylist=new ArrayList<>();
        for (int i = 0; i <list.size(); i++) {
            xlist.add(list.get(i).getKechengname());
            ylist.add(list.get(i).getKechengdianjiliang());
        }

        Map<String, Object>map=new HashMap<String, Object>();
        map.put("xlist", xlist);
        map.put("ylist", ylist);
        return map;
    }

    @Override
    public Map<String, Object> querygoumai() {

        List<GouMaiBiao> list=WychaoMapper.querygoumai();
        List<String> xlist=new ArrayList<>();
        List<Integer> ylist=new ArrayList<>();
        for (int i = 0; i <list.size(); i++) {
            xlist.add(list.get(i).getKechengid());
            ylist.add(list.get(i).getGoumaishuliang());
        }

        Map<String, Object>map=new HashMap<String, Object>();
        map.put("xlist", xlist);
        map.put("ylist", ylist);
        return map;
    }
    @Override
    public Map<String, Object> queryshiji() {

        List<GouMaiBiao> list=WychaoMapper.queryshiji();
        List<String> xlist=new ArrayList<>();
        List<Integer> ylist=new ArrayList<>();
        for (int i = 0; i <list.size(); i++) {
            xlist.add(list.get(i).getGoumaidate());
            ylist.add(list.get(i).getGoumaishuliang());
        }

        Map<String, Object>map=new HashMap<String, Object>();
        map.put("xlist", xlist);
        map.put("ylist", ylist);
        return map;
    }

    @Override
    public Map<String, Object> queryguanggao() {

        List<GuangGaoBiao> list=WychaoMapper.queryguanggao();
        List<Data> xlist=new ArrayList<>();
        List<Integer> ylist=new ArrayList<>();
        for (int i = 0; i <list.size(); i++) {
            xlist.add((Data) list.get(i).getGuanggaodate());
            ylist.add(list.get(i).getMoney());
        }

        Map<String, Object>map=new HashMap<String, Object>();
        map.put("xlist", xlist);
        map.put("ylist", ylist);
        return map;
    }

    @Override
    public List<Dianji> getProductList(Dianji dianji) {

        List<Dianji> list=WychaoMapper.getProductList(dianji);
        return list;

    }

    @Override
    public Integer getProductCount() {

        return WychaoMapper.getProductCount();


    }

    @Override
    public Integer getGouMaiBiaoCount() {
        return WychaoMapper.getGouMaiBiaoCount();
    }


    @Override
    public List<GouMaiBiao> getGoumaiList(GouMaiBiao gouMaiBiao) {

        List<GouMaiBiao> list=WychaoMapper.getGoumaiList(gouMaiBiao);

        return list;

    }

    @Override
    public List<GuangGaoBiao> getguangGaoBiaoList(GuangGaoBiao guangGaoBiao) {

        List<GuangGaoBiao> list=WychaoMapper.getguangGaoBiaoList(guangGaoBiao);

        return list;
    }

    @Override
    public Integer getGuangGaoBiaoCount() {

        return WychaoMapper.getGuangGaoBiaoCount();
    }


    @Override
    public List<KeCheng> getkeChengList(KeCheng keCheng) {

        List<KeCheng> list=WychaoMapper.getkeChengList(keCheng);

        return list;
    }

    @Override
    public Integer getkechengCount() {
        return WychaoMapper.getkechengCount();
    }


}
