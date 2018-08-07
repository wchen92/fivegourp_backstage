package com.jk.service.lshun;

import com.jk.mapper.lshun.ILshunMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ 创建者：王晨.
 * @ 创建时间：2018/8/7 19:29
 * @ Description：
 * @ Version:
 */
@Service
public class LshunServiceImpl implements ILshunService{
    @Resource
    private ILshunMapper LshunMapper;
}
