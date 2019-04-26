package com.LoginAndRegister.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Userdto {
   private Integer userid;
   private String username;
   private String password;
   private String phone;
   private String  name;
   private String  email;
   private Character idc;
   boolean isLock;
   boolean status;

   public Integer getUserid() {
      return userid;
   }

   public void setUserid(Integer userid) {
      this.userid = userid;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public Character getIdc() {
      return idc;
   }

   public void setIdc(Character idc) {
      this.idc = idc;
   }

   public boolean isLock() {
      return isLock;
   }

   public void setLock(boolean lock) {
      isLock = lock;
   }

   public boolean isStatus() {
      return status;
   }

   public void setStatus(boolean status) {
      this.status = status;
   }
}
