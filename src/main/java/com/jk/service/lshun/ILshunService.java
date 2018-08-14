package com.jk.service.lshun;

import com.jk.model.GuangGaoBiao;
import com.jk.model.User;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface ILshunService {
    //后台登陆接口
    Map<String, Object> login(User people);
    //查询
    Map<String,Object> queryAdvertisementList(int page, int rows, GuangGaoBiao guanggao);
    //上传
    String uploadImg(MultipartFile imgs);
    //新增
    void InsertAdvertisementList(GuangGaoBiao guanggao,HttpServletRequest request);
    //删除
    void DeleteAdvertisementList(String ids);
    //回显
    GuangGaoBiao queryAdvertisementById(String id);

    void UpdateAdvertisement(GuangGaoBiao gaoBiao,HttpServletRequest request);
}
