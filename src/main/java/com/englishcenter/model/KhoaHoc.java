// model/KhoaHoc.java
package com.englishcenter.model;
import jakarta.persistence.*; import lombok.*; import java.math.BigDecimal; import java.time.LocalDate; @Entity @Data
public class KhoaHoc { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer maKhoaHoc;
    private String tenKhoaHoc; @Column(columnDefinition="NVARCHAR(MAX)") private String moTa;
    private BigDecimal hocPhi; private LocalDate thoiGianBatDau; private LocalDate thoiGianKetThuc; }
