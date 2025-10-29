// ======================= CONFIG =======================
const API_BASE = localStorage.getItem('API_BASE') || 'http://localhost:8080/api';

// =================== AUTH STORAGE =====================
function saveAuth(token, role, userId){
  localStorage.setItem('AUTH_TOKEN', token || '');
  localStorage.setItem('AUTH_ROLE', role || '');
  localStorage.setItem('AUTH_UID',  String(userId ?? ''));
}
function getAuth(){
  const token = localStorage.getItem('AUTH_TOKEN') || '';
  const role  = localStorage.getItem('AUTH_ROLE') || '';
  const uid   = localStorage.getItem('AUTH_UID')  || '';
  if (!token && !role && !uid) return null;
  return { token, role, userId: uid ? parseInt(uid,10) : null };
}
function clearAuth(){
  localStorage.removeItem('AUTH_TOKEN');
  localStorage.removeItem('AUTH_ROLE');
  localStorage.removeItem('AUTH_UID');
}
function redirectByRole(role){
  if (role === 'Admin') location.href = 'admin.html';
  else if (role === 'GiaoVien') location.href = 'giaovien.html';
  else location.href = 'hocvien.html';
}
function requireRole(required){
  const auth = getAuth();
  if (!auth) { location.href = 'index.html'; return null; }
  if (required && auth.role !== required){
    alert('Bạn không có quyền truy cập trang này.');
    location.href = 'index.html';
    return null;
  }
  const logoutBtn = document.getElementById('logoutBtn');
  if (logoutBtn) logoutBtn.onclick = () => { clearAuth(); location.href = 'index.html'; };
  return auth;
}

// ===================== FETCH HELPERS ==================
function apiFetch(path, opts = {}){
  const headers = Object.assign({}, opts.headers || {});
  const auth = getAuth();
  if (auth?.token) headers['Authorization'] = 'Bearer ' + auth.token;
  return fetch(API_BASE + path, { ...opts, headers });
}

// ====================== AUTH API ======================
async function apiLogin(username, password){
  const res = await fetch(API_BASE + '/auth/login', {
    method: 'POST',
    headers: { 'Content-Type':'application/json' },
    body: JSON.stringify({ username, password })
  });
  if (!res.ok) throw new Error('Sai tài khoản hoặc mật khẩu');
  const data = await res.json(); // { accessToken, role, userId }
  saveAuth(data.accessToken, data.role, data.userId);
  return data;
}
async function apiRegister({tenDangNhap, matKhau, hoTen, email, soDienThoai, vaiTro='HocVien'}){
  const payload = { username: tenDangNhap, password: matKhau, hoTen, email, soDienThoai, vaiTro };
  const res = await fetch(API_BASE + '/auth/register', {
    method: 'POST',
    headers: { 'Content-Type':'application/json' },
    body: JSON.stringify(payload)
  });
  if (!res.ok) throw new Error('Đăng ký thất bại');
  return await res.text();
}

// ==================== STUDENT API =====================
const StudentAPI = {
  listOpenClasses: () => apiFetch('/student/courses'),
  enrollClass: (classId, maHocVien) =>
    apiFetch(`/student/register/${classId}?maHocVien=${encodeURIComponent(maHocVien)}`, { method: 'POST' }),
  listAssignments: (classId) => apiFetch(`/student/classes/${classId}/assignments`),
  submitAssignment: (asmId, maHocVien, noiDungTraLoi, file) => {
    const form = new FormData();
    form.append('maHocVien', maHocVien);
    if (noiDungTraLoi) form.append('noiDungTraLoi', noiDungTraLoi);
    if (file) form.append('file', file);
    return apiFetch(`/student/assignments/${asmId}/submit`, { method: 'POST', body: form });
  },
  createPayment: (maHocVien, body) =>
    apiFetch(`/student/payments?maHocVien=${encodeURIComponent(maHocVien)}`, {
      method: 'POST',
      headers: { 'Content-Type':'application/json' },
      body: JSON.stringify(body)
    }),
  paymentHistory: (maHocVien) => apiFetch(`/student/payments?maHocVien=${encodeURIComponent(maHocVien)}`)
};

// ==================== TEACHER API =====================
const TeacherAPI = {
  listClasses: () => apiFetch('/teacher/classes'),
  createClass: (lopHoc) =>
    apiFetch('/teacher/classes', { method:'POST', headers:{'Content-Type':'application/json'}, body: JSON.stringify(lopHoc) }),
  deleteClass: (id) => apiFetch(`/teacher/classes/${id}`, { method:'DELETE' }),
  listStudents: (classId) => apiFetch(`/teacher/classes/${classId}/students`),
  addStudent: (classId, hocVienObj) =>
    apiFetch(`/teacher/classes/${classId}/students`, { method:'POST', headers:{'Content-Type':'application/json'}, body: JSON.stringify(hocVienObj) }),
  createAssignment: (asm) =>
    apiFetch('/teacher/assignments', { method:'POST', headers:{'Content-Type':'application/json'}, body: JSON.stringify(asm) }),
  listAssignments: (classId) => apiFetch(`/teacher/classes/${classId}/assignments`),
  grade: (diem) =>
    apiFetch('/teacher/grades', { method:'POST', headers:{'Content-Type':'application/json'}, body: JSON.stringify(diem) })
};

// ===================== ADMIN API ======================
const AdminAPI = {
  listTeachers: () => apiFetch('/admin/teachers'),
  addTeacher: (gv) =>
    apiFetch('/admin/teachers', { method:'POST', headers:{'Content-Type':'application/json'}, body: JSON.stringify(gv) }),
  updateTeacher: (id, gv) =>
    apiFetch(`/admin/teachers/${id}`, { method:'PUT', headers:{'Content-Type':'application/json'}, body: JSON.stringify(gv) }),
  deleteTeacher: (id) => apiFetch(`/admin/teachers/${id}`, { method:'DELETE' }),

  listCourses: () => apiFetch('/admin/courses'),
  addCourse: (kh) =>
    apiFetch('/admin/courses', { method:'POST', headers:{'Content-Type':'application/json'}, body: JSON.stringify(kh) }),
  deleteCourse: (id) => apiFetch(`/admin/courses/${id}`, { method:'DELETE' })
};

// =============== PAYMENT & SCHEDULE (CHUNG) ==========
const MomoAPI = {
  // Tạo thanh toán MoMo; nếu backend trả payUrl/redirect thì sẽ chuyển hướng
  create: (amount, orderInfo) => apiFetch('/payment/momo', {
    method:'POST',
    headers:{'Content-Type':'application/x-www-form-urlencoded'},
    body: new URLSearchParams({ amount, orderInfo })
  })
};
const ScheduleAPI = { me: () => apiFetch('/schedule/me') };

// tiện ích debug
window.__setApiBase = (url) => { localStorage.setItem('API_BASE', url); alert('API_BASE set to ' + url); };
