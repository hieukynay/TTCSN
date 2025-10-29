package com.englishcenter.dto;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {
    private Integer id;
    private Integer hocVienId;
    private Double soTien;
    private String noiDung;
    private String ngayThanhToan;
    private String trangThai; // Ví dụ: "Thành công" / "Chờ xử lý"
}
