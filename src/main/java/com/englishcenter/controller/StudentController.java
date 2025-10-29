package com.englishcenter.controller;

import com.englishcenter.dto.*;
import com.englishcenter.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@RestController
@RequestMapping("/api/student")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/courses")
    public List<LopHocDTO> listOpenClasses() {
        return studentService.getAllOpenCourses();
    }

    @PostMapping("/register/{classId}")
    public String enrollClass(@PathVariable Integer classId, @RequestParam Integer maHocVien) {
        studentService.registerClass(classId, maHocVien);
        return "Đăng ký thành công";
    }

    @GetMapping("/classes/{classId}/assignments")
    public List<BaiTapDTO> listAssignments(@PathVariable Integer classId) {
        return studentService.getAssignments(classId);
    }

    @PostMapping("/assignments/{asmId}/submit")
    public String submitAssignment(
            @PathVariable Integer asmId,
            @RequestParam Integer maHocVien,
            @RequestParam(required = false) String noiDungTraLoi,
            @RequestParam(required = false) MultipartFile file
    ) {
        studentService.submitAssignment(asmId, maHocVien, noiDungTraLoi, file);
        return "Nộp bài tập thành công";
    }

    @PostMapping("/payments")
    public String createPayment(@RequestParam Integer maHocVien, @RequestBody PaymentDTO body) {
        studentService.createPayment(maHocVien, body);
        return "Tạo giao dịch thành công";
    }

    @GetMapping("/payments")
    public List<PaymentDTO> paymentHistory(@RequestParam Integer maHocVien) {
        return studentService.getPaymentHistory(maHocVien);
    }
}
