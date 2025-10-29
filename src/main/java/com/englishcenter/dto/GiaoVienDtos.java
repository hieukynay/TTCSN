package com.englishcenter.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GiaoVienDtos {
    private Integer id;
    private String hoTen;
    private String email;
    private String soDienThoai;
    private String chuyenMon;
    private Integer kinhNghiem;
    private String bangCap;
}
