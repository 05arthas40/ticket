package com.backGroundManager.controller;

import com.backGroundManager.dto.ShowDetailsDto;
import com.backGroundManager.service.impl.ManageShowServiceImpl;
import com.backGroundManager.vo.ShowidAndReasonVo;
import com.backGroundManager.vo.StatusAndPfmidAndReasonVo;
import com.backGroundManager.vo.StatusAndPfmidVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManageShowController {
    @Autowired
    ManageShowServiceImpl backGroundService;

    @RequestMapping(value = "getCheckShow", method = RequestMethod.POST)
    public Object getCheckShow(@RequestParam int status, Integer current) {
        PageHelper.startPage(current, 3);
        List<ShowDetailsDto> list = backGroundService.getCheckShow(status);
        PageInfo<ShowDetailsDto> detailsDtoPageInfo = new PageInfo<ShowDetailsDto>(list);
        return detailsDtoPageInfo;
    }

    @RequestMapping(value = "getShowById", method = RequestMethod.POST)
    public Object getShowById(@RequestParam int pfmid) {
        return backGroundService.getShowById(pfmid);
    }

    @RequestMapping(value = "passShowById", method = RequestMethod.POST)
    public int passShowById(@RequestBody StatusAndPfmidVo statusAndPfmidVo) {
        return backGroundService.alterShowById(statusAndPfmidVo);
    }

    @RequestMapping(value = "rejectShowById", method = RequestMethod.POST)
    public int rejectShowById(@RequestBody StatusAndPfmidAndReasonVo statusAndPfmidAndReasonVo) {
        return backGroundService.rejectShowById(statusAndPfmidAndReasonVo);
    }


    @RequestMapping(value = "getAllShowShow", method = RequestMethod.GET)
    public Object getAllShowShow(@RequestParam int pfmid) {
        return backGroundService.getAllShowShow(pfmid);
    }


    @RequestMapping(value = "passShowShowById", method = RequestMethod.POST)
    public int passShowShowById(@RequestParam int showid) {
        return backGroundService.passShowShowById(showid);
    }

    @RequestMapping(value = "rejectShowShowById", method = RequestMethod.POST)
    public int rejectShowShowById(@RequestBody(required = false) ShowidAndReasonVo showidAndReasonVo) {
        return backGroundService.rejectShowShowById(showidAndReasonVo);
    }

    @RequestMapping(value = "querenShowShowById", method = RequestMethod.POST)
    public int querenShowShowById(@RequestParam int showid) {
        return backGroundService.querenShowShowById(showid);
    }

    @RequestMapping(value = "quxiaoShowShowById", method = RequestMethod.POST)
    public int quxiaoShowShowById(@RequestParam int showid) {
        return backGroundService.quxiaoShowShowById(showid);
    }

}
