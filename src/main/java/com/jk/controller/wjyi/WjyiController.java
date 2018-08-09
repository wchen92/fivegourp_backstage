package com.jk.controller.wjyi;

import com.jk.model.Power;
import com.jk.service.wjyi.IWjyiService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ 创建者：王晨.
 * @ 创建时间：2018/8/7 19:26
 * @ Description：
 * @ Version:
 */
@RestController
@RequestMapping("wjyi")
public class WjyiController {
    @Resource
    private IWjyiService WjyiService;

    /**
     * 查询权限树
     * @return
     */
    @RequestMapping("queryTree")
    @ResponseBody
    public  List<Power> queryTree(){
        List<Power> treelist = WjyiService.queryTree();
        return treelist;
    }
}
