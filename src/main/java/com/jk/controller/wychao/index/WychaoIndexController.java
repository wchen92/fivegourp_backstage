package com.jk.controller.wychao.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ 创建者：王晨.
 * @ 创建时间：2018/8/7 19:26
 * @ Description：
 * @ Version:
 */
@Controller
@RequestMapping("wychaoindex")
public class WychaoIndexController {

    @RequestMapping("dianji")

    public String queryuser(){

        return "wyc/dianji";
    }
    @RequestMapping("goumai")

    public String querygouma(){

        return "wyc/goumai";
    }
    @RequestMapping("xianxing")

    public String xianxing(){

        return "wyc/xianxing";
    }

    @RequestMapping("yuanxing")

    public String yuanxing(){

        return "wyc/yuanxing";
    }

    @RequestMapping("sandi")

    public String sandi(){

        return "wyc/Dzhu";
    }



}
