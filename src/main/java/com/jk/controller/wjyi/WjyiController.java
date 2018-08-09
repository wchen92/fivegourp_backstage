package com.jk.controller.wjyi;

import com.jk.model.Power;
import com.jk.model.Role;
import com.jk.model.User;
import com.jk.service.wjyi.IWjyiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
    public  List<Power> queryTree(){
        List<Power> treelist = WjyiService.queryTree();
        return treelist;
    }

    //用户查询
    @RequestMapping("queryuser")
    public  List<User> queryuser(int page,int rows,User user){
        List<User> userList = WjyiService.queryuser(page,rows,user);
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
        List<Map<String, String>> arrayList = new ArrayList<Map<String, String>>();
        String[] split = roleids.split(",");
        for (String roles : split) {
            Map<String, String> hashMap = new HashMap<>();
            hashMap.put("userids", userids);
            hashMap.put("roleids", roles);
            arrayList.add(hashMap);
        }
        WjyiService.addRoleAndUserid(userids, arrayList);
        return "1";
    }


}
