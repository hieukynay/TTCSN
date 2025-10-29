package com.englishcenter.service;

import com.englishcenter.dto.*;
import java.util.List;

public interface TeacherService {

    // ======= Quản lý lớp học =======
    List<LopHocDTO> getClasses();
    LopHocDTO createClass(LopHocDTO dto);
    LopHocDTO updateClass(Integer id, LopHocDTO dto);
    void deleteClass(Integer id);

    // ======= Quản lý học viên trong lớp =======
    List<HocVienDtos> getStudentsInClass(Integer classId);
    HocVienDtos addStudentToClass(Integer classId, HocVienDtos hv);
    void removeStudentFromClass(Integer classId, Integer hocVienId);

    // ======= Quản lý bài tập =======
    List<BaiTapDTO> getAssignments(Integer classId);
    BaiTapDTO createAssignment(BaiTapDTO dto);

    // ======= Nhập điểm =======
    void grade(DiemDTO dto);
}
