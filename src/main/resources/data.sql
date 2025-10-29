-- password "123456" (BCrypt: $2a$10$XxL5iL9QyD1ZPpufidkTxuUQTrgYfZReZb4ySl1x9gGfD1yHZvLdy)
INSERT INTO TaiKhoan (ten_dang_nhap, mat_khau, ho_ten, email, so_dien_thoai, vai_tro, trang_thai)
VALUES ('admin', '$2a$10$XxL5iL9QyD1ZPpufidkTxuUQTrgYfZReZb4ySl1x9gGfD1yHZvLdy', N'Quản trị viên', 'admin@gmail.com', '0900000001', 'Admin', 1);

INSERT INTO TaiKhoan (ten_dang_nhap, mat_khau, ho_ten, email, so_dien_thoai, vai_tro, trang_thai)
VALUES ('gv1', '$2a$10$XxL5iL9QyD1ZPpufidkTxuUQTrgYfZReZb4ySl1x9gGfD1yHZvLdy', N'Nguyễn Văn Giáo', 'gv1@gmail.com', '0900000002', 'GiaoVien', 1);
INSERT INTO GiaoVien (tai_khoan_ma_tai_khoan, bang_cap, kinh_nghiem, chuyen_mon)
SELECT ma_tai_khoan, N'Cử nhân Sư phạm Anh', 5, N'Ngữ pháp' FROM TaiKhoan WHERE ten_dang_nhap='gv1';

INSERT INTO TaiKhoan (ten_dang_nhap, mat_khau, ho_ten, email, so_dien_thoai, vai_tro, trang_thai)
VALUES ('hv1', '$2a$10$XxL5iL9QyD1ZPpufidkTxuUQTrgYfZReZb4ySl1x9gGfD1yHZvLdy', N'Lê Thị Học', 'hv1@gmail.com', '0900000003', 'HocVien', 1);
INSERT INTO HocVien (tai_khoan_ma_tai_khoan)
SELECT ma_tai_khoan FROM TaiKhoan WHERE ten_dang_nhap='hv1';
