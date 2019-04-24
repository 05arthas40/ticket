package com.backGroundManager.service;

import com.backGroundManager.dto.ShowDetailsDto;
import com.backGroundManager.dto.ShowInfoDto;
import com.backGroundManager.dto.ShowShowDto;
import com.backGroundManager.vo.ShowidAndReasonVo;
import com.backGroundManager.vo.StatusAndPfmidAndReasonVo;
import com.backGroundManager.vo.StatusAndPfmidVo;

import java.util.List;

public interface ManageShowService {
    public List<ShowDetailsDto> getCheckShow(int status);
    public List<ShowInfoDto> getShowById(int pfmid);
    public int alterShowById(StatusAndPfmidVo statusAndPfmidVo);
    public int rejectShowById(StatusAndPfmidAndReasonVo statusAndPfmidAndReasonVo);

    public List<ShowShowDto> getAllShowShow(int pfmid);


    public int passShowShowById(int showid);
    public int rejectShowShowById(ShowidAndReasonVo showidAndReasonVo);
    public int querenShowShowById(int showid);
    public int quxiaoShowShowById(int showid);
}
