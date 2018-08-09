package com.jk.service.lshun;

import com.jk.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

public interface ILshunService {
    //后台登陆接口
    Map<String, Object> login(User people);
}
