/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Utils.DBConnection;
import java.sql.*;

/**
 *
 * @author Hoang
 */
public class NhanVienRepo {

    public boolean dangNhap(String maNhanVien, String matKhau) {
        String sql = """
                     Select maNhanVien ,matKhau FROM NhanVien Where maNhanVien=? AND matKhau=?
                     """;
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, maNhanVien);
            ps.setString(2, matKhau);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
