package com.showManager.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.showManager.dto.ShowDetails;
import com.showManager.service.impl.ShowManagerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShowManagerController {
    @Autowired
    ShowManagerServiceImpl service;

    /**
     * 通过传入showid获取对应show的详细信息
     * @param showid：showid
     * @return 传回每个价位的详细信息
     */
    @RequestMapping(value = "getOneShowDetails")
    public List<ShowDetails> getOneShowDetails(@RequestParam String showid) {
        return service.getOneShowDetails(showid);
    }

    /**
     * 通过svid数组获取对应的详细信息集合
     * @param svid:svid
     * @param callback：callback
     * @return
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "getShopCart",method = RequestMethod.GET)
    public Object getShopCart(@RequestParam String[] svid, String callback) {
        System.out.println(callback);
        List<ShowDetails> shopCart = service.getShopCart(svid);
        return new JSONPObject(callback,shopCart);
    }

    /**
     * 获取单个svid的对应库存
     * @param svid
     * @return
     */
    @RequestMapping(value = "getOneStock")
    public int getOneStock(@RequestParam String svid) {
        return service.getOneStock(svid);
    }


    @RequestMapping(value = "getCityIdBysvid")
    public int getCityIdBysvid(@RequestParam String svid) {
        return service.getCityIdBysvid(svid);
    }

    @RequestMapping(value = "getShowDetailBySvid")
    public List<ShowDetails> getShowDetailBySvid(@RequestParam String svid) {
        int showidBySvid = service.getShowidBySvid(svid);
        System.out.println(showidBySvid);
        return service.getOneShowDetails(String.valueOf(showidBySvid));
    }
}
