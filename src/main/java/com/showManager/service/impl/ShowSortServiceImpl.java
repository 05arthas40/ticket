package com.showManager.service.impl;

import com.showManager.dao.ShowSortMapper;
import com.showManager.dto.ShowSortDto;
import com.showManager.service.ShowSortService;
import com.showManager.vo.ShowSortVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ShowSortServiceImpl implements ShowSortService {

    @Autowired
    ShowSortMapper showSortMapper;

    public List<ShowSortDto> getShowBy(ShowSortVo showInfoVo) {
        if (showInfoVo.getDate() != null){
            Date date = new Date();
            SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            if (showInfoVo.getDate()==1){
                showInfoVo.setShowdate1(ft.format(date));
                System.out.println(showInfoVo.getShowdate1());
            }else if (showInfoVo.getDate()==2) {
                calendar.add(Calendar.DATE,1);
                date = calendar.getTime();
                showInfoVo.setShowdate1(ft.format(date));
            }else if (showInfoVo.getDate()==3) {
                showInfoVo.setShowdate1(ft.format(date));
                calendar.add(Calendar.MONTH,1);
                date = calendar.getTime();
                showInfoVo.setShowdate2(ft.format(date));
            }
        }
        if (showInfoVo.getKeyword() != null){
            StringBuffer sb = new StringBuffer();
            String[] strings = showInfoVo.getKeyword().split("");
            for (String s : strings) {
                sb.append("%");
                sb.append(s);
            }
            sb.append("%");
            showInfoVo.setKeyword(sb.toString());
        }
        List<ShowSortDto> showBy = showSortMapper.getShowBy(showInfoVo);
        return showBy;
    }

}
