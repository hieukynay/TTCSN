package com.englishcenter.repository;
import com.englishcenter.model.BaiTapNop; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface BaiTapNopRepository extends JpaRepository<BaiTapNop,Integer>{ List<BaiTapNop> findByBaiTap_MaBaiTap(Integer id); }
