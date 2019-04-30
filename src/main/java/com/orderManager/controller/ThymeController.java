package com.orderManager.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.orderManager.dto.OrderDto;
import com.orderManager.service.OrderService;
import com.showManager.dto.ShowDetails;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//import sun.security.provider.SHA;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeController {


    @RequestMapping("geturl")
    public Object getUrl(Model model, int svid, int count) {
        List<ShowDetails> lists = getList();
        int seatcount = 0;
        String totalprice = null;
        for (ShowDetails showDetails : lists) {
            if (showDetails.getSvid() == svid) {
                totalprice = new BigDecimal(showDetails.getShowprice()).multiply(new BigDecimal(count)).toString();
                seatcount = showDetails.getSeatCount();
                break;
            }
        }
        model.addAttribute("count", count);
        model.addAttribute("svid", svid);
        model.addAttribute("lists", lists);
        model.addAttribute("dto", lists.get(0));
        model.addAttribute("seatcount", seatcount);
        model.addAttribute("totalprice", totalprice);

        return "snapshot";
    }

    private List<ShowDetails> getList() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:8080/ticket_test_war_exploded/getShowDetailBySvid?svid=2");
        httpGet.setHeader("Connection", "keep-alive");
        // 设置代理（模拟浏览器版本）
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
        HttpEntity httpEntity = null;
        String entitystr = null;
        CloseableHttpResponse httpResponse = null;
        List<ShowDetails> lists = new ArrayList<ShowDetails>();
        try {
            httpResponse = httpClient.execute(httpGet);
            httpEntity = httpResponse.getEntity();
            entitystr = EntityUtils.toString(httpEntity,"utf-8");
            System.out.println(entitystr);
            JSONArray jsonArray = JSONArray.parseArray(entitystr);
            //获得jsonArray的第一个元素
            Object o = null;
            ShowDetails details;
            for (int i = 0; i < jsonArray.size(); i++) {
                String s = jsonArray.get(i).toString();
                ShowDetails showDetails = (ShowDetails) JSONObject.parseObject(s, ShowDetails.class);
                lists.add(showDetails);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (httpResponse != null) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (httpEntity != null) {
                try {
                    EntityUtils.consume(httpEntity);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return lists;
    }
}
