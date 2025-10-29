package com.englishcenter.dto;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KhoaHocDTO {
    private Integer id;
    private String tenKhoaHoc;
    private String moTa;
    private Double hocPhi;
    private Integer thoiLuong; // số buổi hoặc số tuần
    private String trangThai;  // "Đang mở", "Đã kết thúc", ...
}
