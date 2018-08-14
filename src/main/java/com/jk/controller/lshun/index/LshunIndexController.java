package com.jk.controller.lshun.index;

import com.jk.model.GuangGaoBiao;
import com.jk.service.lshun.ILshunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @ 创建者：王晨.
 * @ 创建时间：2018/8/7 19:23
 * @ Description：
 * @ Version:
 */
@Controller
@RequestMapping("linshuiindex")
public class LshunIndexController {
    @Autowired
    private ILshunService LshunService;
    @RequestMapping("goto")
    public String gotowww(){

        return "lshun/login";
    }
    //返回主页面
    @RequestMapping("fivelogin")
    public  String fivelogin(){
        return "wjyi/showzhu";
    }
    //返回广告推广页面
    @RequestMapping("Advertisement")
    public String Advertisement(){

        return "lshun/Advertisement";
    }
    //新增广告推广页面
    @RequestMapping("InsertAdvertisement")
    public String InsertAdvertisement(){

        return "lshun/InsertAdvertisement";
    }
    //修改回显
    @RequestMapping("queryAdvertisementById")
    public  String  queryAdvertisementById(String id,Model model){
        GuangGaoBiao list = LshunService.queryAdvertisementById(id);
        model.addAttribute("list",list);

        return  "lshun/updateAdvertisement";
    }

    @RequestMapping("TestYeMian")
    public  String TestYeMian(){

        return  "lshun/test2";
    }

    @RequestMapping("Jump1")
    public  String Jump1(){

        return  "lshun/Jump1";
    }

}
