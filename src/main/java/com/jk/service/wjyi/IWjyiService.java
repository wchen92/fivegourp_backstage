package com.jk.service.wjyi;

import com.jk.model.Power;
import com.jk.model.Role;
import com.jk.model.User;

import java.util.List;
import java.util.Map;

public interface IWjyiService {
    List<Power> queryTree();

    List<User> queryuser(int page,int rows,User user);

    void adduser(User user);

    void deleteuser(String userid);

    User queryById(String userid);

    void updateuser(User user);

    List<Role> queryrole();

    List<Role> queryrolebyuserid(String userid);

    void addRoleAndUserid(String userids, List<Map<String, String>> arrayList);
}
