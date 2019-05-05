package com.orderManager.configrations;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 支付宝支付的参数配置
 *
 * @author Suoron
 */
@Component
public class AlipayProperties {

    /** 支付宝gatewayUrl */
    private String gatewayUrl="https://openapi.alipaydev.com/gateway.do";
    /** 商户应用id */
    private String appid="2016100100637998";
    /** RSA私钥，用于对商户请求报文加签 */
    private String privateKey="MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCnNDNCdSqv2hdxCJUyPgI43etIJdq+OpUEOYCI5L5td+NqhTzXZy9PB0/FT7dM/ZoTJldhAlHjRUkka6VoHZ0TdO654atbiPVcORfD9GHA7qIWB/ezSNt0IPMxWBHEa2J1fqTvMR7qhLn7Z2ZIQM0CjueIttK/pSqCeCVsRM7g9fvFyNR0ffKIiG2QKiu8uPNyClYKn1N9ZamnfJ/3EMrdw/MsxCqjMr3Hv2Hrb268RJI+9TabxpZy7YHBehRMocIGUr7xXbNXg59SP+Z5Fm7RDrCMnGtTdtd6UYpjxknuo5ufjNER5v0J+mTJ7aXm4pMMt++COkNdReKqjyEllnjhAgMBAAECggEAI7aElFdOTM06YIxCwb543wiXbouXUzZUCdj2WUbyXZNT4bafrip98lVPdod2UV2BgUGZPEEwmGh+HOdZJwncOQGq080duqlgLtiK+PHDx1+xAx+kioivRviauRlkgh2lpA7uz6AgSFsdFlOZhylAIKHBVnQmQ4TVtZRP+fYgce//+qUBnipG18sral8giD8dyEBu3iRS51DL2PfCM2hL0E3ChzfLk3VtaBpJHa62MCraCO89NIEoicpnzfhzNn+Kpv+kmHrrSJcXLGtUHAjwEtpV85pmcLsNlQYWBMi8tWbSz0BlyHuSpqhuXxHDlduW8TaPABhKlI2zcDWyuIHRmQKBgQDQdu1b3tC1xKWgTsd2zm4EtkwLv+sfIMEeJQ2irCAjDDZnzNMjtBBNdNN0Kba2hV0XLF0Is93o6n7jUMymPqMOT00PdvkM7JcBBsi7R4fe3XcNYdsTdFGHhew+9qlA34BLNZTK7iQjNx+vE2iJKb0Sduqt1COwUU4HznMf70bsmwKBgQDNVLEJjZhex7nsbVc94qGVBbvkalIo9OFZxQKgxOCmMr6wMIhBzLKST+2NahZI+AKLNPQFT3zB9kEpWfVtfRnbgB2BGL4MOC+Fd9xBxeSD9U3Pm9gFHVXYBLcGPm2DZ87ti75cOZvy+/JbKIbkfaodVoiGbqQBBG2hw+lUPMZiMwKBgQDOO0l4oMbze/aq0CTueSxIRxyWZygxJFNJAjkqHISyh4tvRyf+Y03ZguEKQ5Y5nVhJ656iVGcN3KbpNW8wbDkdmABRc07RpWGCJ3cAJ7TYG1qDB7MW3PUnUKs2YwlwX2vpe7mWxN9FY2xZ5KZ/Q6aEFNb4Xy1rahP7Dxe/mRUeTwKBgQCRuXmr/gIVwkoBsdgo458p1Ff1VD/bMXB99YRX9WI6kekjwk3x5QUXMgK2SoRmZR3pDjvhSPiR7+NvJZk5i3++eL530MeQhI+1ecuoInp77Ky8my5E8vzpwu7iT4wJprMFhBgl+/ziBk2KxMh3gXgqOi/KuNtMnYfxNslyL2/cYQKBgQCHndL2o1p+VbfY83O2pOKS1NF3f81Yw9uTwwYgP+YqhjGjoeKSiFtEqN5ZUgnQuEscdeNto5aR1Wcu1p4XxUlQNoumVzjlJPTKmWNVIT7Am+gfgBcqnTlM78++mlck7g5cUMuad+SDFYPyMke3pWdZ1wvnYeYwDhlsRPTp3PSCoA==";
    /** 支付宝RSA公钥，用于验签支付宝应答 */
    private String alipayPublicKey="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAra/8q9I/0a6F78N1pdPYiI3EcPVI4KRLSxrIniU7gGeFadCuJNe3pkM/X2KIKw7T2EYjdfH+451VQOrxVoQdnGcJwFZxBLM4hYgmQrgXmusLLH9yYw2fU+M6NJ7cgejYQuMO9QRaUlRdagHUCu4lHbTAcudr9cNkdckIsVc7zOwGysJlevS+cLTBbeIHuErowu3O72BDKYujpFYNecRruT8jI3fGErXvx1/y4b1Gl9v6bvo8lzQjXoLBGcCkc5ck5YovWXY5/qRvJryXr+SYQ/PsBqZerqcda9jUpGtrKB2fff/fn4VCah+nNcX6HyzeLWBI9uq8/NdNppimufxIfQIDAQAB";
    /** 签名类型 */
    private String signType = "RSA2";

    /** 格式 */
    private String formate = "json";
    /** 编码 */
    private String charset = "UTF-8";

    /** 同步地址 */
    private String returnUrl="http://72cf838a.ngrok.io/ticket/ordersubmit.html";

    /** 异步地址 */
    private String notifyUrl="http://72cf838a.ngrok.io/ticket/alipay";

    /** 最大查询次数 */
    private static int maxQueryRetry = 5;
    /** 查询间隔（毫秒） */
    private static long queryDuration = 5000;
    /** 最大撤销次数 */
    private static int maxCancelRetry = 3;
    /** 撤销间隔（毫秒） */
    private static long cancelDuration = 3000;

    private AlipayProperties() {}

    /**
     * PostContruct是spring框架的注解，在方法上加该注解会在项目启动的时候执行该方法，也可以理解为在spring容器初始化的时候执行该方法。
     */
    public String description() {
        StringBuilder sb = new StringBuilder("\nConfigs{");
        sb.append("支付宝网关: ").append(gatewayUrl).append("\n");
        sb.append(", appid: ").append(appid).append("\n");
        sb.append(", 商户RSA私钥: ").append(getKeyDescription(privateKey)).append("\n");
        sb.append(", 支付宝RSA公钥: ").append(getKeyDescription(alipayPublicKey)).append("\n");
        sb.append(", 签名类型: ").append(signType).append("\n");

        sb.append(", 查询重试次数: ").append(maxQueryRetry).append("\n");
        sb.append(", 查询间隔(毫秒): ").append(queryDuration).append("\n");
        sb.append(", 撤销尝试次数: ").append(maxCancelRetry).append("\n");
        sb.append(", 撤销重试间隔(毫秒): ").append(cancelDuration).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String getKeyDescription(String key) {
        int showLength = 6;
        if (!StringUtils.isEmpty(key) && key.length() > showLength) {
            return new StringBuilder(key.substring(0, showLength)).append("******")
                    .append(key.substring(key.length() - showLength)).toString();
        }
        return null;
    }

    @Override
    public String toString() {
        return "AlipayProperties{" +
                "gatewayUrl='" + gatewayUrl + '\'' +
                ", appid='" + appid + '\'' +
                ", privateKey='" + privateKey + '\'' +
                ", alipayPublicKey='" + alipayPublicKey + '\'' +
                ", signType='" + signType + '\'' +
                ", formate='" + formate + '\'' +
                ", charset='" + charset + '\'' +
                ", returnUrl='" + returnUrl + '\'' +
                ", notifyUrl='" + notifyUrl + '\'' +
                '}';
    }

    public String getGatewayUrl() {
        return gatewayUrl;
    }

    public void setGatewayUrl(String gatewayUrl) {
        this.gatewayUrl = gatewayUrl;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getAlipayPublicKey() {
        return alipayPublicKey;
    }

    public void setAlipayPublicKey(String alipayPublicKey) {
        this.alipayPublicKey = alipayPublicKey;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getFormate() {
        return formate;
    }

    public void setFormate(String formate) {
        this.formate = formate;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public static int getMaxQueryRetry() {
        return maxQueryRetry;
    }

    public static void setMaxQueryRetry(int maxQueryRetry) {
        AlipayProperties.maxQueryRetry = maxQueryRetry;
    }

    public static long getQueryDuration() {
        return queryDuration;
    }

    public static void setQueryDuration(long queryDuration) {
        AlipayProperties.queryDuration = queryDuration;
    }

    public static int getMaxCancelRetry() {
        return maxCancelRetry;
    }

    public static void setMaxCancelRetry(int maxCancelRetry) {
        AlipayProperties.maxCancelRetry = maxCancelRetry;
    }

    public static long getCancelDuration() {
        return cancelDuration;
    }

    public static void setCancelDuration(long cancelDuration) {
        AlipayProperties.cancelDuration = cancelDuration;
    }
}