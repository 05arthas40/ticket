package com.showManager.pojo;

public class ShowDate {
    private String showdate1;
    private String showdate2;

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

    @Override
    public String toString() {
        return "ShowDate{" +
                "showdate1='" + showdate1 + '\'' +
                ", showdate2='" + showdate2 + '\'' +
                '}';
    }
}
