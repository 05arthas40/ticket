package com.showManager.dao;

import com.showManager.dto.ShowSortDto;
import com.showManager.vo.ShowSortVo;

import java.util.List;

public interface ShowSortMapper {
    public List<ShowSortDto> getShowBy(ShowSortVo showInfoVo);

}
