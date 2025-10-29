package com.englishcenter.dto;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LichHocDTO {
    private Integer id;
    private String tenLop;
    private String ngayHoc;
    private String gioBatDau;
    private String gioKetThuc;
    private String phongHoc;
}
