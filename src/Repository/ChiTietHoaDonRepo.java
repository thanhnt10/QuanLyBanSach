/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.ChiTietHoaDon;
import Utils.DBConnection;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author thanhnguyen
 */
public class ChiTietHoaDonRepo {

    private Connection conn;

    public ChiTietHoaDonRepo() {
        conn = DBConnection.getConnection();
    }

    public ArrayList<ChiTietHoaDon> getChiTietByHoaDon(String maHoaDon) {
        ArrayList<ChiTietHoaDon> list = new ArrayList<>();
        String sql = "SELECT CTHD.MaChiTietHoaDon, SP.MaSanPham, SP.TenSanPham, CTHD.SoLuong, SP.GiaBan, (CTHD.SoLuong * SP.GiaBan) AS ThanhTien "
                + "FROM ChiTietHoaDon CTHD "
                + "JOIN SanPham SP ON CTHD.IDSanPham = SP.ID "
                + "WHERE CTHD.IDHoaDon = (SELECT ID FROM HoaDon WHERE MaHoaDon = ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maHoaDon);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ChiTietHoaDon(
                        rs.getString("MaChiTietHoaDon"),
                        maHoaDon,
                        rs.getString("MaSanPham"),
                        rs.getString("TenSanPham"),
                        rs.getInt("SoLuong"),
                        rs.getDouble("GiaBan"),
                        rs.getDouble("ThanhTien")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
