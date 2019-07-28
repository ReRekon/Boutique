package com.study.admin.service.Impl;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.study.admin.service.SmsService;

/**
 * @Author zuojh
 * @date 2019/7/27 22:10
 */
public class SmsServiceImpl implements SmsService {
    public static void send(String telephone, String code) {
        //第二个参数为自己独有的accessKeyid，第三个参数为自己独有的accessKeySecret
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou",
                "LTAI81uuxQORTPvP", "6XhQJ6DaBeGUZRcomMam0z7ohTRRSU");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();//组装请求对象
        //request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);//设置post提交
        request.setDomain("dysmsapi.aliyuncs.com");//短信API产品域名（接口地址固定，无需修改）
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", telephone);
        request.putQueryParameter("SignName", "Boutique精品店");//短信签名
        request.putQueryParameter("TemplateCode", "SMS_171352130");
        request.putQueryParameter("TemplateParam", "{code:" + code + "}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}