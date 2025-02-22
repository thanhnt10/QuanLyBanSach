package Repository;

import Model.NhanVien;
import Utils.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public NhanVienRepo() {

        con = DBConnection.getConnection();
    }

    public ArrayList<NhanVien> getAll() {
        ArrayList<NhanVien> listNV = new ArrayList<>();
        String sql = "SELECT [ID]\n"
                + "      ,[MaNhanVien]\n"
                + "      ,[TenNhanVien]\n"
                + "      ,[GioiTinh]\n"
                + "      ,[NgaySinh]\n"
                + "      ,[SDT]\n"
                + "      ,[IdChucVu]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[NhanVien]";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int idNhanVien, idChucVu;
                String maNhanVien, tenNhanVien, ngaySinh, soDienThoai;
                boolean gioiTinh, trangThai;
                idNhanVien = rs.getInt(1);
                maNhanVien = rs.getString(2);
                tenNhanVien = rs.getString(3);
                gioiTinh = rs.getBoolean(4);
                ngaySinh = rs.getString(5);
                soDienThoai = rs.getString(6);
                idChucVu = rs.getInt(7);
                trangThai = rs.getBoolean(8);

                listNV.add(new NhanVien(idNhanVien, maNhanVien, idChucVu, tenNhanVien, ngaySinh, soDienThoai, gioiTinh, ngaySinh, trangThai));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNV;
    }

    public int deleteNV(String id) {
        sql = "DELETE FROM [dbo].[NhanVien]\n"
                + "      WHERE id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }
public int updateNV(NhanVien nv) {
    String sql = "UPDATE NhanVien SET MaNhanVien = ?, TenNhanVien = ?, SDT = ?, GioiTinh = ?, NgaySinh = ?, IDChucVu = ?, TrangThai = ? WHERE ID = ?";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setObject(1, nv.getMaNhanVien());
        ps.setObject(2, nv.getTenNhanVien());
        ps.setObject(3, nv.getSoDienThoai());
        ps.setObject(4, nv.isGioiTinh()); 
        ps.setObject(5, nv.getNgaySinh());
        ps.setObject(6, nv.getIdChucVu());
        ps.setObject(7, nv.isTrangThai()); 
        ps.setObject(8, nv.getIdNhanVien());

        return ps.executeUpdate(); 
    } catch (SQLException e) {
        e.printStackTrace();
        return 0;
    }
}


    public int addNV(NhanVien nv) {
        sql = "INSERT INTO [dbo].[NhanVien]\n"
                + "           ([MaNhanVien]\n"
                + "           ,[TenNhanVien]\n"
                + "           ,[GioiTinh]\n"
                + "           ,[NgaySinh]\n"
                + "           ,[SDT]\n"
                + "           ,[IDChucVu]\n"
                + "           ,[TrangThai])"
                + "     VALUES (?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            //Vì có ? nên phải set dl cho ?
            ps.setObject(1, nv.getMaNhanVien());
            ps.setObject(2, nv.getTenNhanVien());//số 1 = ? thứ nhất
            ps.setObject(3, nv.isGioiTinh());
            ps.setObject(4, nv.getNgaySinh());
            ps.setObject(5, nv.getSoDienThoai());
            ps.setObject(6, nv.getIdChucVu());
            ps.setObject(7, nv.isTrangThai());
            return ps.executeUpdate(); //thêm, sửa, xóa
        } catch (SQLException e) {
            return 0;
        }
    }
    
//  public List<Model.NhanVien> timKiem(String keyword) {
//    List<Model.NhanVien> list = new ArrayList<>();
//    String query = """
//                   SELECT ID, MaNhanVien, TenNhanVien, GioiTinh, NgaySinh, SDT, IDChucVu, TrangThai 
//                   FROM NhanVien
//                   WHERE 
//                      (ISNUMERIC(?) = 1 AND ID = ?)  -- Nếu là số, tìm theo ID
//                      OR MaNhanVien LIKE ? 
//                      OR TenNhanVien LIKE ? 
//                      OR TrangThai = ? 
//                   """;
//
//    try (Connection conn = DBConnection.getConnection();
//         PreparedStatement ps = conn.prepareStatement(query)) {
//
//        boolean isNumber = keyword.matches("\\d+"); // Kiểm tra keyword có phải số không
//        Integer trangThai = null;
//
//        // Xử lý tìm kiếm trạng thái (BIT: 1 = Đang làm, 0 = Nghỉ)
//        if (keyword.equalsIgnoreCase("Đang làm")) {
//            trangThai = 1;
//        } else if (keyword.equalsIgnoreCase("Nghỉ")) {
//            trangThai = 0;
//        }
//
//        ps.setString(1, keyword); // Kiểm tra nếu keyword là số
//        if (isNumber) {
//            ps.setInt(2, Integer.parseInt(keyword)); // Tìm theo ID
//        } else {
//            ps.setNull(2, java.sql.Types.INTEGER);
//        }
//        ps.setString(3, "%" + keyword + "%"); // MaNhanVien
//        ps.setString(4, "%" + keyword + "%"); // TenNhanVien
//
//        if (trangThai != null) {
//            ps.setInt(5, trangThai); // Tìm theo TrangThai (BIT)
//        } else {
//            ps.setNull(5, java.sql.Types.INTEGER);
//        }
//
//        System.out.println("Query: " + query);
//        System.out.println("Keyword: %" + keyword + "%");
//
//        ResultSet rs = ps.executeQuery();
//        while (rs.next()) {
//            Model.NhanVien nv = new Model.NhanVien();
//            nv.setIdNhanVien(rs.getInt("ID"));
//            nv.setMaNhanVien(rs.getString("MaNhanVien"));
//            nv.setTenNhanVien(rs.getString("TenNhanVien"));
//            nv.setGioiTinh(rs.getBoolean("GioiTinh"));
//            nv.setNgaySinh(rs.getString("NgaySinh"));
//            nv.setSoDienThoai(rs.getString("SDT"));
//            nv.setIdChucVu(rs.getInt("IDChucVu"));
//            nv.setTrangThai(rs.getBoolean("TrangThai"));
//            list.add(nv);
//        }
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//
//    System.out.println("Số kết quả tìm thấy: " + list.size());
//    return list;
//    
  
//    
//}
  
    public ArrayList<Model.NhanVien> getAll_TaiKhoan() {
        ArrayList<NhanVien> list = new ArrayList<>();
        sql = "select MaNhanVien from NhanVien ";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNhanVien(rs.getString(1));
                list.add(nv);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
public ArrayList<Model.NhanVien> search(String search) {
        ArrayList<Model.NhanVien> list = new ArrayList<>();
        sql = """
                   SELECT ID, MaNhanVien, TenNhanVien, GioiTinh, NgaySinh, SDT, IDChucVu, TrangThai 
                   FROM NhanVien
                   WHERE 
                      CAST(ID AS NVARCHAR) LIKE ?
                      OR MaNhanVien LIKE ? 
                      OR TenNhanVien LIKE ? 
     
  
                     
                   """;
        try {
             
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + search + "%");
            ps.setString(2, search + "%");
            ps.setString(3, "%" + search + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               Model.NhanVien nv = new Model.NhanVien();
            nv.setIdNhanVien(rs.getInt("ID"));
            nv.setMaNhanVien(rs.getString("MaNhanVien"));
            nv.setTenNhanVien(rs.getString("TenNhanVien"));
            nv.setGioiTinh(rs.getBoolean("GioiTinh"));
            nv.setNgaySinh(rs.getString("NgaySinh"));
            nv.setSoDienThoai(rs.getString("SDT"));
            nv.setIdChucVu(rs.getInt("IDChucVu"));
            nv.setTrangThai(rs.getBoolean("TrangThai"));
            list.add(nv);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }


}


    
    

