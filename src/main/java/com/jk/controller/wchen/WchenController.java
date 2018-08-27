package com.jk.controller.wchen;

import com.jk.mapper.zqshun.IZqshunMapper;
import com.jk.model.*;
import com.jk.service.wchen.IWchenService;
import com.jk.uitl.MinGanUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @ 创建者：王晨.
 * @ 创建时间：2018/8/10 15:19
 * @ Description：
 * @ Version:
 */
@RestController
@RequestMapping("wchencontroller")
public class WchenController {
    @Resource
    private IWchenService WchenService;
    @Resource
    private IZqshunMapper ZqshunMapper;
    @RequestMapping("selectlog")
    public Map<String,Object> selectlog(Integer page, Integer rows){
        return WchenService.selectlog(page,rows);
    }
    @RequestMapping("addkctopinlun")
    public String addkctopinlun(String kcid, String juzito,HttpServletRequest request){
        QianTaiYongHu yh = (QianTaiYongHu) request.getSession().getAttribute("loginYonghu");
         String userid = yh.getYonghuid();
        String ju = MinGanUtil.get1ju(juzito, ZqshunMapper);
        WchenService.addkctopinlun(kcid,ju,userid);
        return  "评论成功";
    }
    @RequestMapping("selectkctopl")
    public List<PlTokc> selectkctopl(String kcid){
        return  WchenService.selectkctopl(kcid);
    }

    //查询页面头部信息
    @RequestMapping("selecttitle")
    public QianTaiYongHu selecttitle(HttpServletRequest request){
        QianTaiYongHu yh = (QianTaiYongHu) request.getSession().getAttribute("loginYonghu");
        String showuserid = yh.getYonghuid();
        return WchenService.selecttitle(showuserid);
    }

    //全部公司查询展示对应班型
    @RequestMapping("allselectbanxing")
    public List<BanXing> allselectbanxing(){
        List<BanXing> allselectbanxing = WchenService.allselectbanxing();
        return allselectbanxing;
    }
    //全部公司查询展示全部老师
    @RequestMapping("allselectjiaoshi")
    public List<JiangShi> allselectjiaoshi(){
        List<JiangShi> allselectjiaoshi = WchenService.allselectjiaoshi();
        return allselectjiaoshi;
    }
}
