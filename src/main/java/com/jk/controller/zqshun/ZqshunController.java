package com.jk.controller.zqshun;

import com.jk.model.*;
import com.jk.service.zqshun.IZqshunService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
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


        //查询班型管理
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
    //删除班型管理
    @RequestMapping("deletebanxing")
    public String deletebanxing(String ids){

        ZqshunService.deletebanxing(ids);
        return "1";
    }

    //新增班型管理
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

    //删除课程管理
    @RequestMapping("deletekecheng")
    public String deletekecheng(String ids){
        ZqshunService.deletekecheng(ids);
        return "1";
    }

    //新增课程管理
    @RequestMapping("addkecheng")
    public String addkecheng(KeCheng keCheng){

        ZqshunService.addkecheng(keCheng);
        return "1";
    }

    //修改课程管理
    @RequestMapping("updatekecheng")
    public String updatekecheng(KeCheng keCheng){
        ZqshunService.updatekecheng(keCheng);
        return "1";
    }
    //查询章节管理

   @RequestMapping("queryzhangjie")
    public Map<String,Object> queryzhangjie(Integer page, Integer rows, ZhangJie zhangJie){
        Map<String,Object> list = ZqshunService.queryzhangjie(page,rows,zhangJie);
        return list;
    }

    //新增章节管理
    @RequestMapping("addzhangjie")
    public String addzhangjie(ZhangJie zhangJie){

        ZqshunService.addzhangjie(zhangJie);
        return "1";
    }

    //章节视频上传
    @RequestMapping("headImgUpload")
    public HashMap<String, Object> headImgUpload(@RequestParam(value = "addimg_Img", required = false) MultipartFile file,
        HttpServletRequest request, HttpServletResponse response) throws IOException {
        HashMap<String, Object> uploadImg = ZqshunService.Upload(file);
        System.out.println(uploadImg);
        return uploadImg ;
    }

    //删除章节管理
    @RequestMapping("deletezhangcheng")
    public String deletezhangcheng(String ids){
        ZqshunService.deletezhangcheng(ids);
        return "1";
    }

    //修改章节管理
    @RequestMapping("updatezhangjie")
    public String updatezhangjie(ZhangJie zhangJie){
        ZqshunService.updatezhangjie(zhangJie);
        return "1";
    }

    //过滤敏感词
    @RequestMapping("mingan")
    public String mingan(){
        String str = "小明死了母亲，大傻逼";
        ZqshunService.mingan(str);
        return "1";
    }

    @RequestMapping("selecthy")
    public Integer selecthy(String id){
        Integer user=2;
        if(id!=null&&!"".equals(id)){
             user = ZqshunService.selecthy(id);
        }
        return user;
    }

   @RequestMapping("selecttiche")
    public List<JiangShi> selecttiche(){
        return ZqshunService.selecttiche();
   }

   @RequestMapping("selectbanxing")
    public List<BanXing> selectbanxing(){
        return ZqshunService.selectkctobanxing();
   }
}
