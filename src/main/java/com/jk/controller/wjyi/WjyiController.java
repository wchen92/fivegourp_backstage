package com.jk.controller.wjyi;

import com.jk.model.*;
import com.jk.service.wjyi.IWjyiService;
import com.jk.uitl.LoginControllerLHL;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

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

    //权限下拉树查询
    @RequestMapping("queryComboPower")
    public  List<Power> queryComboPower(){
        List<Power> comBoTreelist = WjyiService.queryComboPower();
        return comBoTreelist;
    }

    //未完成任务查询
    @RequestMapping("queryRenwu")
    public  Map<String,Object> queryRenwu(int page,int rows,RenWu renwu){
        Map<String,Object>  renwuList = WjyiService.queryRenwu(page,rows,renwu);
        return renwuList;
    }

    //指派查询
    @RequestMapping("queryZhipai")
    public  Map<String,Object> queryZhipai(int page,int rows,ZhiPai zhipai,HttpServletRequest re){
        User userid = (User) re.getSession().getAttribute("loginUser");
        String uid = userid.getUserid();
        Map<String,Object>  zhipaiList = WjyiService.queryZhipai(page,rows,zhipai,uid);
        return zhipaiList;
    }

    //全部任务查询
    @RequestMapping("queryRenwuAll")
    public  Map<String,Object> queryRenwuAll(int page,int rows,RenWu renwu){
        Map<String,Object>  renwuList = WjyiService.queryRenwuAll(page,rows,renwu);
        return renwuList;
    }

    //用户下拉树查询
    @RequestMapping("queryComboUser")
    public  List<User> queryComboUser(){
        List<User> userTreelist = WjyiService.queryComboUser();
        return userTreelist;
    }

    //发布任务
    @RequestMapping("fabuRenwu")
    public String fabuRenwu(RenWu renwu,ZhiPai zhiPai,HttpServletRequest reque){
        renwu.setRenwuid(UUID.randomUUID().toString());
        User userid = (User) reque.getSession().getAttribute("loginUser");
        String usid = userid.getUserid();

        //处理人为空时 新增到任务表
        if(renwu.getZpr()=="" ||renwu.getZpr()==null ||renwu.getZpr()=="5"){
            WjyiService.fabuRenwu(renwu,usid);
        }else if(renwu.getZpr()!="" ||renwu.getZpr()!=null ){
            //处理人不为空时 增到指派表查看
            WjyiService.fabuZhipaiRenwu(renwu,zhiPai,usid);
        }
        return "1";
    }



    //修改完成状态
    @RequestMapping("updateWanchengStatus")
    public String updateWanchengStatus(String rwid,HttpServletRequest reque){
        User userid = (User) reque.getSession().getAttribute("loginUser");
        String usids = userid.getUserid();
        WjyiService.updateWanchengStatus(rwid,usids);
        return "1";
    }

    //未完成任务数量
    @RequestMapping("queryWeiwanchengShu")
    public Integer queryWeiwanchengShu(){
        Integer weiRenwuZongshu = WjyiService.queryWeiwanchengShu();
        return weiRenwuZongshu;
    }

    //指派任务数量
    @RequestMapping("queryZhipaiShu")
    public Integer queryZhipaiShu(HttpServletRequest r){
        User userid = (User) r.getSession().getAttribute("loginUser");
        String us = userid.getUserid();
        Integer zhipaiZongshu = WjyiService.queryZhipaiShu(us);
        return zhipaiZongshu;
    }

    //修改指派人完成状态
    @RequestMapping("updateZhiWanchengstatus")
    public String updateZhiWanchengstatus(String rwid,HttpServletRequest reque){
        User userid = (User) reque.getSession().getAttribute("loginUser");
        String usid = userid.getUserid();
        WjyiService.updateZhiWanchengstatus(rwid,usid);
        return "1";
    }

    //前台用户登录
    @RequestMapping("login")
    @ResponseBody
    public String login(QianTaiYongHu people, HttpServletRequest request) {
        Map<String, Object> map = WjyiService.login(people);
        QianTaiYongHu user2 = (QianTaiYongHu) map.get("user2");
        if (user2 != null) {
            request.getSession().setAttribute("loginYonghu", user2);
        }
        return map.get("flag").toString();
    }

    //用户名验重
    @RequestMapping("queryYongHuByName")
    @ResponseBody
    public Integer queryYongHuByName(String yonghuname,HttpServletRequest request){
        //1 此用户名不存在  2 此用户名存在
        Integer flag=null;
        QianTaiYongHu yonghu = WjyiService.queryYongHuByName(yonghuname);
        request.getSession().setAttribute("yonghu", yonghu);
        if(yonghu==null){
            flag=1;
        }else{
            flag=2;
        }
        return flag;
    }

    //用户注册
    @RequestMapping("saveYongHu")
    @ResponseBody
    public String saveYongHu(QianTaiYongHu yonghu){
        WjyiService.saveYongHu(yonghu);
        return "1";
    }

    //发短信
   @RequestMapping("fasonngduanxin")
    @ResponseBody
    public String fasonngduanxin(String phoneNumber){
        LoginControllerLHL lal = new LoginControllerLHL();
        String code = lal.getcode(phoneNumber);
        return code;
    }

    //前台用户修改
    @RequestMapping("updatexinxi")
    public String updatexinxi(QianTaiYongHu qiantaiyonghu){
        WjyiService.updatexinxi(qiantaiyonghu);
        return "1";
    }

    //前台信息查询
    @RequestMapping("queryAllxinxi")
    public   List<QianTaiYongHu> queryAllxinxi( Model model,HttpServletRequest ree) {
        Map<String, Object> maps = (Map<String, Object>) ree.getSession().getAttribute("loginYonghu");
        QianTaiYongHu mapsss = (QianTaiYongHu) maps.get("user2");
        String us = mapsss.getYonghuid();
        List<QianTaiYongHu> list = WjyiService.queryAllxinxi(us);
        return list;
    }

    //前台用户修改
    @RequestMapping("updatemima")
    public String updatemima(QianTaiYongHu qiantaiyonghu){
        WjyiService.updatemima(qiantaiyonghu);
        return "1";
    }
}
