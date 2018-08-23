package com.jk.controller.wchen;

import com.jk.model.Log;
import com.jk.model.PlTokc;
import com.jk.model.User;
import com.jk.service.wchen.IWchenService;
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
    @RequestMapping("selectlog")
    public Map<String,Object> selectlog(Integer page, Integer rows){
        return WchenService.selectlog(page,rows);
    }
    @RequestMapping("addkctopinlun")
    public String addkctopinlun(String kcid, String juzito){
         String userid = "1";
        kcid= "4c2cf5981cb74f08a91fc2cd09511b0c";
        juzito = "傻逼傻逼";
        WchenService.addkctopinlun(kcid,juzito,userid);
        return  "评论成功";
    }
    @RequestMapping("selectkctopl")
    public List<PlTokc> selectkctopl(String kcid){
        kcid= "4c2cf5981cb74f08a91fc2cd09511b0c";
        return  WchenService.selectkctopl(kcid);
    }
}
