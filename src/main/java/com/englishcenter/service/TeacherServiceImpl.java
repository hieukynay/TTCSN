package com.englishcenter.service;

import com.englishcenter.dto.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TeacherServiceImpl implements TeacherService {

    // ================= MOCK DATA =================
    private final List<LopHocDTO> dsLopHoc = new ArrayList<>();
    private final Map<Integer, List<HocVienDtos>> dsHocVienTheoLop = new HashMap<>();
    private final Map<Integer, List<BaiTapDTO>> dsBaiTapTheoLop = new HashMap<>();

    public TeacherServiceImpl() {
        // Khởi tạo dữ liệu mẫu
        LopHocDTO lop1 = new LopHocDTO(1, "English A1", "Cơ bản cho người mới bắt đầu", "Đang mở", 30, "Trần Thị Giáo Viên");
        LopHocDTO lop2 = new LopHocDTO(2, "English B1", "Luyện thi B1", "Đang mở", 25, "Nguyễn Văn Thầy");
        dsLopHoc.addAll(List.of(lop1, lop2));

        dsHocVienTheoLop.put(1, new ArrayList<>(List.of(
                new HocVienDtos(1, "Lê Văn Học Viên", "hocvien1@example.com", "0901234567", "2025-01-05"),
                new HocVienDtos(2, "Nguyễn Thị A", "hocvien2@example.com", "0902345678", "2025-01-10")
        )));

        dsHocVienTheoLop.put(2, new ArrayList<>(List.of(
                new HocVienDtos(3, "Phạm Bảo B", "hocvien3@example.com", "0903456789", "2025-02-01")
        )));

        LopHocDTO lophoc1 = dsLopHoc.get(0); // lớp có id = 1
        dsBaiTapTheoLop.put(1, new ArrayList<>(List.of(
                new BaiTapDTO(1, "Bài tập ngữ pháp 1", "Chia thì hiện tại đơn", "2025-11-15",lop1)
        )));


    }

    // ================= LỚP HỌC =================

    @Override
    public List<LopHocDTO> getClasses() {
        return dsLopHoc;
    }

    @Override
    public LopHocDTO createClass(LopHocDTO dto) {
        dto.setId(dsLopHoc.size() + 1);
        dto.setTrangThai("Đang mở");
        dsLopHoc.add(dto);
        System.out.println("✅ Tạo lớp học mới: " + dto.getTenLop());
        return dto;
    }

    @Override
    public LopHocDTO updateClass(Integer id, LopHocDTO dto) {
        for (LopHocDTO l : dsLopHoc) {
            if (l.getId().equals(id)) {
                l.setTenLop(dto.getTenLop());
                l.setMoTa(dto.getMoTa());
                l.setSoLuongToiDa(dto.getSoLuongToiDa());
                l.setGiaoVienPhuTrach(dto.getGiaoVienPhuTrach());
                System.out.println("✏️ Cập nhật lớp ID=" + id);
                return l;
            }
        }
        return null;
    }

    @Override
    public void deleteClass(Integer id) {
        dsLopHoc.removeIf(l -> l.getId().equals(id));
        dsHocVienTheoLop.remove(id);
        dsBaiTapTheoLop.remove(id);
        System.out.println("🗑️ Đã xóa lớp học ID: " + id);
    }

    // ================= HỌC VIÊN =================

    @Override
    public List<HocVienDtos> getStudentsInClass(Integer classId) {
        return dsHocVienTheoLop.getOrDefault(classId, new ArrayList<>());
    }

    @Override
    public HocVienDtos addStudentToClass(Integer classId, HocVienDtos hv) {
        List<HocVienDtos> hvList = dsHocVienTheoLop.computeIfAbsent(classId, k -> new ArrayList<>());
        hv.setId(new Random().nextInt(1000));
        hvList.add(hv);
        System.out.println("👩‍🎓 Thêm học viên " + hv.getHoTen() + " vào lớp " + classId);
        return hv;
    }

    @Override
    public void removeStudentFromClass(Integer classId, Integer hocVienId) {
        List<HocVienDtos> hvList = dsHocVienTheoLop.get(classId);
        if (hvList != null) hvList.removeIf(h -> h.getId().equals(hocVienId));
        System.out.println("❌ Xóa học viên " + hocVienId + " khỏi lớp " + classId);
    }

    // ================= BÀI TẬP =================

    @Override
    public List<BaiTapDTO> getAssignments(Integer classId) {
        return dsBaiTapTheoLop.getOrDefault(classId, new ArrayList<>());
    }

    @Override
    public BaiTapDTO createAssignment(BaiTapDTO dto) {
        Integer classId = dto.getLopHoc().getId();
        List<BaiTapDTO> list = dsBaiTapTheoLop.computeIfAbsent(classId, k -> new ArrayList<>());
        dto.setId(new Random().nextInt(1000));
        list.add(dto);
        System.out.println("📝 Tạo bài tập mới: " + dto.getTieuDe() + " cho lớp " + classId);
        return dto;
    }

    // ================= ĐIỂM =================

    @Override
    public void grade(DiemDTO dto) {
        System.out.println("✅ Chấm điểm học viên " + dto.getHocVienId() +
                " - Bài " + dto.getBaiTapId() +
                " - Điểm: " + dto.getDiemSo());
        // có thể lưu vào DB hoặc Map riêng
    }
}
