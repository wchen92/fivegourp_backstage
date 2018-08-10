package com.jk.controller.wjyi.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ 创建者：王晨.
 * @ 创建时间：2018/8/7 19:25
 * @ Description：
 * @ Version:
 */
@Controller
@RequestMapping("wjyiiindex")
public class WjyiIndexController {

    /**
     * 进入主页面
     * @return
     */
    @RequestMapping("comezhu")
    public String queryTree(){
        return "Wjyi/showzhu";
    }

}
