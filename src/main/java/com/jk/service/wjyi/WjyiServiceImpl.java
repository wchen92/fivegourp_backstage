package com.jk.service.wjyi;

import com.jk.mapper.wjyi.IWjyiMapper;
import com.jk.model.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.*;

/**
 * @ 创建者：王晨.
 * @ 创建时间：2018/8/7 19:31
 * @ Description：
 * @ Version:
 */
@Service
public class WjyiServiceImpl implements  IWjyiService{
    @Resource
    private IWjyiMapper WjyiMapper;

    @Override
    public List<Power> queryTree(String userid2) {
        return WjyiMapper.queryTree(userid2);
    }

    @Override
    public Map<String, Object> queryuser(int page, int rows, User user) {
        HashMap<String, Object> stirngObjectHashMap = new HashMap<String, Object>();
        int start = (page-1)*rows;
        List<User> userlist = WjyiMapper.queryuser(start,rows,user);
        stirngObjectHashMap.put("rows",userlist);
        long total = WjyiMapper.countuser(user);
        stirngObjectHashMap.put("total",total);
        return stirngObjectHashMap;
    }

    @Override
    public void adduser(User user) {
        user.setUserid(UUID.randomUUID().toString());
        user.setPid("0");
        user.setUserstatus(2);
        WjyiMapper.adduser(user);
    }

    @Override
    public void deleteuser(String userid) {
        String[] split = userid.split(",");
        for (int i = 0; i < split.length; i++) {
            WjyiMapper.deleteuser(split[i]);
        }
    }

    @Override
    public User queryById(String userid) {
        return WjyiMapper.queryById(userid);
    }

    @Override
    public void updateuser(User user) {
        WjyiMapper.updateuser(user);
    }

    @Override
    public List<Role> queryrole() {
        return WjyiMapper.queryrole();
    }

    @Override
    public List<Role> queryrolebyuserid(String userid) {
        return WjyiMapper. queryrolebyuserid(userid);
    }

    @Override
    public void addRoleAndUserid(String userids,String roleids) {
        WjyiMapper.deleteRoleAndUser(userids);
        String[] splitrole = roleids.split(",");
        for (int i = 0; i < splitrole.length; i++) {
            WjyiMapper.addRoleAndUserid(userids,splitrole[i]);
        }
    }

    @Override
    public Map<String, Object> queryRole(int page, int rows, Role role) {
        HashMap<String, Object> roleHashMap = new HashMap<String, Object>();
        int start = (page-1)*rows;
        List<Role> roleList = WjyiMapper.queryRole(start,rows,role);
        roleHashMap.put("rows",roleList);
        long total = WjyiMapper.countRole(role);
        roleHashMap.put("total",total);
        return roleHashMap;
    }

    @Override
    public void addRole(Role role) {
        role.setRoleid(UUID.randomUUID().toString());
        role.setPid("0");
        WjyiMapper.addRole(role);
    }

    @Override
    public Role queryRoleById(String roleid) {
        return WjyiMapper.queryRoleById(roleid);
    }

    @Override
    public void updateRole(Role role) {
        WjyiMapper.updateRole(role);
    }

    @Override
    public void deleteRole(String roleid) {
        String[] split = roleid.split(",");
        for (int i = 0; i < split.length; i++) {
            WjyiMapper.deleteRole(split[i]);
        }
    }

    @Override
    public Map<String, Object> queryPower(int page, int rows, Power power) {
        HashMap<String, Object> roleHashMap = new HashMap<String, Object>();
        int start = (page-1)*rows;
        List<Power> roleList = WjyiMapper.queryPower(start,rows,power);
        roleHashMap.put("rows",roleList);
        long total = WjyiMapper.countPower(power);
        roleHashMap.put("total",total);
        return roleHashMap;
    }

    @Override
    public void addPower(Power power) {
        power.setId(UUID.randomUUID().toString());
        WjyiMapper.addPower(power);
    }

    @Override
    public Power queryPowerById(String id) {
        return WjyiMapper.queryPowerById(id);
    }

    @Override
    public void updatePower(Power power) {
        WjyiMapper.updatePower(power);
    }

    @Override
    public void deletePower(String id) {
        String[] split = id.split(",");
        for (int i = 0; i < split.length; i++) {
            WjyiMapper.deletePower(split[i]);
        }
    }

    @Override
    public List<Power> queryPowerAll() {
        return WjyiMapper.queryPowerAll();
    }

    @Override
    public List<Power> queryRoleAndPower(String roleid, String userid) {
        return WjyiMapper.queryRoleAndPower(roleid,userid);
    }

    //赋权限
    @Override
    public void addPowerAndRoleid(String roleids,String quanids) {
        WjyiMapper.deletePowerAndRole(roleids);
        String[] split = quanids.split(",");
        for (int i = 0; i < split.length; i++) {
            WjyiMapper.addPowerAndRoleid(roleids,split[i]);
        }
    }

    @Override
    public Map<String, Object> shenheuser(int page, int rows, User user) {
        HashMap<String, Object> shenheUserHashMap = new HashMap<String, Object>();
        int start = (page-1)*rows;
        List<User> roleList = WjyiMapper.shenheuser(start,rows,user);
        shenheUserHashMap.put("rows",roleList);
        long total = WjyiMapper.countShenheUser(user);
        shenheUserHashMap.put("total",total);
        return shenheUserHashMap;
    }

    @Override
    public void piliangquerenuserid(String userid) {
        String[] split = userid.split(",");
        for (int i = 0; i < split.length; i++) {
            WjyiMapper.piliangquerenuserid(split[i]);
        }
    }

    @Override
    public Map<String, Object> querywjyKeCheng(int page, int rows, KeCheng keCheng) {
        HashMap<String, Object> wjykechengHashMap = new HashMap<String, Object>();
        int start = (page-1)*rows;
        List<KeCheng> roleList = WjyiMapper.querywjyKeCheng(start,rows,keCheng);
        wjykechengHashMap.put("rows",roleList);
        long total = WjyiMapper.countwjyKeCheng(keCheng);
        wjykechengHashMap.put("total",total);
        return wjykechengHashMap;
    }

    @Override
    public void piliangQuerenKecheng(String kechengid) {
        String[] split = kechengid.split(",");
        for (int i = 0; i < split.length; i++) {
            WjyiMapper.piliangQuerenKecheng(split[i]);
        }
    }

    @Override
    public Map<String, Object> querywjyGuang(int page, int rows, GuangGaoBiao guangGaoBiao) {
        HashMap<String, Object> wjyGuangHashMap = new HashMap<String, Object>();
        int start = (page-1)*rows;
        List<GuangGaoBiao> roleList = WjyiMapper.querywjyGuang(start,rows,guangGaoBiao);
        wjyGuangHashMap.put("rows",roleList);
        long total = WjyiMapper.countwjyGuang(guangGaoBiao);
        wjyGuangHashMap.put("total",total);
        return wjyGuangHashMap;
    }

    @Override
    public void piliangQuerenGuanggao(String guanggaoid) {
        String[] split = guanggaoid.split(",");
        for (int i = 0; i < split.length; i++) {
            WjyiMapper.piliangQuerenGuanggao(split[i]);
        }
    }

    @Override
    public List<Power> queryComboPower() {
        return WjyiMapper.queryComboPower();
    }

    @Override
    public List<Power> queryRoleAndPowers(String roleid) {
        return WjyiMapper.queryRoleAndPowers(roleid);
    }

    //未完成任务查询
    @Override
    public Map<String, Object> queryRenwu(int page, int rows, RenWu renwu) {
        int start = (page-1)*rows;
        ArrayList<RenWu> renWus = new ArrayList<>();

        //查询所以任务
        List<RenWu> allrenwu =  WjyiMapper.queryRenwus(start,rows);
        for(RenWu rw : allrenwu){
            RenWu renWu = new RenWu();
            //任务id
            renWu.setRwid(rw.getRenwuid());
            //任务名称
            renWu.setRwmc(rw.getRenwuname());
            //任务内容
            renWu.setRwnr(rw.getRenwuneirong());
            //任务是否指派
            renWu.setSfzp(rw.getShifouzhipai());
            //完成状态
            renWu.setWczt(rw.getWanchengstatus());

            //查询发布人
            RenWu  fbrrenwu = WjyiMapper.selectinfaburen(rw.getFaburenid());
            //存入发布人id
            renWu.setFbr(fbrrenwu.getFbr());

            if(!"".equals(rw.getChulirenid())){
                RenWu  clrrenwu = WjyiMapper.selectculiren(rw.getChulirenid());
                //存入处理人
                renWu.setClr(clrrenwu.getClr());
            }else{
                renWu.setClr("未处理");
            }

            if(rw.getShifouzhipai().equals(1)){
                //查询指派人id
                RenWu zprrenwuid = WjyiMapper.selectzhipairen(rw.getRenwuid());
                //根据指派人id查询指派人
                RenWu zpr =  WjyiMapper.selectidorren(zprrenwuid.getZpr());
                renWu.setZpr(zpr.getZpr());
            }
            if(!rw.getShifouzhipai().equals(1)){
                renWu.setZpr("未指派");
            }
            renWus.add(renWu);
        }
        HashMap<String, Object> wjyRenwuHashMap = new HashMap<String, Object>();
        wjyRenwuHashMap.put("rows",renWus);
        long l = WjyiMapper.countwjyRenwuAll(renwu);
        wjyRenwuHashMap.put("total",l);
        return wjyRenwuHashMap;
    }

    //查询指派表  展示 指派id，任务名称，任务内容，指派人(chilirenid)，发布人
    @Override
    public Map<String, Object> queryZhipai(int page, int rows, ZhiPai zhipai,String uid ) {
        int start = (page-1)*rows;
        //实例化存入值的集合
        ArrayList<RenWu> renWus = new ArrayList<>();
        //根据登陆 session 取出登陆id 去查询所指派给自己的所以任务
        List<RenWu>  sessionorrenwulist  = WjyiMapper.sessionorrenwu(uid,start,rows);
    //循环查询的内容根据发布人id查询发布人名称
        for(RenWu rw : sessionorrenwulist){
            RenWu renWu = new RenWu();
            RenWu fbrname = WjyiMapper.fbridorname(rw.getFbr());
            renWu.setRwid(rw.getRwid());
            renWu.setZpr(rw.getZpr());
            renWu.setFbr(rw.getFbr());
            renWu.setRwmc(rw.getRwmc());
            renWu.setRwnr(rw.getRwnr());
            renWu.setFbr(fbrname.getFbr());
            renWu.setWczt(rw.getWczt());
            renWus.add(renWu);
        }
        HashMap<String, Object> wjyZhipaiHashMap = new HashMap<String, Object>();
        long total = WjyiMapper.countwjyZhipai(zhipai);
        wjyZhipaiHashMap.put("total",total);
        wjyZhipaiHashMap.put("rows",renWus);
        return wjyZhipaiHashMap;
    }


    //全部任务查询
    @Override
    public Map<String, Object> queryRenwuAll(int page, int rows, RenWu renwu) {
        int start = (page-1)*rows;

        ArrayList<RenWu> renWus = new ArrayList<>();

        //查询所以任务
        List<RenWu> allrenwu =  WjyiMapper.selectallrw(start,rows,renwu);
        for(RenWu rw : allrenwu){
            RenWu renWu = new RenWu();
            //任务id
            renWu.setRwid(rw.getRenwuid());
            //任务名称
            renWu.setRwmc(rw.getRenwuname());
            //任务内容
            renWu.setRwnr(rw.getRenwuneirong());
            //任务是否指派
            renWu.setSfzp(rw.getShifouzhipai());
            //完成状态
            renWu.setWczt(rw.getWanchengstatus());

            //查询发布人
            RenWu  fbrrenwu = WjyiMapper.selectinfaburen(rw.getFaburenid());
            //存入发布人id
            renWu.setFbr(fbrrenwu.getFbr());

            if(!"".equals(rw.getChulirenid())){
                RenWu  clrrenwu = WjyiMapper.selectculiren(rw.getChulirenid());
                //存入处理人
                renWu.setClr(clrrenwu.getClr());
            }else {
                renWu.setClr("未处理");
            }

            if(rw.getShifouzhipai().equals(1)){
                //查询指派人id
                RenWu zprrenwuid = WjyiMapper.selectzhipairen(rw.getRenwuid());
                //根据指派人id查询指派人
                RenWu zpr =  WjyiMapper.selectidorren(zprrenwuid.getZpr());
                renWu.setZpr(zpr.getZpr());
            }
            if(!rw.getShifouzhipai().equals(1)){
                renWu.setZpr("未指派");
            }
            renWus.add(renWu);
        }
        Map<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("rows",renWus);
        long l = WjyiMapper.countwjyRenwuAll(renwu);
        stringObjectHashMap.put("total",l);
        return stringObjectHashMap;
    }

    @Override
    public List<User> queryComboUser() {
        return WjyiMapper.queryComboUser();
    }

    @Override
    public void fabuRenwu(RenWu renwu, String usid) {
        renwu.setWanchengstatus(2);
        renwu.setShifouzhipai(2);
        renwu.setZpr("5");
        renwu.setChulirenid("");
        WjyiMapper.fabuRenwu(renwu,usid);
    }

    @Override
    public void fabuZhipaiRenwu(RenWu renwu,ZhiPai zhiPai,String usid) {
        renwu.setWanchengstatus(2);
        renwu.setZpr(renwu.getZpr());
        renwu.setChulirenid("");
        renwu.setShifouzhipai(1);
        WjyiMapper.fabuRenwus(renwu,usid);
        zhiPai.setZhipaiid(UUID.randomUUID().toString());
        zhiPai.setRenwuid(renwu.getRenwuid());
        zhiPai.setRenwuname(renwu.getRenwuname());
        zhiPai.setChilirenid(renwu.getZpr());
        zhiPai.setRenwuneirongid(renwu.getRenwuneirong());
        WjyiMapper.fabuZhipaiRenwu(zhiPai,usid);
    }

    @Override
    public void updateWanchengStatus(String rwid, String usids ) {
        WjyiMapper.updateWanchengStatus(rwid,usids);
    }

    @Override
    public Integer queryWeiwanchengShu() {
        return WjyiMapper.queryWeiwanchengShu();
    }

    @Override
    public Integer queryZhipaiShu(String us ) {
        return WjyiMapper.queryZhipaiShu(us);
    }

    @Override
    public void updateZhiWanchengstatus(String rwid, String usid) {
        WjyiMapper.updateZhiWanchengstatus(rwid,usid);

    }


}
