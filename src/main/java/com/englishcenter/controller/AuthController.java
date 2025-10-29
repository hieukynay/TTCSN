package com.englishcenter.controller;

import com.englishcenter.model.TaiKhoan;
import com.englishcenter.repository.TaiKhoanRepository;
import com.englishcenter.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AuthController {

    private final TaiKhoanRepository repo;
    private final PasswordEncoder encoder;
    private final JwtTokenProvider jwt;

    // Đăng ký tài khoản
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, Object> body) {
        String username = (String) body.get("username");
        String password = (String) body.get("password");
        String hoTen = (String) body.get("hoTen");
        String email = (String) body.get("email");
        String soDienThoai = (String) body.get("soDienThoai");
        String vaiTro = (String) body.getOrDefault("vaiTro", "HocVien");

        if (repo.existsByTenDangNhap(username)) {
            return ResponseEntity.badRequest().body("Tên đăng nhập đã tồn tại");
        }

        TaiKhoan tk = new TaiKhoan();
        tk.setTenDangNhap(username);
        tk.setMatKhau(encoder.encode(password));
        tk.setHoTen(hoTen);
        tk.setEmail(email);
        tk.setSoDienThoai(soDienThoai);
        tk.setVaiTro(vaiTro);
        tk.setTrangThai(true);
        repo.save(tk);

        return ResponseEntity.ok("Đăng ký thành công");
    }

    // Đăng nhập
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String password = body.get("password");
        TaiKhoan tk = repo.findByTenDangNhap(username).orElse(null);

        if (tk == null || !encoder.matches(password, tk.getMatKhau())) {
            return ResponseEntity.status(401).body("Sai tài khoản hoặc mật khẩu");
        }

        String token = jwt.generateToken(tk.getTenDangNhap(), tk.getVaiTro());
        return ResponseEntity.ok(Map.of(
                "accessToken", token,
                "role", tk.getVaiTro(),
                "userId", tk.getMaTaiKhoan()
        ));
    }
}
