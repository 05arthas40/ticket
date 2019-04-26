package com.showManager.dao;

import com.showManager.dto.ShowHomeDto;
import com.showManager.pojo.ShowDate;

import java.util.List;

public interface ShowHomeMapper {
    List<ShowHomeDto> getTypeListByDate(ShowDate showDate);
}
