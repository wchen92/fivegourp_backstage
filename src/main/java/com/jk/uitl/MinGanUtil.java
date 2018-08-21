package com.jk.uitl;


import com.jk.mapper.zqshun.IZqshunMapper;
import com.jk.model.MinGanCi;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @ 创建者：赵清顺.
 * @ 创建时间：2018/8/21 0021 17:52
 * @ Description：
 * @ Version:
 */
public class MinGanUtil {


    public static  String get1ju(String str,IZqshunMapper zqshunMapper){
        List<MinGanCi> mingan = zqshunMapper.mingan();
        for (MinGanCi minGanCi : mingan) {
            String sttr=minGanCi.getMinganname();
            if(str.indexOf(""+sttr+"")!=-1){
                str=str.replace(""+sttr+"","*");
            }
        }
        return str;
    }



}
