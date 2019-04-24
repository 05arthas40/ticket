package com.LoginAndRegister.note;

import java.net.URLEncoder;

/**
 * 验证码通知短信接口
 *
 * @ClassName: IndustrySMS
 * @Description: 验证码通知短信接口
 *
 */
public class IndustrySMS
{
    private static String operation = "/industrySMS/sendSMS";

    private static String accountSid = Config.ACCOUNT_SID;
    //测试使用的短信内容，包括验证码(smscontent=【短信签名】+内容，发送内容要与模板匹配。)
    private static String smsContent = "【好玩科技】您的验证码为"+ CodeUtils.Num_code()+"，请于5分钟内正确输入，如非本人操作，请忽略此短信。";
    /**
     * 验证码通知短信
     */
    public static void execute(String toPhoneNuber) {
        String tmpSmsContent = null;
        try{
            tmpSmsContent = URLEncoder.encode(smsContent, "UTF-8");
        }catch(Exception e){

        }
        String url = Config.BASE_URL + operation;
        String body = "accountSid=" + accountSid + "&to=" + toPhoneNuber + "&smsContent=" + tmpSmsContent
                + HttpUtil.createCommonParam();

        // 提交请求
        String result = HttpUtil.post(url, body);
        //System.lineSeparator():换行符,可以剔除平台无关性，在Windows或者Linux都可以用
        System.out.println("result:" + "\n" + result);
//	    System.out.println(new CodeUtils().getCode());
    }
}
