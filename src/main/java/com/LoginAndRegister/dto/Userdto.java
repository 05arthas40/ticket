package com.LoginAndRegister.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Userdto {
   private Integer userid;
   private String userame;
   private String password;
   private String phone;
   private String  name;
   private String  email;
   private Character idc;
   boolean isLock;
   boolean status;
}
