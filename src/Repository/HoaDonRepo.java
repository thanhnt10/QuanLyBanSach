/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.HoaDon;
import Utils.DBConnection;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author thanhnguyen
 */
public class HoaDonRepo {

    private Connection conn;

    public HoaDonRepo() {
        conn = DBConnection.getConnection();
    }

    public ArrayList<HoaDon> getAllHoaDon() {
        ArrayList<HoaDon> list = new ArrayList<>();
        String sql = "SELECT HD.MaHoaDon, NV.MaNhanVien, KH.MaKhachHang, PGG.MaPhieuGiamGia, HD.NgayTao, HD.TongTien, PGG.SoTienGiam, (HD.TongTien - COALESCE(PGG.SoTienGiam, 0)) AS ThanhTien "
                + "FROM HoaDon HD "
                + "JOIN NhanVien NV ON HD.IDNhanVien = NV.ID "
                + "JOIN KhachHang KH ON HD.IDKhachHang = KH.ID "
                + "LEFT JOIN PhieuGiamGia PGG ON HD.IDPhieuGiamGia = PGG.ID";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                list.add(new HoaDon(
                        rs.getString("MaHoaDon"),
                        rs.getString("MaNhanVien"),
                        rs.getString("MaKhachHang"),
                        rs.getString("MaPhieuGiamGia"),
                        rs.getDate("NgayTao"),
                        rs.getDouble("TongTien"),
                        rs.getDouble("SoTienGiam"),
                        rs.getDouble("ThanhTien")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
