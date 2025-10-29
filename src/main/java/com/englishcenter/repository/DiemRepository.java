package com.englishcenter.repository;
import com.englishcenter.model.Diem; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface DiemRepository extends JpaRepository<Diem,Integer>{ List<Diem> findByLopHoc_MaLopHoc(Integer id); List<Diem> findByHocVien_MaHocVien(Integer id); }
