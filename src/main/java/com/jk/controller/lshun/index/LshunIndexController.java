package com.jk.controller.lshun.index;

import org.springframework.stereotype.Controller;
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
    @RequestMapping("goto")

    public String gotowww(){

        return "lshun/login";
    }
    //返回主页面
    @RequestMapping("fivelogin")
    public  String fivelogin(){
        return "wjyi/showzhu";
    }

}
