// model/LopHoc.java
package com.englishcenter.model;
import jakarta.persistence.*; import lombok.*; @Entity @Data
public class LopHoc { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer maLopHoc;
    @ManyToOne private KhoaHoc khoaHoc; @ManyToOne private GiaoVien giaoVien;
    private String tenLopHoc, lichHoc, phongHoc; }
