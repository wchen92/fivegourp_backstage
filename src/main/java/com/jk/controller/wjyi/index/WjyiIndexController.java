package com.jk.controller.wjyi.index;

import com.jk.model.Power;
import com.jk.model.Role;
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
        return "Wjyi/showzhu";
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
        return "wjyi/updateuser";
    }

    //跳角色树页面
    @RequestMapping("queryRoleTree")
    public String queryRoleTree(){
        return "wjyi/roleTree";
    }

    /**
     * 角色查询跳页面
     * @return
     */
    @RequestMapping("comeToRole")
    public String cometoRole(){
        return "wjyi/roleShow";
    }

    /**
     * 角色新增跳页面
     * @return
     */
    @RequestMapping("addRoleShow")
    public String addRoleShow(){
        return "wjyi/addRoleShow";
    }

    //角色回显跳页面
    @RequestMapping("queryRoleById")
    public String queryRoleById(String roleid, Model model){
        Role role  = WjyiService.queryRoleById(roleid);
        model.addAttribute("role",role);
        return "wjyi/updateRole";
    }

    /**
     * 权限查询跳页面
     * @return
     */
    @RequestMapping("comeToPower")
    public String comeToPower(){
        return "wjyi/powerShow";
    }

    /**
     * 权限新增跳页面
     * @return
     */
    @RequestMapping("addPowerShow")
    public String addPowerShow(){
        return "wjyi/addPowerShow";
    }

    //权限回显跳页面
    @RequestMapping("queryPowerById")
    public String queryPowerById(String id, Model model){
       Power power  = WjyiService.queryPowerById(id);
        model.addAttribute("power",power);
        return "wjyi/updatePower";
    }

    //跳权限树页面
    @RequestMapping("comeToPowerTree")
    public String comeToPowerTree(){
        return "wjyi/powerTree";
    }

    //系统人员审核页面
    @RequestMapping("comeToShenheUser")
    public String comeToShenheUser(){
        return "wjyi/shenheUserShow";
    }

    //课程状态审核页面
    @RequestMapping("comeToKechengShenhe")
    public String comeToKechengShenhe(){
        return "wjyi/shenheKeCheng";
    }

    //广告状态审核页面
    @RequestMapping("comeToShenheGuang")
    public String comeToShenheGuang(){
        return "wjyi/shenheGuanggao";
    }
}
