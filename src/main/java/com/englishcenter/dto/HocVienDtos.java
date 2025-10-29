package com.englishcenter.dto;

import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HocVienDtos {
    private Integer id;
    private String hoTen;
    private String email;
    private String soDienThoai;
    private String ngayNhapHoc;
}
