package com.jk.controller.lshun;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.jk.model.User;
import com.jk.service.lshun.ILshunService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @ 创建者：王晨.
 * @ 创建时间：2018/8/7 19:23
 * @ Description：
 * @ Version:
 */
@RestController
@RequestMapping("liushun")
public class LshunController {
    @Resource
    private ILshunService LshunService;
    //后台登陆控制层
    @RequestMapping("login")
    public String  login(User people, HttpServletRequest request) {
        Map<String, Object> map = LshunService.login(people);
        User user2 = (User) map.get("user2");
        if (user2 != null) {
            request.getSession().setAttribute("loginUser", user2);
        }
        return map.get("flag").toString();
    }

}
