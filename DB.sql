create database poly_test;
go
use poly_test;
go
-- Bảng KhachHang

CREATE TABLE KhachHang (
    ID_khachHang INT PRIMARY KEY,
    maKhachHang VARCHAR(50),
    hoVaTen VARCHAR(100),
    ngaySinh DATE,
    gioiTinh VARCHAR(10),
    soDienThoai VARCHAR(15),
    diaChi VARCHAR(255),
    trangThai VARCHAR(50)
);
go
-- Bảng ChucVu
CREATE TABLE ChucVu (
    ID_chucVu INT PRIMARY KEY,
    ma VARCHAR(50),
    ten VARCHAR(100),
    vaiTro VARCHAR(100)
);
go
-- Bảng NhanVien
CREATE TABLE NhanVien (
    ID_nhanVien INT PRIMARY KEY,
    ID_chucVu INT,
    tenNhanVien VARCHAR(100),
    ngaySinh DATE,
    soDienThoai VARCHAR(15),
    email VARCHAR(100),
    queQuan VARCHAR(100),
    gioiTinh VARCHAR(10),
    matKhau VARCHAR(255),
    maNhanVien VARCHAR(50),
    trangThai VARCHAR(50),
    FOREIGN KEY (ID_chucVu) REFERENCES ChucVu(ID_chucVu)
);
go
-- Bảng Voucher
CREATE TABLE Voucher (
    ID_voucher INT PRIMARY KEY,
    tenKhuyenMai VARCHAR(100),
    ngayBatDau DATE,
    ngayKetThuc DATE,
    ngayTao DATE,
    trangThai VARCHAR(50),
    mucGiamGia DECIMAL(10, 2),
    dieuKienApDung VARCHAR(255),
    hinhThucGiamGia VARCHAR(50),
    mucGiamGiaToiDa DECIMAL(10, 2)
);
go
-- Bảng HoaDon
CREATE TABLE HoaDon (
    ID_hoaDon INT PRIMARY KEY,
    ID_khachHang INT,
    ID_nhanVien INT,
    ID_voucher INT,
    ngayTao DATE,
    tongTien DECIMAL(15, 2),
    tenKhachHang VARCHAR(100),
    soDienThoaiKhachHang VARCHAR(15),
    tenNhanVien VARCHAR(100),
    trangThai VARCHAR(50),
    soTienGiam DECIMAL(10, 2),
    FOREIGN KEY (ID_khachHang) REFERENCES KhachHang(ID_khachHang),
    FOREIGN KEY (ID_nhanVien) REFERENCES NhanVien(ID_nhanVien),
    FOREIGN KEY (ID_voucher) REFERENCES Voucher(ID_voucher)
);
go
-- Bảng HoaDonChiTiet
CREATE TABLE HoaDonChiTiet (
    ID_hoaDonChiTiet INT PRIMARY KEY,
    ID_hoaDon INT,
    tenSanPham VARCHAR(100),
    soLuong INT,
    giaBan DECIMAL(10, 2),
    ID_sanPhamChiTiet INT,
    FOREIGN KEY (ID_hoaDon) REFERENCES HoaDon(ID_hoaDon)
);
go
-- Bảng ThuongHieu
CREATE TABLE ThuongHieu (
    ID_thuongHieu INT PRIMARY KEY,
    tenThuongHieu VARCHAR(100)
);
go
-- Bảng XuatXu
CREATE TABLE XuatXu (
    ID_xuatXu INT PRIMARY KEY,
    tenXuatXu VARCHAR(100)
);
go
-- Bảng KichThuoc
CREATE TABLE KichThuoc (
    ID_kichThuoc INT PRIMARY KEY,
    kichThuoc VARCHAR(50)
);
go
-- Bảng MauSac
CREATE TABLE MauSac (
    ID_mauSac INT PRIMARY KEY,
    tenMau VARCHAR(50)
);
go
-- Bảng ChatLieu
CREATE TABLE ChatLieu (
    ID_chatLieu INT PRIMARY KEY,
    tenChatLieu VARCHAR(100)
);
go
-- Bảng SanPham
CREATE TABLE SanPham (
    ID_sanPham INT PRIMARY KEY,
    tenSanPham VARCHAR(100),
    soLuong INT,
    trangThai VARCHAR(50),
    ID_thuongHieu INT,
    ID_xuatXu INT,
    FOREIGN KEY (ID_thuongHieu) REFERENCES ThuongHieu(ID_thuongHieu),
    FOREIGN KEY (ID_xuatXu) REFERENCES XuatXu(ID_xuatXu)
);
go
-- Bảng ChiTietSanPham
CREATE TABLE ChiTietSanPham (
    ID_chiTietSanPham INT PRIMARY KEY,
    ID_sanPham INT,
    ID_kichThuoc INT,
    ID_mauSac INT,
    ID_chatLieu INT,
    soLuong INT,
    giaBan DECIMAL(10, 2),
    trangThai VARCHAR(50),
    FOREIGN KEY (ID_sanPham) REFERENCES SanPham(ID_sanPham),
    FOREIGN KEY (ID_kichThuoc) REFERENCES KichThuoc(ID_kichThuoc),
    FOREIGN KEY (ID_mauSac) REFERENCES MauSac(ID_mauSac),
    FOREIGN KEY (ID_chatLieu) REFERENCES ChatLieu(ID_chatLieu)
);
go

-- Dữ liệu mẫu cho KhachHang
INSERT INTO KhachHang VALUES
(1, 'KH001', 'Nguyễn Văn A', '1990-01-01', 'Nam', '0912345678', 'Hà Nội', 'Hoạt động'),
(2, 'KH002', 'Trần Thị B', '1992-05-10', 'Nữ', '0912345679', 'Hồ Chí Minh', 'Hoạt động'),
(3, 'KH003', 'Lê Văn C', '1985-11-20', 'Nam', '0912345680', 'Đà Nẵng', 'Hoạt động'),
(4, 'KH004', 'Phạm Thị D', '1993-07-15', 'Nữ', '0912345681', 'Cần Thơ', 'Hoạt động'),
(5, 'KH005', 'Võ Văn E', '1988-09-25', 'Nam', '0912345682', 'Huế', 'Hoạt động');
go
-- Dữ liệu mẫu cho ChucVu
INSERT INTO ChucVu VALUES
(1, 'CV001', 'Nhân viên bán hàng', 'Bán hàng'),
(2, 'CV002', 'Nhân viên kho', 'Quản lý kho'),
(3, 'CV003', 'Nhân viên kỹ thuật', 'Hỗ trợ kỹ thuật'),
(4, 'CV004', 'Nhân viên chăm sóc khách hàng', 'CSKH'),
(5, 'CV005', 'Quản lý', 'Quản lý cửa hàng');
go
-- Dữ liệu mẫu cho NhanVien
INSERT INTO NhanVien VALUES
(1, 1, 'Nguyễn Anh Tuấn', '1995-02-20', '0912123456', 'tuan@gmail.com', 'Hà Nội', 'Nam', 'password123', 'NV001', 'Hoạt động'),
(2, 2, 'Phạm Văn Minh', '1988-03-15', '0912123457', 'minh@gmail.com', 'Hải Phòng', 'Nam', 'password123', 'NV002', 'Hoạt động'),
(3, 3, 'Lê Thị Lan', '1991-06-25', '0912123458', 'lan@gmail.com', 'Đà Nẵng', 'Nữ', 'password123', 'NV003', 'Hoạt động'),
(4, 4, 'Trần Văn Bình', '1990-12-10', '0912123459', 'binh@gmail.com', 'Hồ Chí Minh', 'Nam', 'password123', 'NV004', 'Hoạt động'),
(5, 5, 'Võ Thị Hồng', '1992-04-08', '0912123460', 'hong@gmail.com', 'Cần Thơ', 'Nữ', 'password123', 'NV005', 'Hoạt động');
go
-- Dữ liệu mẫu cho Voucher
INSERT INTO Voucher VALUES
(1, 'Giảm giá 10%', '2024-01-01', '2024-12-31', '2024-01-01', 'Hoạt động', 10.00, 'Đơn hàng trên 500,000', 'Phần trăm', 50.00),
(2, 'Giảm giá 15%', '2024-02-01', '2024-11-30', '2024-02-01', 'Hoạt động', 15.00, 'Đơn hàng trên 1,000,000', 'Phần trăm', 100.00),
(3, 'Giảm giá 50,000', '2024-03-01', '2024-10-31', '2024-03-01', 'Hết hạn', 50000, 'Đơn hàng trên 200,000', 'Giá trị', 0),
(4, 'Giảm giá 20%', '2024-04-01', '2024-09-30', '2024-04-01', 'Hết hạn', 20.00, 'Đơn hàng trên 1,500,000', 'Phần trăm', 150.00),
(5, 'Giảm giá 100,000', '2024-05-01', '2024-08-31', '2024-05-01', 'Hoạt động', 100000, 'Đơn hàng trên 2,000,000', 'Giá trị', 0);
go
-- Dữ liệu mẫu cho HoaDon
INSERT INTO HoaDon VALUES
(1, 1, 1, 1, '2024-06-01', 1000000, 'Nguyễn Văn A', '0912345678', 'Nguyễn Anh Tuấn', 'Đã thanh toán', 100000),
(2, 2, 2, 2, '2024-06-05', 1500000, 'Trần Thị B', '0912345679', 'Phạm Văn Minh', 'Đã thanh toán', 225000),
(3, 3, 3, 3, '2024-06-10', 800000, 'Lê Văn C', '0912345680', 'Lê Thị Lan', 'Đã hủy', 50000),
(4, 4, 4, NULL, '2024-06-15', 1200000, 'Phạm Thị D', '0912345681', 'Trần Văn Bình', 'Chưa thanh toán', 0),
(5, 5, 5, 5, '2024-06-20', 2000000, 'Võ Văn E', '0912345682', 'Võ Thị Hồng', 'Đã thanh toán', 100000);
go
-- Dữ liệu mẫu cho HoaDonChiTiet
INSERT INTO HoaDonChiTiet VALUES
(1, 1, 'Áo Thun', 2, 200000, 1),
(2, 1, 'Quần Jean', 1, 400000, 2),
(3, 2, 'Áo Khoác', 3, 300000, 3),
(4, 3, 'Áo Sơ Mi', 1, 250000, 4),
(5, 4, 'Quần Short', 2, 150000, 5);
go
-- Dữ liệu mẫu cho ThuongHieu
INSERT INTO ThuongHieu VALUES
(1, 'Thương hiệu A'),
(2, 'Thương hiệu B'),
(3, 'Thương hiệu C'),
(4, 'Thương hiệu D'),
(5, 'Thương hiệu E');
go
-- Dữ liệu mẫu cho XuatXu
INSERT INTO XuatXu VALUES
(1, 'Việt Nam'),
(2, 'Trung Quốc'),
(3, 'Mỹ'),
(4, 'Nhật Bản'),
(5, 'Hàn Quốc');
go
-- Dữ liệu mẫu cho KichThuoc
INSERT INTO KichThuoc VALUES
(1, 'S'),
(2, 'M'),
(3, 'L'),
(4, 'XL'),
(5, 'XXL');
go
-- Dữ liệu mẫu cho MauSac
INSERT INTO MauSac VALUES
(1, 'Đỏ'),
(2, 'Xanh'),
(3, 'Vàng'),
(4, 'Đen'),
(5, 'Trắng');
go
-- Dữ liệu mẫu cho ChatLieu
INSERT INTO ChatLieu VALUES
(1, 'Cotton'),
(2, 'Polyester'),
(3, 'Len'),
(4, 'Lụa'),
(5, 'Nỉ');
go
-- Dữ liệu mẫu cho SanPham
INSERT INTO SanPham VALUES
(1, 'Áo Thun', 100, 'Còn hàng', 1, 1),
(2, 'Quần Jean', 50, 'Còn hàng', 2, 2),
(3, 'Áo Khoác', 30, 'Còn hàng', 3, 3),
(4, 'Quần Short', 20, 'Còn hàng', 4, 4),
(5, 'Áo Sơ Mi', 60, 'Còn hàng', 5, 5);
go
-- Dữ liệu mẫu cho ChiTietSanPham
INSERT INTO ChiTietSanPham VALUES
(1, 1, 1, 1, 1, 10, 200000, 'Còn hàng'),
(2, 2, 2, 2, 2, 5, 400000, 'Còn hàng'),
(3, 3, 3, 3, 3, 7, 300000, 'Còn hàng'),
(4, 4, 4, 4, 4, 3, 150000, 'Còn hàng'),
(5, 5, 5, 5, 5, 8, 250000, 'Còn hàng');
go

SELECT * FROM KhachHang;
SELECT * FROM ChucVu;
SELECT * FROM NhanVien;
SELECT * FROM Voucher;
SELECT * FROM HoaDon;
SELECT * FROM HoaDonChiTiet;
SELECT * FROM SanPham;
SELECT * FROM ChiTietSanPham;
SELECT * FROM ThuongHieu;
SELECT * FROM XuatXu;
SELECT * FROM KichThuoc;
SELECT * FROM MauSac;
SELECT * FROM ChatLieu;
