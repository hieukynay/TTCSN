package com.englishcenter.service;
import org.springframework.stereotype.Service;
import java.util.*;
import org.springframework.web.multipart.MultipartFile;
import com.englishcenter.dto.*;

@Service
public class StudentServiceImpl implements StudentService {

    @Override
    public List<LopHocDTO> getAllOpenCourses() {
        // TODO: Query database
        return List.of(new LopHocDTO(1, "English A1", "Cơ bản", "Đang mở", 30, "Trần Thị G.Viên"));
    }

    @Override
    public void registerClass(Integer classId, Integer maHocVien) {
        // TODO: insert into dang_ky_hoc
        System.out.println("Học viên " + maHocVien + " đăng ký lớp " + classId);
    }
    LopHocDTO lop1 = new LopHocDTO(1, "English A1", "Cơ bản cho người mới bắt đầu", "Đang mở", 30, "Trần Thị Giáo Viên");


    @Override
    public List<BaiTapDTO> getAssignments(Integer classId) {
        return List.of(new BaiTapDTO(1, "Bài tập ngữ pháp", "Chia thì", "2025-11-10",lop1 ));
    }

    @Override
    public void submitAssignment(Integer asmId, Integer maHocVien, String noiDungTraLoi, MultipartFile file) {
        // TODO: Lưu vào bảng nop_bai_tap
        System.out.println("Học viên " + maHocVien + " nộp bài " + asmId);
    }

    @Override
    public void createPayment(Integer maHocVien, PaymentDTO body) {
        // TODO: insert payment
        System.out.println("Tạo thanh toán cho " + maHocVien + ": " + body.getSoTien());
    }

    @Override
    public List<PaymentDTO> getPaymentHistory(Integer maHocVien) {
        return List.of(new PaymentDTO(1, maHocVien, 1200000.0, "Học phí A1", "2025-10-01", "Thành công"));
    }
}
