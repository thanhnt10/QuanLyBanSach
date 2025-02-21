package Repository;

import Model.KhachHang;
import Utils.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KhachHangRepository {
    private Connection connection;

    // Constructor sử dụng DBConnection để lấy kết nối
    public KhachHangRepository() {
        connection = DBConnection.getConnection();
        if (connection == null) {
            throw new RuntimeException("Không thể kết nối đến cơ sở dữ liệu!");
        }
    }

    // Thêm khách hàng mới
    public boolean themKhachHang(KhachHang kh) {
        String sql = "INSERT INTO KhachHang (MaKhachHang, TenKhachHang, SDT, Email, GioiTinh, NgaySinh) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, kh.getMaKhachHang());
            ps.setString(2, kh.getTenKhachHang());
            ps.setString(3, kh.getSdt());
            ps.setString(4, kh.getEmail());
            ps.setBoolean(5, kh.isGioiTinh()); // BIT: true = 1 (Nam), false = 0 (Nữ)
            ps.setDate(6, new java.sql.Date(kh.getNgaySinh().getTime())); // Chuyển Date sang SQL Date

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Sửa thông tin khách hàng
    public boolean suaKhachHang(KhachHang kh) {
        String sql = "UPDATE KhachHang SET MaKhachHang = ?, TenKhachHang = ?, SDT = ?, Email = ?, " +
                     "GioiTinh = ?, NgaySinh = ? WHERE ID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, kh.getMaKhachHang());
            ps.setString(2, kh.getTenKhachHang());
            ps.setString(3, kh.getSdt());
            ps.setString(4, kh.getEmail());
            ps.setBoolean(5, kh.isGioiTinh());
            ps.setDate(6, new java.sql.Date(kh.getNgaySinh().getTime()));
            ps.setInt(7, kh.getId());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Xóa khách hàng theo ID
    public boolean xoaKhachHang(int id) {
        String sql = "DELETE FROM KhachHang WHERE ID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Tìm kiếm khách hàng theo mã khách hàng
    public List<KhachHang> timKiemTheoMa(String maKhachHang) {
        List<KhachHang> result = new ArrayList<>();
        String sql = "SELECT * FROM KhachHang WHERE MaKhachHang LIKE ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, "%" + maKhachHang + "%"); // Tìm kiếm gần đúng
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang(
                    rs.getInt("ID"),
                    rs.getString("MaKhachHang"),
                    rs.getString("TenKhachHang"),
                    rs.getString("SDT"),
                    rs.getString("Email"),
                    rs.getBoolean("GioiTinh"),
                    rs.getDate("NgaySinh")
                );
                result.add(kh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Tìm kiếm khách hàng theo tên khách hàng
    public List<KhachHang> timKiemTheoTen(String tenKhachHang) {
        List<KhachHang> result = new ArrayList<>();
        String sql = "SELECT * FROM KhachHang WHERE TenKhachHang LIKE ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, "%" + tenKhachHang + "%"); // Tìm kiếm gần đúng
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang(
                    rs.getInt("ID"),
                    rs.getString("MaKhachHang"),
                    rs.getString("TenKhachHang"),
                    rs.getString("SDT"),
                    rs.getString("Email"),
                    rs.getBoolean("GioiTinh"),
                    rs.getDate("NgaySinh")
                );
                result.add(kh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Lấy toàn bộ danh sách khách hàng
    public List<KhachHang> layDanhSachKhachHang() {
        List<KhachHang> result = new ArrayList<>();
        String sql = "SELECT * FROM KhachHang";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                KhachHang kh = new KhachHang(
                    rs.getInt("ID"),
                    rs.getString("MaKhachHang"),
                    rs.getString("TenKhachHang"),
                    rs.getString("SDT"),
                    rs.getString("Email"),
                    rs.getBoolean("GioiTinh"),
                    rs.getDate("NgaySinh")
                );
                result.add(kh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Đóng kết nối khi không sử dụng nữa
}