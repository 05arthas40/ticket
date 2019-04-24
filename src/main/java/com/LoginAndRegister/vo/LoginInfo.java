package com.LoginAndRegister.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author mack
 * 登录信息vo
 */
@ToString
public class LoginInfo {
  @NotBlank(message = "必填")
  @Length(min = 8,max = 11,message = "用户名不符合长度")
  private String login_number;

  @NotBlank(message = "必填")
  @Length(min = 6,max = 16,message = "密码不符合长度")
  private String login_password;

  private String rember;

  public String getLogin_number() {
    return login_number;
  }

  public void setLogin_number(String login_number) {
    this.login_number = login_number;
  }

  public String getLogin_password() {
    return login_password;
  }

  public void setLogin_password(String login_password) {
    this.login_password = login_password;
  }

  public String getRember() {
    return rember;
  }

  public void setRember(String rember) {
    this.rember = rember;
  }
}
