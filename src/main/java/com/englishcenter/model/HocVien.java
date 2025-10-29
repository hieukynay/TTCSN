// model/HocVien.java
package com.englishcenter.model;
import jakarta.persistence.*; import lombok.*; import java.time.LocalDate; @Entity @Data
public class HocVien { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer maHocVien;
    @OneToOne private TaiKhoan taiKhoan; private LocalDate ngayNhapHoc=LocalDate.now(); }
