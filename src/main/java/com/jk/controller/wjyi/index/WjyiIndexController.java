package com.jk.controller.wjyi.index;

import com.jk.model.User;
import com.jk.service.wjyi.IWjyiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @ 创建者：王晨.
 * @ 创建时间：2018/8/7 19:25
 * @ Description：
 * @ Version:
 */
@Controller
@RequestMapping("wjyiiindex")
public class WjyiIndexController {

    @Resource
    private IWjyiService WjyiService;

    /**
     * 进入主页面展示权限树
     * @return
     */
    @RequestMapping("comezhu")
    public String queryTree(){
        return "wjyi/showzhu";
    }

    /**
     * 用户查询跳页面
     * @return
     */
    @RequestMapping("cometouser")
    public String queryuser(){
        return "wjyi/usershow";
    }

    /**
     * 用户新增跳页面
     * @return
     */
    @RequestMapping("addusershow")
    public String addusershow(){
        return "wjyi/addusershow";
    }

    //用户回显跳页面
    @RequestMapping("queryById")
    public String queryById(String userid, Model model){
        User user = WjyiService.queryById(userid);
        model.addAttribute("user",user);
        return "wjyi/addusershow";
    }

    //跳角色树页面
    @RequestMapping("queryRoleTree")
    public String queryRoleTree(){
        return "wjyi/roleTree";
    }

}
