package com.englishcenter.security;

import com.englishcenter.model.TaiKhoan;
import com.englishcenter.repository.TaiKhoanRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final TaiKhoanRepository repo;

    public UserDetailsServiceImpl(TaiKhoanRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TaiKhoan tk = repo.findByTenDangNhap(username)
                .orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy tài khoản"));

        // ✅ Role chuẩn có prefix ROLE_
        String role = "ROLE_" + tk.getVaiTro().toUpperCase();

        return new User(
                tk.getTenDangNhap(),
                tk.getMatKhau(),
                List.of(() -> role)
        );
    }
}
