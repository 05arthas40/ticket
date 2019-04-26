package com.showManager.service.impl;

import com.showManager.dao.ShowHomeMapper;
import com.showManager.dto.ShowHomeDto;
import com.showManager.pojo.ShowDate;
import com.showManager.service.ShowHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ShowHomeServiceImpl implements ShowHomeService {
    @Autowired
    ShowHomeMapper showHomeMapper;
    @Override
    public List<ShowHomeDto> getTypeListByDate() {
        Date date = new Date();
        ShowDate showDate = new ShowDate();
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        showDate.setShowdate1(ft.format(date));
        calendar.add(Calendar.MONTH,1);
        date = calendar.getTime();
        showDate.setShowdate2(ft.format(date));
        List<ShowHomeDto> list = showHomeMapper.getTypeListByDate(showDate);
        return list;
    }
}
