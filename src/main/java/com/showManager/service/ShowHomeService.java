package com.showManager.service;

import com.showManager.dto.ShowHomeDto;

import java.util.List;

public interface ShowHomeService {
    public List<ShowHomeDto> getTypeListByDate();
}
