package com.LoginAndRegister.XssFilter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author chenzhengfu
 * 过滤白名单（过滤规则）
 */
public class JsoupUtils {
    /**
     * 使用自带的 basicWithImages 白名单
     * 允许的便签有 a,b,blockquote,br,cite,code,dd,dl,dt,em,i,li,ol,p,pre,q,small,span,strike,strong,sub,sup,u,ul,img
     * 以及 a 标签的 href,img 标签的 src,align,alt,height,width,title 属性
     */
    private static final Whitelist whitelist = Whitelist.basicWithImages();
    /** 配置过滤化参数, 不对代码进行格式化 */
    private static final Document.OutputSettings outputSettings = new Document.OutputSettings().prettyPrint(false);
    static {
        //：all 代表所有标签
        //配置静态块，优先加载，确保调用clean的方法之前就已经把style添加到白名单
        whitelist.addAttributes(":all", "style");
    }

    /**
     * 过滤掉脚本语言
     * @param content 要过滤的参数、HTML等
     * @return
     */
    public static String clean(String content) {
        return Jsoup.clean(content, "", whitelist, outputSettings);
    }
    //测试
//    public static void main(String[] args) throws FileNotFoundException, IOException {
//        String text = "<a href=http://www.baidu.com/a onclick=alert(1);>sss</a><script>alert(0);</script>sss";
//        //<a href="http://www.baidu.com/a" rel="nofollow">sss</a>sss
//        System.out.println(clean(text));
//    }
}
