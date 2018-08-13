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
}
