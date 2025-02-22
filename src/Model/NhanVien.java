/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

//import java.util.Date;
//import java.util.Vector;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Hoang
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NhanVien {
    private int idNhanVien ;
   
    private String maNhanVien;
    
    private int idChucVu;
    
    private String tenNhanVien;
    
    private String ngaySinh;
    
    private String soDienThoai;
    
    private boolean gioiTinh;
    
    private String matKhau;
       
    private boolean trangThai;

    public NhanVien(String maNhanVien, int idChucVu, String tenNhanVien, String ngaySinh, String soDienThoai, boolean gioiTinh, boolean trangThai) {
        this.maNhanVien = maNhanVien;
        this.idChucVu = idChucVu;
        this.tenNhanVien = tenNhanVien;
        this.ngaySinh = ngaySinh;
        this.soDienThoai = soDienThoai;
        this.gioiTinh = gioiTinh;

        this.trangThai = trangThai;
    }

    
    
    

    public Object[] toDataRow() {
    return new Object[]{
        this.getIdNhanVien(), 
        this.getMaNhanVien(), 
        this.getTenNhanVien(), 
        this.isGioiTinh() ? "Nam" : "Nữ", 
        this.getNgaySinh(), 
        this.getSoDienThoai(), 
        this.getIdChucVu(), 
        this.isTrangThai() ? "Đang làm" : "Đã nghỉ"
    };
}

}
