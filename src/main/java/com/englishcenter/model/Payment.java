// model/Payment.java
package com.englishcenter.model;
import jakarta.persistence.*; import lombok.*; import java.math.BigDecimal; import java.time.LocalDateTime; @Entity @Data
public class Payment { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer maThanhToan;
    @ManyToOne private HocVien hocVien; private BigDecimal soTien; private LocalDateTime ngayThanhToan=LocalDateTime.now();
    private String phuongThuc; private String trangThai; }
