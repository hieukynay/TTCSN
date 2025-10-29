package com.englishcenter.service;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.englishcenter.dto.*;

public interface StudentService {
    List<LopHocDTO> getAllOpenCourses();
    void registerClass(Integer classId, Integer maHocVien);
    List<BaiTapDTO> getAssignments(Integer classId);
    void submitAssignment(Integer asmId, Integer maHocVien, String noiDungTraLoi, MultipartFile file);
    void createPayment(Integer maHocVien, PaymentDTO body);
    List<PaymentDTO> getPaymentHistory(Integer maHocVien);
}
