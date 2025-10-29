// model/DangKyHoc.java
package com.englishcenter.model;
import jakarta.persistence.*; import lombok.*; import java.time.LocalDate; @Entity @Data
public class DangKyHoc { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer maDangKy;
    @ManyToOne private HocVien hocVien; @ManyToOne private LopHoc lopHoc;
    private LocalDate ngayDangKy=LocalDate.now(); private String trangThai="Chưa thanh toán"; }
