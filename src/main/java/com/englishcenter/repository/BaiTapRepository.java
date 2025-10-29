package com.englishcenter.repository;
import com.englishcenter.model.BaiTap; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface BaiTapRepository extends JpaRepository<BaiTap,Integer>{ List<BaiTap> findByLopHoc_MaLopHoc(Integer id); }
