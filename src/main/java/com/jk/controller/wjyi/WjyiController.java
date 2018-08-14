package com.jk.controller.wjyi;

import com.jk.model.*;
import com.jk.service.wjyi.IWjyiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ 创建者：王晨.
 * @ 创建时间：2018/8/7 19:26
 * @ Description：
 * @ Version:
 */
@RestController
@RequestMapping("wjyi")
public class WjyiController {
    @Resource
    private IWjyiService WjyiService;

    /**
     * 查询权限树
     * @return
     */
    @RequestMapping("queryTree")
    public  List<Power> queryTree(HttpServletRequest request){
        User userid = (User) request.getSession().getAttribute("loginUser");
        String userid2 = userid.getUserid();
        List<Power> treelist = WjyiService.queryTree(userid2);
        return treelist;
    }

    //用户查询
    @RequestMapping("queryuser")
    public  Map<String,Object> queryuser(int page,int rows,User user){
      Map<String,Object>  userList = WjyiService.queryuser(page,rows,user);
        return userList;
    }


    //用户新增
    @RequestMapping("adduser")
    public String adduser(User user){
        WjyiService.adduser(user);
        return "1";
    }

    //用户删除
    @RequestMapping("deleteuser")
    public String deleteuser(String userid){
        WjyiService.deleteuser(userid);
        return "1";
    }

    //用户修改
    @RequestMapping("updateuser")
    public String updateuser(User user){
        WjyiService.updateuser(user);
        return "1";
    }

    //根据用户id展示拥有的角色
    @RequestMapping("queryrole")
    public List<Role> queryrole(String userid){
        List<Role> Rolelist = WjyiService.queryrole();
        List<Role> queryrolebyuserid = WjyiService.queryrolebyuserid(userid);
        for (Role role : Rolelist) {
            for (Role role2 : queryrolebyuserid) {
                if (role.getRoleid().equals(role2.getRoleid())) {
                    role.setChecked(true);
                }
            }
        }
        return Rolelist;
    }

    //用户赋角色
    @RequestMapping("addRoleAndUserid")
    public String addRoleAndUserid(String userids, String roleids) {
        WjyiService.addRoleAndUserid(userids, roleids);
        return "1";
    }

    //角色查询
    @RequestMapping("queryRole")
    public  Map<String,Object> queryRole(int page,int rows,Role role){
        Map<String,Object>  roleList = WjyiService.queryRole(page,rows,role);
        return roleList;
    }

    //角色新增
    @RequestMapping("addRole")
    public String addRole(Role role){
        WjyiService.addRole(role);
        return "1";
    }

    //角色修改
    @RequestMapping("updateRole")
    public String updateRole(Role role){
        WjyiService.updateRole(role);
        return "1";
    }

    //角色删除
    @RequestMapping("deleteRole")
    public String deleteRole(String roleid){
        WjyiService.deleteRole(roleid);
        return "1";
    }

    //权限查询
    @RequestMapping("queryPower")
    public  Map<String,Object> queryPower(int page,int rows,Power power){
        Map<String,Object>  powerList = WjyiService.queryPower(page,rows,power);
        return powerList;
    }

    //权限新增
    @RequestMapping("addPower")
    public String addPower(Power power){
        WjyiService.addPower(power);
        return "1";
    }

    //权限修改
    @RequestMapping("updatePower")
    public String updatePower(Power power){
        WjyiService.updatePower(power);
        return "1";
    }

    //权限删除
    @RequestMapping("deletePower")
    public String deletePower(String id){
        WjyiService.deletePower(id);
        return "1";
    }

    // 没用到的方法（根据用户角色id展示用户拥有的权限）
    @RequestMapping("queryRoleAndPower")
    public List<Power> querypower(String roleid, String userid) {
        List<Power> Powerlist = WjyiService.queryPowerAll();
        List<Power> querypowerbyrole = WjyiService.queryRoleAndPower(roleid, userid);
        for (Power power : Powerlist) {
            for (Power power1 : querypowerbyrole) {
                if (power.getId().equals(power1.getId())) {
                    power.setChecked(true);
                }
            }
        }
        return Powerlist;
    }

    //查询角色拥有的权限
    @RequestMapping("queryRoleAndPowers")
    public List<Power> querypowers(String roleid) {
        List<Power> Powerlist = WjyiService.queryPowerAll();
        List<Power> querypowerbyrole = WjyiService.queryRoleAndPowers(roleid);
        for (Power power : Powerlist) {
            for (Power power1 : querypowerbyrole) {
                if (power.getId().equals(power1.getId())) {
                    power.setChecked(true);
                }
            }
        }
        return Powerlist;
    }

    //赋权限
    @RequestMapping("addPowerAndRoleid")
    public String addPowerAndRoleid(String roleids, String quanids) {
        WjyiService.addPowerAndRoleid(roleids, quanids);
        return "1";
    }

    //系统人员状态未审核的查询
    @RequestMapping("shenheuser")
    public  Map<String,Object> shenheuser(int page,int rows,User user){
        Map<String,Object>  shenheuserList = WjyiService.shenheuser(page,rows,user);
        return shenheuserList;
    }

    //批量审核系统人员
    @RequestMapping("piliangquerenuserid")
    public String piliangquerenuserid(String userid){
        WjyiService.piliangquerenuserid(userid);
        return "1";
    }

    //课程状态为未审核的查询
    @RequestMapping("querywjyKeCheng")
    public  Map<String,Object> querywjyKeCheng(int page,int rows,KeCheng keCheng){
        Map<String,Object>  kecehngList = WjyiService.querywjyKeCheng(page,rows,keCheng);
        return kecehngList;
    }

    //批量审核课程
    @RequestMapping("piliangQuerenKecheng")
    public String piliangQuerenKecheng(String kechengid){
        WjyiService.piliangQuerenKecheng(kechengid);
        return "1";
    }


    //广告状态为未审核的查询
    @RequestMapping("querywjyGuang")
    public  Map<String,Object> querywjyGuang(int page,int rows,GuangGaoBiao guangGaoBiao){
        Map<String,Object>  guanggaoList = WjyiService.querywjyGuang(page,rows,guangGaoBiao);
        return guanggaoList;
    }

    //批量审核广告
    @RequestMapping("piliangQuerenGuanggao")
    public String piliangQuerenGuanggao(String guanggaoid){
        WjyiService.piliangQuerenGuanggao(guanggaoid);
        return "1";
    }

    @RequestMapping("queryComboPower")
    public  List<Power> queryComboPower(){
        List<Power> comBoTreelist = WjyiService.queryComboPower();
        return comBoTreelist;
    }

}
