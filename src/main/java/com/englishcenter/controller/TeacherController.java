package com.englishcenter.controller;

import com.englishcenter.dto.*;
import com.englishcenter.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/teacher")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    // Lấy danh sách lớp học
    @GetMapping("/classes")
    public List<LopHocDTO> getClasses() {
        return teacherService.getClasses();
    }

    // Tạo lớp học mới
    @PostMapping("/classes")
    public LopHocDTO createClass(@RequestBody LopHocDTO dto) {
        return teacherService.createClass(dto);
    }

    // Xóa lớp học
    @DeleteMapping("/classes/{id}")
    public String deleteClass(@PathVariable Integer id) {
        teacherService.deleteClass(id);
        return "Xóa lớp thành công";
    }
    // Lấy danh sách bài tập của 1 lớp
    @GetMapping("/classes/{classId}/assignments")
    public List<BaiTapDTO> getAssignmentsByClass(@PathVariable Integer classId) {
        return teacherService.getAssignments(classId);
    }

    //  Tạo bài tập mới
    @PostMapping("/assignments")
    public BaiTapDTO createAssignment(@RequestBody BaiTapDTO dto) {
        return teacherService.createAssignment(dto);
    }

}
