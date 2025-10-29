package com.englishcenter.service;
import com.englishcenter.dto.*;
import java.util.List;

public interface AdminService {

    // ========== Giáo viên ==========
    List<GiaoVienDtos> listTeachers();
    GiaoVienDtos addTeacher(GiaoVienDtos gv);
    GiaoVienDtos updateTeacher(Integer id, GiaoVienDtos gv);
    void deleteTeacher(Integer id);

    // ========== Khóa học ==========
    List<KhoaHocDTO> listCourses();
    KhoaHocDTO addCourse(KhoaHocDTO kh);
    void deleteCourse(Integer id);
}
