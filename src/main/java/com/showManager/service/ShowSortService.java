package com.showManager.service;

import com.showManager.dto.ShowSortDto;
import com.showManager.vo.ShowSortVo;

import java.util.List;

public interface ShowSortService {
    public List<ShowSortDto> getShowBy(ShowSortVo showInfoVo);
}
