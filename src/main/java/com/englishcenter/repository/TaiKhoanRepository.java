package com.englishcenter.repository;

import com.englishcenter.model.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Integer> {

    // 🔍 Tìm tài khoản theo tên đăng nhập
    Optional<TaiKhoan> findByTenDangNhap(String tenDangNhap);

    // ✅ Kiểm tra xem tên đăng nhập đã tồn tại chưa
    boolean existsByTenDangNhap(String tenDangNhap);
}
