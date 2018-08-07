package com.jk.controller.wychao;

import com.jk.service.wychao.IWychaoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ 创建者：王晨.
 * @ 创建时间：2018/8/7 19:27
 * @ Description：
 * @ Version:
 */
@RestController
@RequestMapping("wychao")
public class WychaoController {
    @Resource
    private IWychaoService WychaoServiceL;
}
