package com.jk.service.zqshun;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.jk.model.BanXing;
import com.jk.model.KeCheng;
import com.jk.model.ZhangJie;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IZqshunService {

    //班型查询
    Map<String,Object> querybanxing(Integer page,Integer rows,BanXing banxing);

    //班型删除
    void deletebanxing(String ids);

    //班型新增
    void addbanxing(BanXing banxing);

    //班型回显
    BanXing selectbanxing(String zid);

    //班型修改
    void updatebanxing(BanXing banXing);

    //课程查询
    Map<String,Object> querykecheng(Integer page, Integer rows, KeCheng kecheng);

    //课程删除
    void deletekecheng(String ids);

    //课程新增
    void addkecheng(KeCheng keCheng);

    //课程回显
    KeCheng selectkecheng(String sid);

    //课程修改
    void updatekecheng(KeCheng keCheng);


    String uploadImg(MultipartFile imgs) throws IOException;

    Map<String,Object> queryzhangjie(Integer page, Integer rows, ZhangJie zhangjie);
}
