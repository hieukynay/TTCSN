package com.englishcenter.dto;
public class AuthDtos {
  public static class LoginReq { public String username, password; }
  public static class RegisterReq { public String username,password,hoTen,email,soDienThoai,vaiTro; }
  public static class LoginRes { public String accessToken, role; public Integer userId; }
}
