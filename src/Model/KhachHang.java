/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author nguye
 */
import java.util.Date;

public class KhachHang {
    private int id;                    // INT IDENTITY(1,1) PRIMARY KEY
    private String maKhachHang;        // NVARCHAR(50) UNIQUE NOT NULL
    private String tenKhachHang;       // NVARCHAR(255) NOT NULL
    private String sdt;                // VARCHAR(20) CHECK (SDT LIKE '[0-9]%')
    private String email;              // NVARCHAR(255)
    private boolean gioiTinh;          // BIT CHECK (GioiTinh IN (0,1)) - true cho 1 (Nam), false cho 0 (Nữ)
    private Date ngaySinh;             // DATE

    // Constructor mặc định (không tham số)
    public KhachHang() {
    }

    // Constructor đầy đủ tham số
    public KhachHang(int id, String maKhachHang, String tenKhachHang, String sdt, String email, 
                     boolean gioiTinh, Date ngaySinh) {
        this.id = id;
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.sdt = sdt;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
    }

    // Getter và Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        if (sdt == null || sdt.isEmpty() || sdt.matches("^[0-9].*")) { // Kiểm tra SDT bắt đầu bằng số
            this.sdt = sdt;
        } else {
            throw new IllegalArgumentException("Số điện thoại phải bắt đầu bằng số!");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isGioiTinh() { // Sử dụng isGioiTinh() cho boolean
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh; // true cho Nam (1), false cho Nữ (0)
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    // Phương thức toString() để dễ debug hoặc hiển thị thông tin
    @Override
    public String toString() {
        return "KhachHang{" +
                "id=" + id +
                ", maKhachHang='" + maKhachHang + '\'' +
                ", tenKhachHang='" + tenKhachHang + '\'' +
                ", sdt='" + sdt + '\'' +
                ", email='" + email + '\'' +
                ", gioiTinh=" + (gioiTinh ? "Nam" : "Nữ") +
                ", ngaySinh=" + ngaySinh +
                '}';
    }
}
