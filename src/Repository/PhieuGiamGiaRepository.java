package Repository;
import Utils.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.util.Date;
import Model.PhieuGiamGia;
public class PhieuGiamGiaRepository {
    
    // Lấy tất cả phiếu giảm giá từ cơ sở dữ liệu
    public List<PhieuGiamGia> getAll() {
        List<PhieuGiamGia> list = new ArrayList<>();
        String query = "SELECT ID, MaPhieuGiamGia, TenPhieuGiamGia, SoLuong, NgayBatDau, NgayKetThuc, SoTienGiam " +
                       "FROM PhieuGiamGia";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                PhieuGiamGia pgg = new PhieuGiamGia();
                pgg.setId(rs.getInt("ID"));
                pgg.setMaPhieuGiamGia(rs.getString("MaPhieuGiamGia"));
                pgg.setTenPhieuGiamGia(rs.getString("TenPhieuGiamGia"));
                pgg.setSoLuong(rs.getInt("SoLuong"));
                pgg.setNgayBatDau(rs.getDate("NgayBatDau"));
                pgg.setNgayKetThuc(rs.getDate("NgayKetThuc"));
                pgg.setSoTienGiam(rs.getBigDecimal("SoTienGiam"));
                list.add(pgg);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    // Lấy một phiếu giảm giá theo ID
    public PhieuGiamGia getById(int id) {
        String query = "SELECT ID, MaPhieuGiamGia, TenPhieuGiamGia, SoLuong, NgayBatDau, NgayKetThuc, SoTienGiam " +
                       "FROM PhieuGiamGia WHERE ID = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    PhieuGiamGia pgg = new PhieuGiamGia();
                    pgg.setId(rs.getInt("ID"));
                    pgg.setMaPhieuGiamGia(rs.getString("MaPhieuGiamGia"));
                    pgg.setTenPhieuGiamGia(rs.getString("TenPhieuGiamGia"));
                    pgg.setSoLuong(rs.getInt("SoLuong"));
                    pgg.setNgayBatDau(rs.getDate("NgayBatDau"));
                    pgg.setNgayKetThuc(rs.getDate("NgayKetThuc"));
                    pgg.setSoTienGiam(rs.getBigDecimal("SoTienGiam"));
                    return pgg;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    // Thêm một phiếu giảm giá mới
    public boolean add(PhieuGiamGia pgg) {
        String query = "INSERT INTO PhieuGiamGia (MaPhieuGiamGia, TenPhieuGiamGia, SoLuong, NgayBatDau, NgayKetThuc, SoTienGiam) " +
                       "VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            
            ps.setString(1, pgg.getMaPhieuGiamGia());
            ps.setString(2, pgg.getTenPhieuGiamGia());
            ps.setInt(3, pgg.getSoLuong());
            ps.setDate(4, pgg.getNgayBatDau() != null ? new java.sql.Date(pgg.getNgayBatDau().getTime()) : null);
            ps.setDate(5, pgg.getNgayKetThuc() != null ? new java.sql.Date(pgg.getNgayKetThuc().getTime()) : null);
            ps.setBigDecimal(6, pgg.getSoTienGiam());
            
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            return false;
        }
    }

    // Cập nhật thông tin phiếu giảm giá
    public boolean update(PhieuGiamGia pgg) {
        String query = "UPDATE PhieuGiamGia SET MaPhieuGiamGia = ?, TenPhieuGiamGia = ?, SoLuong = ?, " +
                       "NgayBatDau = ?, NgayKetThuc = ?, SoTienGiam = ? WHERE ID = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            
            ps.setString(1, pgg.getMaPhieuGiamGia());
            ps.setString(2, pgg.getTenPhieuGiamGia());
            ps.setInt(3, pgg.getSoLuong());
            ps.setDate(4, pgg.getNgayBatDau() != null ? new java.sql.Date(pgg.getNgayBatDau().getTime()) : null);
            ps.setDate(5, pgg.getNgayKetThuc() != null ? new java.sql.Date(pgg.getNgayKetThuc().getTime()) : null);
            ps.setBigDecimal(6, pgg.getSoTienGiam());
            ps.setInt(7, pgg.getId());
            
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            return false;
        }
    }

    // Xóa một phiếu giảm giá theo ID
    public boolean delete(int id) {
        String query = "DELETE FROM PhieuGiamGia WHERE ID = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            return false;
        }
    }

    // Test phương thức
//    public static void main(String[] args) {
//        PhieuGiamGiaRepository repo = new PhieuGiamGiaRepository();
//        
//        // Test lấy tất cả
//        List<PhieuGiamGia> list = repo.getAll();
//        for (PhieuGiamGia pgg : list) {
//            System.out.println(pgg);
//        }
//        
//        // Test lấy theo ID (giả sử ID = 1 tồn tại)
//        PhieuGiamGia pgg = repo.getById(1);
//        if (pgg != null) {
//            System.out.println("Phiếu giảm giá ID 1: " + pgg);
//        }
//    }
}