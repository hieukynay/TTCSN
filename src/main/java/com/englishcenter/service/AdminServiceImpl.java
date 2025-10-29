package com.englishcenter.service;
import com.englishcenter.dto.*;
import jakarta.persistence.Id;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class AdminServiceImpl implements AdminService {

    // ================== Giáo viên ==================
    @Override
    public List<GiaoVienDtos> listTeachers() {
        return List.of(
                new GiaoVienDtos(1, "Trần Thị Giáo Viên", "giaovien01@center.com", "0901234567", "Tiếng Anh giao tiếp", 5, "Cu mham mgon ngu"),
                new GiaoVienDtos(2, "Nguyễn Văn Giảng Dạy", "giaovien02@center.com", "0902222333", "Ngữ pháp nâng cao", 8, "Thac si")
        );
    }

    @Override
    public GiaoVienDtos addTeacher(GiaoVienDtos gv) {
        gv.setId(new Random().nextInt(1000));
        System.out.println("🧑‍🏫 Thêm giáo viên: " + gv.getHoTen());
        return gv;
    }

    @Override
    public GiaoVienDtos updateTeacher(Integer id, GiaoVienDtos gv) {
        gv.setId(id);
        System.out.println("✏️ Cập nhật giáo viên ID=" + id);
        return gv;
    }

    @Override
    public void deleteTeacher(Integer id) {
        System.out.println("🗑️ Xóa giáo viên ID=" + id);
    }

    // ================== Khóa học ==================
    @Override
    public List<KhoaHocDTO> listCourses() {
        return List.of(
                new KhoaHocDTO(1, "Tiếng Anh A1", "Khóa học cơ bản cho người mới bắt đầu", 1200000.0, 12, "Đang mở"),
                new KhoaHocDTO(2, "Tiếng Anh B1", "Luyện thi chứng chỉ B1", 1500000.0, 15, "Đang mở")
        );
    }

    @Override
    public KhoaHocDTO addCourse(KhoaHocDTO kh) {
        kh.setId(new Random().nextInt(1000));
        kh.setTrangThai("Đang mở");
        System.out.println("📘 Thêm khóa học: " + kh.getTenKhoaHoc());
        return kh;
    }

    @Override
    public void deleteCourse(Integer id) {
        System.out.println("🗑️ Xóa khóa học ID=" + id);
    }
}
