package com.englishcenter.dto;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LopHocDTO {
    private Integer id;
    private String tenLop;
    private String moTa;
    private String trangThai; // Ví dụ: "Đang mở", "Đã kết thúc"
    private Integer soLuongToiDa;
    private String giaoVienPhuTrach;
}
