package com.englishcenter.controller;

import com.englishcenter.dto.*;
import com.englishcenter.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    // Quản lý giáo viên
    @GetMapping("/teachers")
    public List<GiaoVienDtos> listTeachers() {
        return adminService.listTeachers();
    }

    @PostMapping("/teachers")
    public GiaoVienDtos addTeacher(@RequestBody GiaoVienDtos gv) {
        return adminService.addTeacher(gv);
    }

    @PutMapping("/teachers/{id}")
    public GiaoVienDtos updateTeacher(@PathVariable Integer id, @RequestBody GiaoVienDtos gv) {
        return adminService.updateTeacher(id, gv);
    }

    @DeleteMapping("/teachers/{id}")
    public String deleteTeacher(@PathVariable Integer id) {
        adminService.deleteTeacher(id);
        return "Xóa giáo viên thành công";
    }

    // Quản lý khóa học
    @GetMapping("/courses")
    public List<KhoaHocDTO> listCourses() {
        return adminService.listCourses();
    }

    @PostMapping("/courses")
    public KhoaHocDTO addCourse(@RequestBody KhoaHocDTO kh) {
        return adminService.addCourse(kh);
    }

    @DeleteMapping("/courses/{id}")
    public String deleteCourse(@PathVariable Integer id) {
        adminService.deleteCourse(id);
        return "Xóa khóa học thành công";
    }
}
