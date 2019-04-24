package com.showManager.vo;


public class ShowSortVo {
    Integer date;
    String showdate1;
    String showdate2;
    Integer cityId;
    String pType;
    String keyword;
    Integer page;
    Integer sortBy;

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public String getShowdate1() {
        return showdate1;
    }

    public void setShowdate1(String showdate1) {
        this.showdate1 = showdate1;
    }

    public String getShowdate2() {
        return showdate2;
    }

    public void setShowdate2(String showdate2) {
        this.showdate2 = showdate2;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getpType() {
        return pType;
    }

    public void setpType(String pType) {
        this.pType = pType;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSortBy() {
        return sortBy;
    }

    public void setSortBy(Integer sortBy) {
        this.sortBy = sortBy;
    }

    @Override
    public String toString() {
        return "ShowInfoDto{" +
                "date=" + date +
                ", showdate1='" + showdate1 + '\'' +
                ", showdate2='" + showdate2 + '\'' +
                ", cityId=" + cityId +
                ", pType='" + pType + '\'' +
                ", keyword='" + keyword + '\'' +
                ", page=" + page +
                ", sortBy=" + sortBy +
                '}';
    }

}
