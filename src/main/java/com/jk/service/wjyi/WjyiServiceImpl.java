package com.jk.service.wjyi;

import com.jk.mapper.wjyi.IWjyiMapper;
import com.jk.model.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
}
