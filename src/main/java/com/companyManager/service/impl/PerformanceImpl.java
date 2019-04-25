package com.companyManager.service.impl;

import com.companyManager.dto.PerformanceApplication;
import com.companyManager.dto.ShowAndVenue;
import com.companyManager.dto.ShowApplication;
import com.companyManager.dto.VenueDto;
import com.companyManager.dao.PerformanceDao;
import com.companyManager.pojo.Performance;
import com.companyManager.service.IPerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional(readOnly = true)
@Service
public class PerformanceImpl implements IPerformanceService {

    @Autowired
    PerformanceDao performanceDao;

    public List<PerformanceApplication> getAllPerforman(int companyId) {
        return performanceDao.getAllPerformance(companyId);
    }

    public List<Performance> getPerformanceById(int performanceId) {
        return performanceDao.getPerformancesById(performanceId);
    }

    public List<ShowApplication> getAllShowInfo(int performanceId) {
        return performanceDao.getAllShowInfo(performanceId);
    }

    public List<VenueDto> getVenueByShowId(int showId) {
        return performanceDao.getVenueByShowId(showId);
    }

    //得到演出名，用于添加show的信息回显
    public String getPerformanceName(int performanceId) {
        return performanceDao.getPerformanceName(performanceId);
    }

    @Transactional(readOnly = false)
    public int addshowinfo(ShowAndVenue showAndVenue) {
        return performanceDao.addshowinfo(showAndVenue);
    }

    @Transactional(readOnly = false)
    public int addVenueinfos(Map<String,Object> map) {
        return performanceDao.addVenueinfos(map);
    }

    @Transactional(readOnly = false)
    public int addPerformance(Performance performance) {
        return performanceDao.addPerformance(performance);
    }

    @Transactional(readOnly = false)
    public int addCompanyShow(Map<String, Integer> map) {
        return performanceDao.addCompanyShow(map);
    }
}
