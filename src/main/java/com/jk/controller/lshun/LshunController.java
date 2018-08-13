package com.jk.controller.lshun;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.jk.model.GuangGaoBiao;
import com.jk.model.User;
import com.jk.service.lshun.ILshunService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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
    //查询广告信息
    @RequestMapping("queryAdvertisementList")
    public Map<String,Object > queryAdvertisementList(int page,int rows,GuangGaoBiao guanggao){

        return      LshunService.queryAdvertisementList(page,rows,guanggao);
    }
    //OSS上传
    @RequestMapping("uploadImg")
    public  String uploadImg(MultipartFile imgs,
                             HttpServletRequest request,HttpServletResponse response) throws IOException {
        String uploadImg = LshunService.uploadImg(imgs);
        System.out.println(uploadImg);

        return uploadImg ;
    }
    //新增广告
    @RequestMapping("InsertAdvertisementList")
    public  String InsertAdvertisementList(GuangGaoBiao guanggao,HttpServletRequest request){
        LshunService.InsertAdvertisementList(guanggao,request);
        return  "1";

    }
    //删除
    @RequestMapping("DeleteAdvertisementList")
    public  String DeleteAdvertisementList(String ids){

          LshunService.DeleteAdvertisementList(ids);

        return "1";
    }
    //修改
    @RequestMapping("UpdateAdvertisement")
    public String UpdateAdvertisement(GuangGaoBiao gaoBiao){
        LshunService.UpdateAdvertisement(gaoBiao);

        return "1";
    }


}
