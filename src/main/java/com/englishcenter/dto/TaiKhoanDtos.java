package com.englishcenter.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaiKhoanDtos {
    private Integer maTaiKhoan;
    private String tenDangNhap;
    private String hoTen;
    private String email;
    private String soDienThoai;
    private String vaiTro;
    private boolean trangThai;
}
