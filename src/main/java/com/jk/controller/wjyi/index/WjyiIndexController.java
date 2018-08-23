package com.jk.controller.wjyi.index;

import com.jk.model.Power;
import com.jk.model.QianTaiYongHu;
import com.jk.model.Role;
import com.jk.model.User;
import com.jk.service.wjyi.IWjyiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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


    //前台用户登录
    @RequestMapping("comeTologin")
    public String comeTologin(){
        return "wjyi/yonghulogin";
    }

    //前台用户注册
    @RequestMapping("comeToZhuce")
    public String comeToZhuce(){
        return "wjyi/zhuce";
    }

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

    //查看任务跳页面
    @RequestMapping("comeToRenwu")
    public String comeToRenwu(){
        return "wjyi/renwuShow";
    }

    //查看任务跳页面
    @RequestMapping("comeToZhipai")
    public String comeToZhipai(){
        return "wjyi/zhipaiShow";
    }

    //查看全部任务跳页面
    @RequestMapping("comeToRenwuShow")
    public String comeToRenwuShow(){
        return "wjyi/renwuAllShow";
    }

    //查看全部任务跳页面
    @RequestMapping("comeToPFabuRenwu")
    public String comeToPFabuRenwu(){
        return "wjyi/renwuFabu";
    }

    //查看前台跳页面
    @RequestMapping("comeToText")
    public String comeToText(){
        return "wjyi/text";
    }



    //前台页面
   @RequestMapping("queryAllxinxi")
    public String queryAllxinxi( Model model,HttpServletRequest ree) {
       QianTaiYongHu user = (QianTaiYongHu) ree.getSession().getAttribute("loginYonghu");
       QianTaiYongHu qiantai = WjyiService.wchenselectoftouser(user.getYonghuid());
      /* String userid ="548d0af1-b4ab-4862-85b8-022f3dba9cee";
       QianTaiYongHu qiantai = WjyiService.wchenselectoftouser(userid);*/
       model.addAttribute("qiantai",qiantai);
       return "wjyi/text";
   }

    @RequestMapping("comeToZhu")
    public String comeToZhu(){
        return "wjyi/zhuce";
    }

}
