package com.LoginAndRegister.XssFilter;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 这里使用到了装饰者模式
 * @author chenzhenfu
 * 对请求中的参数进行过滤
 */
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {
    private HttpServletRequest request;
    public XssHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
        this.request=request;
    }

    /**
     * 这个方法可以过滤掉@requestBody的参数
     * @return
     * @throws IOException
     */
    @Override
    public ServletInputStream getInputStream() throws IOException {
        //字符缓存流，通过request获取一个字节流，再通过转换流转成字符流
        String result = "";
        BufferedReader br=null;
        try {
            br = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String line=null;
            while ((line = br.readLine())!= null){
                result+=JsoupUtils.clean(line);
            }
            System.out.println(result);
        }catch (Exception e){
          e.printStackTrace();
        }finally {
            br.close();
        }
        //转为字节流(将字节数组通过ByteArrayInputStream变成流)
        return new WrappedServletInputStream(new ByteArrayInputStream(result.getBytes("utf-8")));
    }
    @Override
    public String getParameter(String name){
        //参数名过滤
        String value = super.getParameter(JsoupUtils.clean(name));
        //参数值过滤
        return value==null?null:JsoupUtils.clean(value);
    }
    @Override
    public Map getParameterMap() {
        Map map = super.getParameterMap();
        // 返回值Map
        Map<String, String> returnMap = new HashMap<String, String>();
        Iterator entries = map.entrySet().iterator();
        Map.Entry entry;
        String name = "";
        String value = "";
        while (entries.hasNext()) {
            entry = (Map.Entry) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if (null == valueObj) {
                value = "";
            } else if (valueObj instanceof String[]) {
                String[] values = (String[]) valueObj;
                for (int i = 0; i < values.length; i++) {
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length() - 1);
            } else {
                value = valueObj.toString();
            }
            returnMap.put(name, JsoupUtils.clean(value).trim());
        }
        return returnMap;
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] arr = super.getParameterValues(name);
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = JsoupUtils.clean(arr[i]);
            }
        }
        return arr;
    }
    /**
     * 覆盖getHeader方法，将参数名和参数值都做xss过滤。<br/>
     * 如果需要获得原始的值，则通过super.getHeaders(name)来获取<br/>
     * getHeaderNames 也可能需要覆盖
     */
    @Override
    public String getHeader(String name) {

        name = JsoupUtils.clean(name);
        String value = super.getHeader(name);
        if (value!=null) {
            value = JsoupUtils.clean(value);
        }
        return value;
    }

    private class WrappedServletInputStream extends ServletInputStream {
        private InputStream stream;
        public void setStream(InputStream stream) {
            this.stream = stream;
        }
        public WrappedServletInputStream(InputStream stream) {
            this.stream = stream;
        }
        @Override
        public int read() throws IOException {
            return stream.read();
        }
        @Override
        public boolean isFinished() {
            return false;
        }

        @Override
        public boolean isReady() {
            return false;
        }

        @Override
        public void setReadListener(ReadListener readListener) {

        }
    }
}
