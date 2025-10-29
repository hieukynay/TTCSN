package com.englishcenter.dto;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaiTapDTO {
    private Integer id;
    private String tieuDe;
    private String moTa;
    private String hanNop;
    private LopHocDTO lopHoc;
}
