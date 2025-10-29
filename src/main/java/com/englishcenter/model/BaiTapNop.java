// model/BaiTapNop.java
package com.englishcenter.model;
import jakarta.persistence.*; import lombok.*; import java.time.LocalDateTime; @Entity @Data
public class BaiTapNop { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer maBaiNop;
    @ManyToOne private BaiTap baiTap; @ManyToOne private HocVien hocVien;
    private LocalDateTime thoiGianNop=LocalDateTime.now(); @Column(columnDefinition="NVARCHAR(MAX)") private String noiDungTraLoi;
    private String fileNop; private Double diem; private String nhanXet; }
