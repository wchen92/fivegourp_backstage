package com.jk.controller.zqshun;

import com.jk.service.zqshun.IZqshunService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
}
