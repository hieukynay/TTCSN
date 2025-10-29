// model/BaiTap.java
package com.englishcenter.model;
import jakarta.persistence.*; import lombok.*; import java.time.LocalDateTime; @Entity @Data
public class BaiTap { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer maBaiTap;
    @ManyToOne private LopHoc lopHoc; @ManyToOne private GiaoVien giaoVien;
    private String tieuDe; @Column(columnDefinition="NVARCHAR(MAX)") private String noiDung; private LocalDateTime hanNop; }
