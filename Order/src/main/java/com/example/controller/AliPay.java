package com.example.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/Boot")
public class AliPay {

    private final String APP_ID = "2016101000649437";
    private final String APP_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCWg0Lx5m46dNUfqiZpTRXZmNI3lKQCyEUyTpj/nUEwzU530Kxon27fgvYncb4GZwUGl8yzNuKlOb29rid5Gj0d/lcrKDcwtgEAr+l1KS4GKHTEEblixqZbLQ3n89DrkXvdx3byzwRStOWjIFT5KHVC/1pLZJzE01XrZJzDbI1eOtk+N607kJqSQ/+Ff1iz8GatzLUvR4xNtq6ygsMhIBLPwRweww4/+gLN86UO+fwo2BJVk5p/ys79OV3LR6xo1J4fuc/d9Op8P61ZZw7tLRAfENtq+x2xFYSkb9vXkmqDo1jIxfVIaQUfQihMuHoaO/BK55BF9snI1EHvYmcmtWKrAgMBAAECggEAbyYd8N93NUoD/S880HRxl1BIpWzqNXfJyd3LFLD/bFehA9AhEd3zFbHzr6tKZhX72yOMsifs9ZEPcpzCX6clzRl/K8q1/w3Y7bX6lF/Fshx8JjLkkXIbdadu5oTiGqREMcJUL/j6u00FbBK7TYg4GDLUbmqtbpiWkY+qSJLITvXJsCxJchJC7jBbqab3Z0LyJgKkdsy0e5P8p8cqKm+m/2I5qmLNvnv4BRWsXx77x8zwMZO9ZA3tI+VC9zz8Nwz/3Mt/AAJEFoj+K587e/h7d3zjXkTiJ/Y1zv5aYhup4u9qpX6b5iliYAA0MZS6YEiV3FzhbRUa6alti+HZhCL/2QKBgQDTgyWtlheZAVf7XuQADzwRoF+VHHTtn6i39oinIhcFE+fHmIA2lWQFwT1JrFaMXX19HoSVjzcuZo3/ms1A64ik5hHbddexOs+4p6CafsCMDKAGrVdFGDGGaf7U5ARzHFU10o+BIBlftrMP4AcmV91d41OXvn7VC3aJD90QsnMCxQKBgQC2K5neb7zCqPTO6/KB+vMBoBd38nG9V5VOoe6ZelTMVqW+8pmR3QzPn1dah4wZfZqOHR0Vn8re5T/U17l62wGDNIHlsZXHLnaRwpVYgwhD8PdkvQECYAv6b0B6NCU6No4IG2WqnsfKeHN7lZItUzg3YxKZatgFKkQpav/yusxmrwKBgBPL9JzYrYC+pXN7oC95PZAQyKF2NmN/TBVb19J82Fa7VDhUR7vUI7Z+LbRVkww0O+iYEKTG8M1BAA1qeceXxARbHFTEJNoLvSF1XwzWzELPc7LsSnzHFOuVxCo85UW44yjUemYFkRpqSTw1JbYrBycgfdR4Gfrqxb9yYqiLa0RZAoGBAKWbOYQnXBgydGrvwEQ9mFBv8yXNt2yDhG45c6j+trwUQRU3gjhCFfVhS443DzvVHX34JYqU+15qVf7uJeXz1ooqX7QqHpk2OgAEPrR6Wjc5hg2EbLh2DC2cmab+ZKFpGvFvxpq3QbVkjsdYj8y4jLB9Vlk18i+v3sswRIGrI0ptAoGAE2+ZTBtVPr0qjSlPK2QILX4SLpFTkt1HOp30evohz3YoX4BvXBxThtMlv6ZyXbtpXl5ZVmKlwRG8SkuQr+5xVg7oLyUmxdtYIca0JkfPK+vVmJqfzt8VlosN5DNk1CliFKg2U0eK79aNsNq30WO1l8FJIl6MSymamSzZFjEQ6Xk=";
    private final String CHARSET = "UTF-8";
    private final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAj+65NstdS8If4xLseFsorcHlhMEsq8ahXhxs6LXbSbFO/Z4j0FYegs2OxZfZSgBNGPtKnwgJWCaAkAd6Fw4+E64SkvImj9yYtUXRED0GtN5Kf8112yS9FfJzCAKSz9Vdp8/hjXzMdZAC2dmf31VONPRbnuyAM1KCKpttFWZc1/soyf4cwykOQb/StNZGCMcCGKYNLGCnw3TwebHJ/jbUKtOEQ3TjN/E0rk025k5Bqb2FkYefp4Xy5ZobkoAPUCZMCR79qLQ/ZOdEoZGQ8frW+GZT+i9RJvyJFOIssTU+u9k+DUh6NAXfp2AQwaG1HYf3Eu20V2W5JMWhj2McuZqSZwIDAQAB";
    //这是沙箱接口路径,正式路径为https://openapi.alipay.com/gateway.do
    private final String GATEWAY_URL ="https://openapi.alipaydev.com/gateway.do";
    private final String FORMAT = "JSON";
    //签名方式
    private final String SIGN_TYPE = "RSA2";
    //支付宝异步通知路径,付款完毕后会异步调用本项目的方法,必须为公网地址
    private final String NOTIFY_URL = "http://1.83.234.133/notifyUrl";
    //支付宝同步通知路径,也就是当付款完毕后跳转本项目的页面,可以不是公网地址
    private final String RETURN_URL = "http://localhost:8081/Boot/returnUrl";


    @RequestMapping("/alipay")
    public void alipay(HttpServletResponse httpResponse) throws IOException {

        Random r=new Random();
        //实例化客户端,填入所需参数
        AlipayClient alipayClient = new DefaultAlipayClient(GATEWAY_URL, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE);
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        //在公共参数中设置回跳和通知地址
        request.setReturnUrl(RETURN_URL);
        request.setNotifyUrl(NOTIFY_URL);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        //生成随机Id
        String out_trade_no = UUID.randomUUID().toString();
        //付款金额，必填
        String total_amount =Integer.toString(100);
        //订单名称，必填
        String subject ="奥迪A8 2016款 A8L 60 TFSl quattro豪华型";
        //商品描述，可空
        String body = "尊敬的会员欢迎购买奥迪A8 2016款 A8L 60 TFSl quattro豪华型";
        request.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        String form = "";
        try {
            form = alipayClient.pageExecute(request).getBody(); // 调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + CHARSET);
        httpResponse.getWriter().write(form);// 直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }



    @RequestMapping(value = "/returnUrl", method = RequestMethod.GET)
    @ResponseBody
    public String returnUrl(HttpServletRequest request, HttpServletResponse response)
            throws IOException, AlipayApiException {
        System.out.println("=================================同步回调=====================================");

        // 获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("utf-8"), "utf-8");
            params.put(name, valueStr);
        }

        System.out.println(params);//查看参数都有哪些
        boolean signVerified = AlipaySignature.rsaCheckV1(params, ALIPAY_PUBLIC_KEY, CHARSET, SIGN_TYPE); // 调用SDK验证签名
        //验证签名通过
        if(signVerified){
            // 商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");

            System.out.println("商户订单号="+out_trade_no);
            System.out.println("支付宝交易号="+trade_no);
            System.out.println("付款金额="+total_amount);

            //支付成功，修复支付状态
           // payService.updateById(Integer.valueOf(out_trade_no));
            return "ok";//跳转付款成功页面
        }else{
            return "no";//跳转付款失败页面
        }

    }

}
