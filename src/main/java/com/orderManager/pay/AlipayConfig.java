package com.orderManager.pay;

import org.springframework.stereotype.Component;

@Component
public class AlipayConfig {
    // 商户ID
    private String appid = "2016100100637998";
    // 私钥
    private String rsa_private_key = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCnNDNCdSqv2hdxCJUyPgI43etIJdq+OpUEOYCI5L5td+NqhTzXZy9PB0/FT7dM/ZoTJldhAlHjRUkka6VoHZ0TdO654atbiPVcORfD9GHA7qIWB/ezSNt0IPMxWBHEa2J1fqTvMR7qhLn7Z2ZIQM0CjueIttK/pSqCeCVsRM7g9fvFyNR0ffKIiG2QKiu8uPNyClYKn1N9ZamnfJ/3EMrdw/MsxCqjMr3Hv2Hrb268RJI+9TabxpZy7YHBehRMocIGUr7xXbNXg59SP+Z5Fm7RDrCMnGtTdtd6UYpjxknuo5ufjNER5v0J+mTJ7aXm4pMMt++COkNdReKqjyEllnjhAgMBAAECggEAI7aElFdOTM06YIxCwb543wiXbouXUzZUCdj2WUbyXZNT4bafrip98lVPdod2UV2BgUGZPEEwmGh+HOdZJwncOQGq080duqlgLtiK+PHDx1+xAx+kioivRviauRlkgh2lpA7uz6AgSFsdFlOZhylAIKHBVnQmQ4TVtZRP+fYgce//+qUBnipG18sral8giD8dyEBu3iRS51DL2PfCM2hL0E3ChzfLk3VtaBpJHa62MCraCO89NIEoicpnzfhzNn+Kpv+kmHrrSJcXLGtUHAjwEtpV85pmcLsNlQYWBMi8tWbSz0BlyHuSpqhuXxHDlduW8TaPABhKlI2zcDWyuIHRmQKBgQDQdu1b3tC1xKWgTsd2zm4EtkwLv+sfIMEeJQ2irCAjDDZnzNMjtBBNdNN0Kba2hV0XLF0Is93o6n7jUMymPqMOT00PdvkM7JcBBsi7R4fe3XcNYdsTdFGHhew+9qlA34BLNZTK7iQjNx+vE2iJKb0Sduqt1COwUU4HznMf70bsmwKBgQDNVLEJjZhex7nsbVc94qGVBbvkalIo9OFZxQKgxOCmMr6wMIhBzLKST+2NahZI+AKLNPQFT3zB9kEpWfVtfRnbgB2BGL4MOC+Fd9xBxeSD9U3Pm9gFHVXYBLcGPm2DZ87ti75cOZvy+/JbKIbkfaodVoiGbqQBBG2hw+lUPMZiMwKBgQDOO0l4oMbze/aq0CTueSxIRxyWZygxJFNJAjkqHISyh4tvRyf+Y03ZguEKQ5Y5nVhJ656iVGcN3KbpNW8wbDkdmABRc07RpWGCJ3cAJ7TYG1qDB7MW3PUnUKs2YwlwX2vpe7mWxN9FY2xZ5KZ/Q6aEFNb4Xy1rahP7Dxe/mRUeTwKBgQCRuXmr/gIVwkoBsdgo458p1Ff1VD/bMXB99YRX9WI6kekjwk3x5QUXMgK2SoRmZR3pDjvhSPiR7+NvJZk5i3++eL530MeQhI+1ecuoInp77Ky8my5E8vzpwu7iT4wJprMFhBgl+/ziBk2KxMh3gXgqOi/KuNtMnYfxNslyL2/cYQKBgQCHndL2o1p+VbfY83O2pOKS1NF3f81Yw9uTwwYgP+YqhjGjoeKSiFtEqN5ZUgnQuEscdeNto5aR1Wcu1p4XxUlQNoumVzjlJPTKmWNVIT7Am+gfgBcqnTlM78++mlck7g5cUMuad+SDFYPyMke3pWdZ1wvnYeYwDhlsRPTp3PSCoA==";
    // 异步回调地址
    private String notify_url="http://d6329d0b.ngrok.io/ticket/getSession";
    // 同步回调地址
    private String return_url="http://www.4399.com/";
    // 请求网关地址
    private String gateway_url="https://openapi.alipaydev.com/gateway.do";
    // 编码
    private String charset = "UTF-8";
    // 返回格式
    private String format = "json";
    // 支付宝公钥
    private String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApzQzQnUqr9oXcQiVMj4CON3rSCXavjqVBDmAiOS+bXfjaoU812cvTwdPxU+3TP2aEyZXYQJR40VJJGulaB2dE3TuueGrW4j1XDkXw/RhwO6iFgf3s0jbdCDzMVgRxGtidX6k7zEe6oS5+2dmSEDNAo7niLbSv6UqgnglbETO4PX7xcjUdH3yiIhtkCorvLjzcgpWCp9TfWWpp3yf9xDK3cPzLMQqozK9x79h629uvESSPvU2m8aWcu2BwXoUTKHCBlK+8V2zV4OfUj/meRZu0Q6wjJxrU3bXelGKY8ZJ7qObn4zREeb9Cfpkye2l5uKTDLfvgjpDXUXiqo8hJZZ44QIDAQAB";
    // RSA2
    private String signtype = "RSA2";

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getRsa_private_key() {
        return rsa_private_key;
    }

    public void setRsa_private_key(String rsa_private_key) {
        this.rsa_private_key = rsa_private_key;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getReturn_url() {
        return return_url;
    }

    public void setReturn_url(String return_url) {
        this.return_url = return_url;
    }

    public String getGateway_url() {
        return gateway_url;
    }

    public void setGateway_url(String gateway_url) {
        this.gateway_url = gateway_url;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getAlipay_public_key() {
        return alipay_public_key;
    }

    public void setAlipay_public_key(String alipay_public_key) {
        this.alipay_public_key = alipay_public_key;
    }

    public String getSigntype() {
        return signtype;
    }

    public void setSigntype(String signtype) {
        this.signtype = signtype;
    }
}