package com.orderManager.dto;

public class UserAdressDto {
    private int userid;
    private int uaid;
    private String uaname;
    private String  uaphone;
    private String  uaddress;
    private byte  isDefault;
    private byte  status;

    @Override
    public String toString() {
        return "UserAdressDto{" +
                "userid=" + userid +
                ", uaid=" + uaid +
                ", uaname='" + uaname + '\'' +
                ", uaphone='" + uaphone + '\'' +
                ", uaddress='" + uaddress + '\'' +
                ", isDefault=" + isDefault +
                ", status=" + status +
                '}';
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getUaid() {
        return uaid;
    }

    public void setUaid(int uaid) {
        this.uaid = uaid;
    }

    public String getUaname() {
        return uaname;
    }

    public void setUaname(String uaname) {
        this.uaname = uaname;
    }

    public String getUaphone() {
        return uaphone;
    }

    public void setUaphone(String uaphone) {
        this.uaphone = uaphone;
    }

    public String getUaddress() {
        return uaddress;
    }

    public void setUaddress(String uaddress) {
        this.uaddress = uaddress;
    }

    public byte getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(byte isDefault) {
        this.isDefault = isDefault;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }
}
