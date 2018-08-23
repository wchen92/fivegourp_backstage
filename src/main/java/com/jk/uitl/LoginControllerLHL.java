package com.jk.uitl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class LoginControllerLHL {
    static String str = null;

    public String getcode(String phone) {
        HashMap<String, Object> queryMap = new HashMap<String, Object>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String format = sdf.format(new Date());
        queryMap.put("accountSid", "17f2287b249e45448c4d20343c68b836");
        queryMap.put("templateid", "306279818");
        str = createRandomVcode();
        queryMap.put("param", str);
        queryMap.put("to", phone);
        String sig = MD5utlis.getPwd("17f2287b249e45448c4d20343c68b836" + "35efaec5ae16492abe39813b8b1afa97" + format);
        System.out.println(sig);
        queryMap.put("sig", sig);
        queryMap.put("timestamp", format);
        queryMap.put("respDataType", "JSON");
        System.out.println(queryMap);
        String mess = HttpClientUtil.post("https://api.miaodiyun.com/20150822/industrySMS/sendSMS", queryMap);

        System.out.println(mess);
        return str;

    }

    /**
     * 生成验证码
     * @return
     */
    public static String createRandomVcode(){
        //验证码
        String vcode = "";
        for (int i = 0; i < 6; i++) {
            vcode = vcode + (int)(Math.random() * 9);
        }
        return vcode;
    }
}
