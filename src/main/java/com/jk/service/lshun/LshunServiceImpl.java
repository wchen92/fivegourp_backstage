package com.jk.service.lshun;

import com.jk.mapper.lshun.ILshunMapper;
import com.jk.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @ 创建者：王晨.
 * @ 创建时间：2018/8/7 19:29
 * @ Description：
 * @ Version:
 */
@Service
public class    LshunServiceImpl implements ILshunService{
    @Resource
    private ILshunMapper LshunMapper;

    //登陆
    @Override
    public Map<String, Object> login(User people) {
        String flag = "0";
        Map<String, Object> map = new HashMap<>();
        User user2 = LshunMapper.queryUserByName(people.getText());
        if (user2 != null) {
            flag = "1";
            if (user2.getPassword().equals(people.getPassword())) {
                flag = "2";
                map.put("user2", user2);
            }else {
                flag = "3";
                map.put("user2", user2);
            }
        }
        map.put("flag", flag);
        return map;
    }
}
