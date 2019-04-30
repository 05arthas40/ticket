package com.showManager.service.impl;

import com.showManager.dao.ShowManagerDao;
import com.showManager.dto.ShowDetails;
import com.showManager.service.ShowManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@Service
public class ShowManagerServiceImpl implements ShowManagerService {
    @Autowired
    ShowManagerDao showManagerDao;

    public List<ShowDetails> getOneShowDetails(String showid) {

        Integer id=Integer.parseInt(showid);
        List<ShowDetails> oneShowDetails = showManagerDao.getOneShowDetails(id);
        System.out.println(oneShowDetails);
        return oneShowDetails;

    }

    public List<ShowDetails> getShopCart(String[] svid) {
        List<Integer> svids = new ArrayList<Integer>();
        for (int i = 0; i < svid.length; i++) {
            svids.add(Integer.parseInt(svid[i]));
        }
        List<ShowDetails> shopCart = showManagerDao.getShopCart(svids);
        System.out.println(shopCart);
        return shopCart;
    }

    public int getOneStock(String svid) {
        return showManagerDao.getOneStock(svid);
    }

    public int getCityIdBysvid(String svid) {
        return showManagerDao.getCityIdBysvid(svid);
    }

    public int getShowidBySvid(String svid) {
        return showManagerDao.getShowidBySvid(svid);
    }


}
