package com.englishcenter.repository;
import com.englishcenter.model.Payment; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface PaymentRepository extends JpaRepository<Payment,Integer>{ List<Payment> findByHocVien_MaHocVien(Integer id); }
