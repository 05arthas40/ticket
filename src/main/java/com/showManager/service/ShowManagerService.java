package com.showManager.service;

import com.showManager.dto.ShowDetails;

import java.util.List;

public interface ShowManagerService {
    List<ShowDetails> getOneShowDetails(String showid);
    List<ShowDetails> getShopCart(String[] svid);
    int getOneStock(String svid);
    int getCityIdBysvid(String svid);

    int getShowidBySvid(String svid);
}
