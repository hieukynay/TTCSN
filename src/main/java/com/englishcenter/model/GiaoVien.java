// model/GiaoVien.java
package com.englishcenter.model;
import jakarta.persistence.*; import lombok.*; @Entity @Data
public class GiaoVien { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer maGiaoVien;
    @OneToOne private TaiKhoan taiKhoan; private String bangCap; private Integer kinhNghiem; private String chuyenMon; }
