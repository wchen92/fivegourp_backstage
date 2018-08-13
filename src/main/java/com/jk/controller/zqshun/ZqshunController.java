package com.jk.controller.zqshun;

import com.jk.model.BanXing;
import com.jk.model.KeCheng;
import com.jk.model.ZhangJie;
import com.jk.service.zqshun.IZqshunService;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ 创建者：王晨.
 * @ 创建时间：2018/8/7 19:28
 * @ Description：
 * @ Version:
 */
@RestController
@RequestMapping("zqshun")
public class ZqshunController {
    @Resource
    private IZqshunService ZqshunService;

    /**
     * controller
     * uploadify--oss--图片上传
     * @param imgs
     * @param request
     * @param response
     * @return
     * @throws IOException  抛异常
     */
    @RequestMapping("uploadImg")
    public  String uploadImg(MultipartFile imgs, HttpServletRequest request,HttpServletResponse response) throws IOException{
        String uploadImg = ZqshunService.uploadImg(imgs);
        System.out.println(uploadImg);

        return uploadImg ;
    }


        //班型查询
    @RequestMapping("querybanxing")
    public Map<String,Object> querybanxing(Integer page,Integer rows,BanXing banxing){
        Map<String,Object> list = ZqshunService.querybanxing(page,rows,banxing);
        return list;
    }

    
    /**
    * @Description: TODO
    * @param ${tags} 
    * @return ${return_type} 
    * @throws
    * @author 赵清顺
    * @date2018/8/10 0010 15:46 
    */
    //班型删除
    @RequestMapping("deletebanxing")
    public String deletebanxing(String ids){

        ZqshunService.deletebanxing(ids);
        return "1";
    }

    //班型新增
    @RequestMapping("addbanxing")
    public String addbanxing(BanXing banxing){

        ZqshunService.addbanxing(banxing);
        return "1";
    }

    /**
     * @Author 赵清顺
     * @Description //班型修改
     * @Date 15:53 2018/8/10 0010
     * @Param
     * @return
     **/
    @RequestMapping("updatebanxing")
    public String updatebanxing(BanXing banXing){

        ZqshunService.updatebanxing(banXing);
        return "1";
    }

    //查询课程管理
    @RequestMapping("querykecheng")
    public Map<String,Object> querykecheng(Integer page, Integer rows, KeCheng kecheng){
        Map<String,Object> list = ZqshunService.querykecheng(page,rows,kecheng);
        return list;
    }

    //课程管理删除
    @RequestMapping("deletekecheng")
    public String deletekecheng(String ids){
        ZqshunService.deletekecheng(ids);
        return "1";
    }

    //课程管理新增
    @RequestMapping("addkecheng")
    public String addkecheng(KeCheng keCheng){

        ZqshunService.addkecheng(keCheng);
        return "1";
    }

    //课程管理修改
    @RequestMapping("updatekecheng")
    public String updatekecheng(KeCheng keCheng){
        ZqshunService.updatekecheng(keCheng);
        return "1";
    }
    //章节管理查询
    @RequestMapping("queryzhangjie")
    public List queryzhangjie(){
        List list = ZqshunService.queryzhangjie();
        return list;
    }
   /* @RequestMapping("queryzhangjie")
    public Map<String,Object> queryzhangjie(Integer page, Integer rows, ZhangJie zhangJie){
        Map<String,Object> list = ZqshunService.queryzhangjie(page,rows,zhangJie);
        return list;
    }*/



}
