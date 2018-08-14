package com.jk.controller.zqshun.index;

import com.jk.model.BanXing;
import com.jk.model.KeCheng;
import com.jk.model.ZhangJie;
import com.jk.service.zqshun.IZqshunService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ 创建者：王晨.
 * @ 创建时间：2018/8/7 19:27
 * @ Description：
 * @ Version:
 */
@Controller
@RequestMapping("zqshunindex")
public class ZqsIndexController {

    @Resource
    private IZqshunService ZqshunService;

    //返回zqshun/banxing 班型页面
        @RequestMapping("banxing")
        public String test(){
            return "zqshun/banxing";
        }
    //返回zqshun/banxingadd 班型新增页面
        @RequestMapping("banxingadd")
        public String addbanxing(){
            return "zqshun/banxingadd";
        }

    //返回修改页面
        @RequestMapping("selectbanxing")
        public String selectbanxing(String zid, Model model){
            BanXing banxing = ZqshunService.selectbanxing(zid);
            model.addAttribute("banxing",banxing);

            return "zqshun/updatebanxing";
        }
    //返回课程页面zqshun/kecheng
        @RequestMapping("kecheng")
        public String kecheng(){
            return "zqshun/kecheng";
        }


    //返回课程新增页面  kechengadd
        @RequestMapping("kechengadd")
        public String kechengadd(){
            return "zqshun/kechengadd";
        }

    //课程管理返回回显页面
        @RequestMapping("selectkecheng")
        public String selectkecheng(String sid,Model model){
            KeCheng keCheng = ZqshunService.selectkecheng(sid);
            model.addAttribute("keCheng",keCheng);
            return "zqshun/keChengupdate";
        }

    //返回章节页面zqshun/zhangjie
        @RequestMapping("zhangjie")
        public String zhangjie(){
            return "zqshun/zhangjie";
        }


    //返回章节新增页面
        @RequestMapping("zhangjieadd")
        public String zhangjieadd(){

            return "zqshun/zhangjieadd";
        }
    //返回章节回显页面
    @RequestMapping("zhangjieupdate")
    public String zhangjieupdate(String zjid,Model model){
        ZhangJie zhangJie = ZqshunService.zhangjieupdate(zjid);
        model.addAttribute("zhangJie",zhangJie);
            return "zqshun/updatezhangjie";
    }
  //返回课程下所属章节
    @RequestMapping("selectzhangjie")
    public String selectzhangjie(String ids,Model model){
        List kecheng = ZqshunService.selectzhangjie(ids);
        model.addAttribute("zhangJie",kecheng);
        return "zqshun/kechengandzhangjie";
    }


}
