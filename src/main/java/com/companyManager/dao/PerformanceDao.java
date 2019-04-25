package com.companyManager.dao;

import com.companyManager.dto.PerformanceApplication;
import com.companyManager.dto.ShowAndVenue;
import com.companyManager.dto.ShowApplication;
import com.companyManager.dto.VenueDto;
import com.companyManager.pojo.Performance;
import com.companyManager.pojo.ShowVenue;

import java.util.List;
import java.util.Map;

public interface PerformanceDao {
    public List<PerformanceApplication> getAllPerformance(int companyId);

    public List<Performance> getPerformancesById(int performanceId);

    public List<ShowApplication> getAllShowInfo(int performanceId);

    public List<VenueDto> getVenueByShowId(int showId);

    public String getPerformanceName(int performanceId);

    public int addshowinfo(ShowAndVenue showAndVenue);

    public int addVenueinfos(Map<String, Object> map);

    public int addPerformance(Performance performance);

    public int addCompanyShow(Map<String, Integer> map);
}
