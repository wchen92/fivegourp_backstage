package com.jk.service.tysheng;

import com.jk.model.JiangShi;
import com.jk.model.ZhangJie;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ITyshengService {


    /**
     * 　　* @Description: TODO
     * 　　* @param ${tags}
     * 　　* @return ${return_type}
     * 　　* @throws
     * 　　* @author 谭永生
     * 　　* @date 2018/8/10 15:36
     *
     */
    Map<String, Object> queryjslist2(Integer page, Integer rows, JiangShi teacher);

    /**
     * 　　* @Description: 教师表的新增
     * 　　* @param ${tags}
     * 　　* @return ${return_type}
     * 　　* @throws
     * 　　* @author 谭永生
     * 　　* @date 2018/8/10 15:36
     *
     */
    void saveteacher(JiangShi teacher);


    /**
     * 　　* @Description: 教师表的修改之查询
     * 　　* @param ${tags}
     * 　　* @return ${return_type}
     * 　　* @throws
     * 　　* @author 谭永生
     * 　　* @date 2018/8/10 21:08
     *
     */
    JiangShi queryteacherbyid(String teacherid);

    /**
     * 　　* @Description: 教师表的删除
     * 　　* @param ${tags}
     * 　　* @return ${return_type}
     * 　　* @throws
     * 　　* @author 谭永生
     * 　　* @date 2018/8/10 21:59
     *
     */
    void deleteteacher(String ss);

    /**
     * 　　* @Description: 教师表修改的保存
     * 　　* @param ${tags}
     * 　　* @return ${return_type}
     * 　　* @throws
     * 　　* @author 谭永生
     * 　　* @date 2018/8/10 21:59
     *
     */
    void updateteacher(JiangShi teacher);

    /**
     * 　　* @Description: 章节表的数据查询
     * 　　* @param ${tags}
     * 　　* @return ${return_type}
     * 　　* @throws
     * 　　* @author 谭永生
     * 　　* @date 2018/8/11 9:05
     *
     */
    Map<String, Object> queryzjlist(Integer page, Integer rows, ZhangJie zj);

    /**
     * 　　* @Description: 章节表是数据删除
     * 　　* @param ${tags}
     * 　　* @return ${return_type}
     * 　　* @throws
     * 　　* @author 谭永生
     * 　　* @date 2018/8/11 10:12
     *
     */
    void deletesection(String ss);

    /**
     * 　　* @Description: 章节表的数据新增
     * 　　* @param ${tags}
     * 　　* @return ${return_type}
     * 　　* @throws
     * 　　* @author 谭永生
     * 　　* @date 2018/8/11 10:22
     *
     */
    void savesection(ZhangJie zj);

    /**
     * 　　* @Description: 章节表根据ID的修改之查询
     * 　　* @param ${tags}
     * 　　* @return ${return_type}
     * 　　* @throws
     * 　　* @author 谭永生
     * 　　* @date 2018/8/11 10:40
     *
     */
    ZhangJie querysectionbyid(String zhangjieid);

    /**
     * 　　* @Description:章节表的修改保存
     * 　　* @param ${tags}
     * 　　* @return ${return_type}
     * 　　* @throws
     * 　　* @author 谭永生
     * 　　* @date 2018/8/11 10:53
     *
     */
    void updatesection(ZhangJie zj);

}