// model/TaiKhoan.java
package com.englishcenter.model;
import jakarta.persistence.*; import lombok.*;
@Entity @Data public class TaiKhoan {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer maTaiKhoan;
    @Column(unique=true,nullable=false) private String tenDangNhap;
    @Column(nullable=false) private String matKhau;
    private String hoTen, email, soDienThoai;
    @Column(nullable=false) private String vaiTro; // Admin/GiaoVien/HocVien
    private boolean trangThai;
}
