package com.jk.controller.lshun.index;

import com.jk.model.GuangGaoBiao;
import com.jk.service.lshun.ILshunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
    public  String TestYeMian(String allsolrselect,Model aa,String banxingname,String jiangshiname){
     aa.addAttribute("allsolrselect",allsolrselect);
        aa.addAttribute("banxingname",banxingname);
        aa.addAttribute("jiangshiname",jiangshiname);
        return  "lshun/test2";
    }

    @RequestMapping("Jump1")
    public  String Jump1(String kechengid, Model aa, HttpServletRequest request){
        String userid = "548d0af1-b4ab-4862-85b8-022f3dba9cee";
        String memberstatus = LshunService.selectmemberstatus(userid);
        aa.addAttribute("memberstatus",memberstatus);
        LshunService.addliulanliang(kechengid);
        aa.addAttribute("kechengid",kechengid);
        return  "lshun/Jump1";
    }

    @RequestMapping("LuckDraw")
    public  String LuckDraw(){

        return  "lshun/LuckDraw";
    }

}
