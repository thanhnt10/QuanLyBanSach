/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Thanh
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NhanVien {
    private int idNhanVien ;
    
    private int idChucVu;
    
    private String tenNhanVien;
    
    private Date ngaySinh;
    
    private String soDienThoai;
    
    private String Email;
    
    private String queQuan;
    
    private String gioiTinh;
    
    private String matKhau;
    
    private String maNhanVien;
    
    private String trangThai;
}
