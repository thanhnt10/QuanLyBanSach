/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.PhieuGiamGia;
import Utils.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class PhieuGiamGiaRepo {

    private Connection conn = null;

    public PhieuGiamGiaRepo() {
        conn = DBConnection.getConnection();
    }

    public ArrayList<PhieuGiamGia> getAll() {
        ArrayList<PhieuGiamGia> list = new ArrayList<>();
        String sql = """
                     SELECT ID_voucher, 
                            tenKhuyenMai, 
                            ngayBatDau, 
                            ngayKetThuc, 
                            ngayTao, 
                            trangThai, 
                            mucGiamGia, 
                            dieuKienApDung, 
                            hinhThucGiamGia, 
                            mucGiamGiaToiDa
                     FROM Voucher;""";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                list.add(new PhieuGiamGia(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getDate(4),
                        rs.getDate(5),
                        rs.getString(6),
                        rs.getDouble(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getDouble(10)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }
}
