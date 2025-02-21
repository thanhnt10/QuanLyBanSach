package Model;
import java.math.BigDecimal;
import java.util.Date;

public class PhieuGiamGia {

    private int id;                    // INT IDENTITY(1,1) PRIMARY KEY
    private String maPhieuGiamGia;     // NVARCHAR(50) UNIQUE NOT NULL
    private String tenPhieuGiamGia;    // NVARCHAR(255) NOT NULL
    private int soLuong;               // INT NOT NULL CHECK (SoLuong >= 0)
    private Date ngayBatDau;           // DATE
    private Date ngayKetThuc;          // DATE
    private BigDecimal soTienGiam;     // DECIMAL(18,2) NOT NULL CHECK (SoTienGiam >= 0)

    // Constructor mặc định (không tham số)
    public PhieuGiamGia() {
    }

    // Constructor đầy đủ tham số
    public PhieuGiamGia(int id, String maPhieuGiamGia, String tenPhieuGiamGia, int soLuong,
            Date ngayBatDau, Date ngayKetThuc, BigDecimal soTienGiam) {
        this.id = id;
        this.maPhieuGiamGia = maPhieuGiamGia;
        this.tenPhieuGiamGia = tenPhieuGiamGia;
        this.soLuong = soLuong;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.soTienGiam = soTienGiam;
    }

    // Getter và Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaPhieuGiamGia() {
        return maPhieuGiamGia;
    }

    public void setMaPhieuGiamGia(String maPhieuGiamGia) {
        this.maPhieuGiamGia = maPhieuGiamGia;
    }

    public String getTenPhieuGiamGia() {
        return tenPhieuGiamGia;
    }

    public void setTenPhieuGiamGia(String tenPhieuGiamGia) {
        this.tenPhieuGiamGia = tenPhieuGiamGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        if (soLuong >= 0) { // Kiểm tra CHECK (SoLuong >= 0)
            this.soLuong = soLuong;
        } else {
            throw new IllegalArgumentException("Số lượng phải >= 0");
        }
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public BigDecimal getSoTienGiam() {
        return soTienGiam;
    }

    public void setSoTienGiam(BigDecimal soTienGiam) {
        if (soTienGiam != null && soTienGiam.compareTo(BigDecimal.ZERO) >= 0) { // Kiểm tra CHECK (SoTienGiam >= 0)
            this.soTienGiam = soTienGiam;
        } else {
            throw new IllegalArgumentException("Số tiền giảm phải >= 0");
        }
    }

    // Phương thức toString() để dễ debug hoặc hiển thị thông tin
    @Override
    public String toString() {
        return "PhieuGiamGia{"
                + "id=" + id
                + ", maPhieuGiamGia='" + maPhieuGiamGia + '\''
                + ", tenPhieuGiamGia='" + tenPhieuGiamGia + '\''
                + ", soLuong=" + soLuong
                + ", ngayBatDau=" + ngayBatDau
                + ", ngayKetThuc=" + ngayKetThuc
                + ", soTienGiam=" + soTienGiam
                + '}';
    }
}
