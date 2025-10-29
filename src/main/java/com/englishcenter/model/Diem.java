// model/Diem.java
package com.englishcenter.model;
import jakarta.persistence.*; import lombok.*; @Entity @Data
public class Diem { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer maDiem;
    @ManyToOne private HocVien hocVien; @ManyToOne private LopHoc lopHoc;
    private Double diemGiuaKy, diemCuoiKy; private String nhanXet; }
