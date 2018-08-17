package com.jk.service.lshun;

import com.jk.mapper.lshun.ILshunMapper;
import com.jk.model.*;
import com.jk.uitl.OSSClientUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

/**
 * @ 创建者：王晨.
 * @ 创建时间：2018/8/7 19:29
 * @ Description：
 * @ Version:
 */
@Service
public class    LshunServiceImpl implements ILshunService{
    @Resource
    private ILshunMapper LshunMapper;

    //登陆
    @Override
    public Map<String, Object> login(User people) {
        String flag = "0";
        Map<String, Object> map = new HashMap<>();
        User user2 = LshunMapper.queryUserByName(people.getText());
        if (user2 != null) {
            flag = "1";
            if (user2.getPassword().equals(people.getPassword())) {
                flag = "2";
                map.put("user2", user2);
            }else {
                flag = "3";
                map.put("user2", user2);
            }
        }
        map.put("flag", flag);
        return map;
    }
    //查询广告
    @Override
    public Map<String, Object> queryAdvertisementList(int page, int rows, GuangGaoBiao guanggao) {
        Long total = LshunMapper.queryAdvertisementCount(guanggao);
        int start = (page - 1) * rows;
        int end = start + rows;
        List<GuangGaoBiao> list = LshunMapper.queryAdvertisementList(start, end, guanggao);
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return  map;
    }

    @Override
    public String uploadImg(MultipartFile imgs) {
        if (imgs == null || imgs.getSize() <= 0) {
            try {
                throw new IOException("file不能为空");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        OSSClientUtil ossClient=new OSSClientUtil();
        String name = null;
        try {
            name = ossClient.uploadImg2Oss(imgs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String imgUrl = ossClient.getImgUrl(name);
        String[] split = imgUrl.split("\\?");

        return split[0];
    }

    @Override
    public void InsertAdvertisementList(GuangGaoBiao guanggao,HttpServletRequest request) {
        guanggao.setGuanggaoid(UUID.randomUUID().toString());
        guanggao.setGuanggaodate(new Date());
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        guanggao.setChuliren(loginUser.getText());
        guanggao.setZhanshistatus(2);
        LshunMapper.InsertAdvertisementList(guanggao);


    }

    @Override
    public void DeleteAdvertisementList(String ids) {
        LshunMapper.DeleteAdvertisementList(ids);
    }

    @Override
    public GuangGaoBiao queryAdvertisementById(String id) {

        return LshunMapper.queryAdvertisementById(id);
    }

    @Override
    public void UpdateAdvertisement(GuangGaoBiao gaoBiao, HttpServletRequest request) {
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        gaoBiao.setChuliren(loginUser.getText());
        gaoBiao.setZhanshistatus(2);
        LshunMapper.UpdateAdvertisement(gaoBiao);
    }

    @Override
    public List<KeCheng> selectkechenglist() {

      return   LshunMapper.selectkechenglist();
    }

    @Override
    public List<ZhangJie> selectdaganglist() {
        return LshunMapper.selectdaganglist();
    }

    @Override
    public List<KeCheng> selectxiangqinglist() {
        return LshunMapper.selectxiangqinglist();
    }

    @Override
    public KeCheng selectpricelist(String wchenkcdi) {
            //查询出课程表的信息
        KeCheng selectkc = LshunMapper.selectkecheng(wchenkcdi);

           //查询浏览次数
        Liuyan selectll = LshunMapper.selectkcorcs(wchenkcdi);

           //查询章节
        List<ZhangJie> orallzj = LshunMapper.selectorzj(wchenkcdi);
           //查询章节数（课时数）
        long ajcount = LshunMapper.selectajcount(wchenkcdi);
           //存入对应的值返回页面
        selectkc.setLiulanliang(selectll.getLiulanshuliang().toString());
        selectkc.setKsshu(ajcount);
        selectkc.setZjlist(orallzj);

        return selectkc;
    }

    @Override
    public String selectshipin(String wchenkcdi) {
        String shipin = LshunMapper.shipinshowselect(wchenkcdi);
        return shipin;
    }

    @Override
    public String selectzhangjieorid(String zhanjieid) {

        return LshunMapper.selectzhangjieorid(zhanjieid);
    }
}
