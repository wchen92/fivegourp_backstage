package com.jk.controller.wchen;

import com.jk.model.Log;
import com.jk.service.wchen.IWchenService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
}
