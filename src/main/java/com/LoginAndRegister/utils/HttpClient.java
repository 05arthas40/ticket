package com.LoginAndRegister.utils;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * Http请求工具类
 */
public class HttpClient{
    /**
     * 创建一个get连接
     * @param url 请求路径
     */
    public static String createHttpConnectionByGet(String url){
        //创建一个默认的http请求对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //通过传递第三方接口URL，创建请求方式为get请求
        HttpGet get=new HttpGet(url);
        //设置请求头，告诉第三方接口服务器保持长连接
        get.setHeader("connection","keep-alive");
        //欺骗服务器，让它以为访问的是浏览器（传递的参数的浏览器内核参数）
        get.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) " +
                "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
        CloseableHttpResponse execute =null;
        String str=null;
        try {
            //请求第三方接口
            execute=httpClient.execute(get);
            //获取数据
            HttpEntity entity = execute.getEntity();
            System.out.println(entity.getContentType());
            //解析成字符串
             str = EntityUtils.toString(entity);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
           if(httpClient!=null) {
               //关闭连接
               try {
                   httpClient.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
           if(execute!=null){
               try {
                   execute.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
        }
        return str;
    }

    /**
     * 创建一个post请求
     * @param url
     */
   public static <T>String createHttpConnectionByPost(String url,T data){
       CloseableHttpClient httpClient = HttpClients.createDefault();
       HttpPost httpPost=new HttpPost(url);
       httpPost.setHeader("connection","keep-alive");
       httpPost.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) " +
               "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
       httpPost.addHeader("Content-Type", "application/json");
       //添加参数
       String s = JSON.toJSONString(data);
       StringEntity stringEntity=new StringEntity(s,"utf-8");
//       List<BasicNameValuePair>list=new ArrayList<>();
//       list.add(new BasicNameValuePair("id","1"));
       String str=null;
       CloseableHttpResponse httpResponse=null;
       try {
           //设置请求参数
           httpPost.setEntity(stringEntity);
            httpResponse = httpClient.execute(httpPost);
           HttpEntity entity = httpResponse.getEntity();
            str = EntityUtils.toString(entity);
       } catch (IOException e){
           e.printStackTrace();
       }finally {
           if(httpClient!=null) {
               try {
                   httpClient.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
           if(httpResponse!=null){
               try {
                   httpResponse.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       }
       return  str;
   }
//    public static void main(String[] args) {
//        //这里测试使用天气接口，只需要接口的访问路径即可，后面的数字代表的是城市的id
////        String result = createHttpConnectionByGet(Config.URL+101030100);
////       //这里可以使用json解析器将字符串转成对象。
////        CityWerther cityWerther = JSON.parseObject(result, CityWerther.class);
////        System.out.println(cityWerther);
//        String httpConnectionByPost = createHttpConnectionByPost("http://localhost:8080/ticket/getcode",new Object());
//        System.out.println(httpConnectionByPost);
//    }

}
