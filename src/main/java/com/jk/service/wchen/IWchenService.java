package com.jk.service.wchen;

import com.jk.model.Log;

import java.util.List;
import java.util.Map;

public interface IWchenService
{
    Map<String,Object> selectlog(Integer page, Integer rows);
}
