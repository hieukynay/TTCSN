package com.englishcenter.repository;
import com.englishcenter.model.DangKyHoc; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface DangKyHocRepository extends JpaRepository<DangKyHoc,Integer>{ List<DangKyHoc> findByLopHoc_MaLopHoc(Integer id); List<DangKyHoc> findByHocVien_MaHocVien(Integer id); }
