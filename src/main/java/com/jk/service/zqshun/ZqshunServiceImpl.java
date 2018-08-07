package com.jk.service.zqshun;

import com.jk.mapper.zqshun.IZqshunMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ 创建者：王晨.
 * @ 创建时间：2018/8/7 19:32
 * @ Description：
 * @ Version:
 */
@Service
public class ZqshunServiceImpl implements IZqshunService{
    @Resource
    private IZqshunMapper ZqshunMapper;
}
