package com.companyManager.service;

import com.companyManager.dto.PerformanceApplication;
import com.companyManager.dto.ShowAndVenue;
import com.companyManager.dto.ShowApplication;
import com.companyManager.dto.VenueDto;
import com.companyManager.pojo.Performance;

import java.util.List;
import java.util.Map;

public interface IPerformanceService {

    /**
     * performance列表粗略信息回显
     * @param companyId
     * @return
     */
    public List<PerformanceApplication> getAllPerforman(int companyId);

    public List<Performance> getPerformanceById(int performanceId);

    public List<ShowApplication> getAllShowInfo(int performanceId);

    public List<VenueDto> getVenueByShowId(int showId);

    public String getPerformanceName(int performanceId);

    public int addshowinfo(ShowAndVenue showAndVenue);

    public int addVenueinfos(Map<String, Object> map);

    public int addPerformance(Performance performance);

    public int addCompanyShow(Map<String, Integer> map);
}
