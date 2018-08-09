package com.jk.service.wjyi;

import com.jk.mapper.wjyi.IWjyiMapper;
import com.jk.model.Power;
import com.jk.model.Role;
import com.jk.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
    public List<Power> queryTree() {
        return WjyiMapper.queryTree();
    }

    @Override
    public List<User> queryuser(int page,int rows,User user) {
        long total = WjyiMapper.countuser(user);



        return WjyiMapper.queryuser();
    }

    @Override
    public void adduser(User user) {
        user.setUserid(UUID.randomUUID().toString());
        user.setPid("0");
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
    public void addRoleAndUserid(String userids, List<Map<String, String>> arrayList) {

        WjyiMapper.deleteRoleAndUser(userids);
        WjyiMapper.addRoleAndUserid(arrayList);
    }
}
