package com.jk.controller.wchen.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ 创建者：王晨.
 * @ 创建时间：2018/8/10 15:18
 * @ Description：
 * @ Version:
 */
@Controller
@RequestMapping("wchenindexcontroller")
public class WchenIndexController {
    @RequestMapping("tologgo")
    public String tologgo(){
        return "Wchen/Login";
    }
    @RequestMapping("gotoshowall")
    public String gotoshowall(){
        return "Wchen/LogShow";
    }
    @RequestMapping("gotoselectpeixun")
    public String gotoselectpeixun(){
        return "Wchen/selectpeixun";
    }

    @RequestMapping("gotoselectpeixunok")
    public String gotoselectpeixunok(){
        return "Wchen/selectpeixunok";
    }
    @RequestMapping("updatepeixun")
    public String updatepeixun(){
        return "Wchen/updatepeixun";
    }
}
