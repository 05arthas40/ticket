package com.backGroundManager.service.impl;


import com.backGroundManager.dao.ManageShowDao;
import com.backGroundManager.dto.ShowDetailsDto;
import com.backGroundManager.dto.ShowInfoDto;
import com.backGroundManager.dto.ShowShowDto;
import com.backGroundManager.service.ManageShowService;
import com.backGroundManager.vo.ShowidAndReasonVo;
import com.backGroundManager.vo.StatusAndPfmidAndReasonVo;
import com.backGroundManager.vo.StatusAndPfmidVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageShowServiceImpl implements ManageShowService {

    @Autowired
    ManageShowDao manageShowDao;


    public List<ShowDetailsDto> getCheckShow(int status) {
        return manageShowDao.getCheckShow(status);
    }

    public List<ShowInfoDto> getShowById(int pfmid) {
        /*List<ShowInfoDto> showById = manageShowDao.getShowById(pfmid);
        ShowInfoDto showInfoDto = showById.get(0);
        String pdecription = showInfoDto.getPdecription();

        System.out.println();*/
        return manageShowDao.getShowById(pfmid);
    }

    public int alterShowById(StatusAndPfmidVo statusAndPfmidVo) {
        return manageShowDao.alterShowById(statusAndPfmidVo);
    }

    public int rejectShowById(StatusAndPfmidAndReasonVo statusAndPfmidAndReasonVo) {
        return manageShowDao.rejectShowById(statusAndPfmidAndReasonVo);
    }


    public List<ShowShowDto> getAllShowShow(int pfmid) {
        return manageShowDao.getAllShowShow(pfmid);
    }




    public int passShowShowById(int showid) {
        return manageShowDao.passShowShowById(showid);
    }

    public int rejectShowShowById(ShowidAndReasonVo showidAndReasonVo) {
        return manageShowDao.rejectShowShowById(showidAndReasonVo);
    }

    public int querenShowShowById(int showid) {
        return manageShowDao.querenShowShowById(showid);
    }

    public int quxiaoShowShowById(int showid) {
        return manageShowDao.quxiaoShowShowById(showid);
    }


}
