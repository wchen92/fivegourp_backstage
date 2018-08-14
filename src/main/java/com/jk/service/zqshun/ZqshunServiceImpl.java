package com.jk.service.zqshun;

import com.jk.mapper.zqshun.IZqshunMapper;
import com.jk.model.BanXing;
import com.jk.model.KeCheng;
import com.jk.model.ZhangJie;
import com.jk.uitl.OSSClientUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

    //班型分页查询
    @Override
    public Map<String,Object> querybanxing(Integer page,Integer rows,BanXing banxing) {
        HashMap<String, Object> stirngObjectHashMap = new HashMap<String, Object>();
        int start = (page-1)*rows;
        List<BanXing> userlist = ZqshunMapper.querybanxing(page,rows,banxing);

        stirngObjectHashMap.put("rows",userlist);
        long total = ZqshunMapper.total(banxing);
        stirngObjectHashMap.put("total",total);
        return stirngObjectHashMap;
    }

    //班型删除
    @Override
    public void deletebanxing(String ids) {
        ZqshunMapper.deletebanxing(ids);
    }

    //班型新增
    @Override
    public void addbanxing(BanXing banxing) {
        banxing.setBanxingid(UUID.randomUUID().toString().replaceAll("-",""));
        ZqshunMapper.addbanxing(banxing);
    }
    //班型回显
    @Override
    public BanXing selectbanxing(String zid) {

        return ZqshunMapper.selectbanxing(zid);
    }

    //班型修改
    @Override
    public void updatebanxing(BanXing banXing) {

        ZqshunMapper.updatebanxing(banXing);
    }
    //课程查询
    @Override
    public Map<String, Object> querykecheng(Integer page, Integer rows, KeCheng kecheng) {
        HashMap<String, Object> stirngObjectHashMap = new HashMap<String, Object>();
        int start = (page-1)*rows;
        List<KeCheng> userlist = ZqshunMapper.querykecheng(page,rows,kecheng);
        stirngObjectHashMap.put("rows",userlist);
        long total = ZqshunMapper.totalkecheng(kecheng);
        stirngObjectHashMap.put("total",total);
        return stirngObjectHashMap;
    }

    //课程删除
    @Override
    public void deletekecheng(String ids) {
        ZqshunMapper.deletekecheng(ids);
    }

    //课程新增
    @Override
    public void addkecheng(KeCheng keCheng) {

        keCheng.setKechengid(UUID.randomUUID().toString().replaceAll("-",""));
        keCheng.setShenhestatus("2");
        ZqshunMapper.addkecheng(keCheng);
    }

    //课程回显
    @Override
    public KeCheng selectkecheng(String sid) {
        return ZqshunMapper.selectkecheng(sid);
    }

    //课程修改
    @Override
    public void updatekecheng(KeCheng keCheng) {
        ZqshunMapper.updatekecheng(keCheng);
    }

    @Override
    public String uploadImg(MultipartFile file) throws IOException{
        if (file == null || file.getSize() <= 0) {
            throw new IOException("file不能为空");
        }
        OSSClientUtil ossClient=new OSSClientUtil();
        String name = ossClient.uploadImg2Oss(file);
        String imgUrl = ossClient.getImgUrl(name);
        String[] split = imgUrl.split("\\?");

        return split[0];
    }

    @Override
    public Map<String, Object> queryzhangjie(Integer page, Integer rows, ZhangJie zhangjie) {


        return null;
    }


}
