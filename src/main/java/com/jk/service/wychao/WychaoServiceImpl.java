package com.jk.service.wychao;

import com.jk.mapper.wychao.IWychaoMapper;
import com.jk.model.Dianji;
import com.jk.model.GouMaiBiao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
}
