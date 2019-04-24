package com.showManager.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.showManager.dto.ShowSortDto;
import com.showManager.service.ShowSortService;
import com.showManager.vo.ShowSortVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShowSortController {
    @Autowired
    ShowSortService showInfoService;


    /**
     * 通过返回的分类信息获取对应商品信息
     * @param showInfoVo
     * @return
     */
    @RequestMapping(value = "getShow",method = RequestMethod.POST)
    public Object ShowSort(@RequestBody ShowSortVo showInfoVo){
        if (showInfoVo.getPage()==null){
            showInfoVo.setPage(1);
        }
        if (showInfoVo.getSortBy()==null){
            showInfoVo.setSortBy(1);
        }
        PageHelper.startPage(showInfoVo.getPage(), 5);
        List<ShowSortDto> showBy = showInfoService.getShowBy(showInfoVo);
        PageInfo<ShowSortDto> pageInfo = new PageInfo<ShowSortDto>(showBy);
        System.out.println(showBy);
        return pageInfo;
    }
}
