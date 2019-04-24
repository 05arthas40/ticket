package com.showManager.dao;


import com.showManager.dto.ShowDetails;

import java.util.List;

public interface ShowManagerDao {
    List<ShowDetails> getOneShowDetails(int showid);
    List<ShowDetails> getShopCart(List<Integer> svids);
    int getOneStock(String svid);
    int getCityIdBysvid(String svid);
}
