/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package viewChucNangChinh;

import Repository.KhachHangRepository;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import Model.KhachHang;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class ViewKhachHang extends javax.swing.JPanel {

    private KhachHangRepository repository = new KhachHangRepository();
    private DefaultTableModel model;

    /**
     * Creates new form ViewPhieuGiamGia
     */
    public ViewKhachHang() {
        initComponents();
        model = (DefaultTableModel) tblKhachHang.getModel();
        loadDataToTable(); // Tải dữ liệu khi khởi tạo
        addButtonListeners();
    }
    private boolean isMaKhachHangExists(String maKhachHang) {
        List<KhachHang> list = repository.timKiemTheoMa(maKhachHang);
        return !list.isEmpty();
    }
    private void loadDataToTable() {
        model.setRowCount(0); // Xóa dữ liệu cũ
        List<KhachHang> list = repository.layDanhSachKhachHang();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (KhachHang kh : list) {
            model.addRow(new Object[]{
                kh.getMaKhachHang(),
                sdf.format(kh.getNgaySinh()),
                kh.getTenKhachHang(),
                kh.getSdt(),
                kh.isGioiTinh() ? "Nam" : "Nữ",
                kh.getEmail()
            });
        }
    }

    private KhachHang getFormData() throws ParseException {
        String ma = txtMa.getText().trim();
        String ten = txtTenKhachHang.getText().trim();
        String sdt = txtSDT.getText().trim();
        String email = txtEmail.getText().trim();
        boolean gioiTinh = rdoNam.isSelected();
        String namSinhStr = txtNamSinh.getText().trim();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date ngaySinh = sdf.parse(namSinhStr);

        return new KhachHang(0, ma, ten, sdt, email, gioiTinh, ngaySinh);
    }

    private int getIdFromMa(String maKhachHang) {
        List<KhachHang> list = repository.timKiemTheoMa(maKhachHang);
        if (!list.isEmpty()) {
            return list.get(0).getId();
        }
        return -1;
    }

    private void fillFormFromSelectedRow() {
        int selectedRow = tblKhachHang.getSelectedRow();
        if (selectedRow >= 0) {
            txtMa.setText((String) tblKhachHang.getValueAt(selectedRow, 0));
            txtNamSinh.setText((String) tblKhachHang.getValueAt(selectedRow, 1));
            txtTenKhachHang.setText((String) tblKhachHang.getValueAt(selectedRow, 2));
            txtSDT.setText((String) tblKhachHang.getValueAt(selectedRow, 3));
            String gioiTinh = (String) tblKhachHang.getValueAt(selectedRow, 4);
            if (gioiTinh.equals("Nam")) {
                rdoNam.setSelected(true);
            } else {
                rdoNu.setSelected(true);
            }
            txtEmail.setText((String) tblKhachHang.getValueAt(selectedRow, 5));
        }
    }

    private void lamMoiForm() {
        txtMa.setText("");
        txtTenKhachHang.setText("");
        txtSDT.setText("");
        txtEmail.setText("");
        txtNamSinh.setText("");
        rdoNu.setSelected(true);
        txtSearchByMa1.setText("");
        btnSearchByTen.setText("");
        loadDataToTable();
    }
    private void addButtonListeners() {
        btnThem.addActionListener(evt -> themKhachHang());
        btnSua.addActionListener(evt -> suaKhachHang());
        btnXoa.addActionListener(evt -> xoaKhachHang());
        btnTimKiem.addActionListener(evt -> timKiemKhachHang());
        btnLamMoi.addActionListener(evt -> lamMoiForm());
    }   
    private void timKiemKhachHang() {
        String ma = txtSearchByMa1.getText().trim();
        String ten = btnSearchByTen.getText().trim();
        model.setRowCount(0);

        if (!ma.isEmpty()) {
            List<KhachHang> list = repository.timKiemTheoMa(ma);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            for (KhachHang kh : list) {
                model.addRow(new Object[]{
                    kh.getMaKhachHang(),
                    sdf.format(kh.getNgaySinh()),
                    kh.getTenKhachHang(),
                    kh.getSdt(),
                    kh.isGioiTinh() ? "Nam" : "Nữ",
                    kh.getEmail()
                });
            }
        } else if (!ten.isEmpty()) {
            List<KhachHang> list = repository.timKiemTheoTen(ten);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            for (KhachHang kh : list) {
                model.addRow(new Object[]{
                    kh.getMaKhachHang(),
                    sdf.format(kh.getNgaySinh()),
                    kh.getTenKhachHang(),
                    kh.getSdt(),
                    kh.isGioiTinh() ? "Nam" : "Nữ",
                    kh.getEmail()
                });
            }
        } else {
            loadDataToTable(); // Nếu không nhập gì thì hiển thị toàn bộ
        }
    }
    private void xoaKhachHang() {
        int selectedRow = tblKhachHang.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng để xóa!");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa khách hàng này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            String maKhachHang = (String) tblKhachHang.getValueAt(selectedRow, 0);
            int id = getIdFromMa(maKhachHang);
            if (repository.xoaKhachHang(id)) {
                JOptionPane.showMessageDialog(this, "Xóa khách hàng thành công!");
                loadDataToTable();
                lamMoiForm();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa khách hàng thất bại!");
            }
        }
    }
    private void suaKhachHang() {
        int selectedRow = tblKhachHang.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng để sửa!");
            return; 
        }
        try {
            KhachHang kh = getFormData();
            String maKhachHangMoi = kh.getMaKhachHang();
            String maKhachHangCu = (String) tblKhachHang.getValueAt(selectedRow, 0);

            // Nếu mã mới khác mã cũ, kiểm tra tính duy nhất
            if (!maKhachHangMoi.equals(maKhachHangCu) && isMaKhachHangExists(maKhachHangMoi)) {
                JOptionPane.showMessageDialog(this, "Mã khách hàng mới đã tồn tại! Vui lòng nhập mã khác.");
                return;
            }

            kh.setId(getIdFromMa(maKhachHangCu)); // Sử dụng mã cũ để lấy ID
            if (repository.suaKhachHang(kh)) {
                JOptionPane.showMessageDialog(this, "Sửa khách hàng thành công!");
                loadDataToTable();
                lamMoiForm();
            } else {
                JOptionPane.showMessageDialog(this, "Sửa khách hàng thất bại!");
            }
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Ngày sinh phải có định dạng yyyy-MM-dd!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
        }
    }
    private void themKhachHang() {
        try {
            KhachHang kh = getFormData();
            String maKhachHang = kh.getMaKhachHang();

            // Kiểm tra mã khách hàng đã tồn tại chưa
            if (isMaKhachHangExists(maKhachHang)) {
                JOptionPane.showMessageDialog(this, "Mã khách hàng đã tồn tại! Vui lòng nhập mã khác.");
                return;
            }   

            if (repository.themKhachHang(kh)) {
                JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công!");
                loadDataToTable();
                lamMoiForm();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm khách hàng thất bại!");
            }
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Ngày sinh phải có định dạng yyyy-MM-dd!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtTenKhachHang = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        txtNamSinh = new javax.swing.JTextField();
        btnXoa = new javax.swing.JButton();
        txtSearchByMa1 = new javax.swing.JTextField();
        btnSearchByTen = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("QUẢN LÍ KHÁCH HÀNG");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 14, -1, -1));

        jLabel2.setText("Mã : ");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel3.setText("Tên khách hàng");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 110, -1, -1));

        jLabel6.setText("Giới tính");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));
        add(txtMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 67, 188, -1));
        add(txtTenKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 107, 188, -1));
        add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, 188, -1));

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã ", "Năm sinh", "Tên khách hàng", "Số điện thoại", "Giới tính", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhachHang);
        if (tblKhachHang.getColumnModel().getColumnCount() > 0) {
            tblKhachHang.getColumnModel().getColumn(0).setResizable(false);
            tblKhachHang.getColumnModel().getColumn(1).setResizable(false);
            tblKhachHang.getColumnModel().getColumn(2).setResizable(false);
            tblKhachHang.getColumnModel().getColumn(3).setResizable(false);
            tblKhachHang.getColumnModel().getColumn(4).setResizable(false);
            tblKhachHang.getColumnModel().getColumn(5).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 742, 239));

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");
        add(rdoNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, -1, -1));

        buttonGroup1.add(rdoNu);
        rdoNu.setSelected(true);
        rdoNu.setText("Nữ");
        rdoNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNuActionPerformed(evt);
            }
        });
        add(rdoNu, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, -1, -1));

        jLabel8.setText("Số điện thoại");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, -1, -1));

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, -1, -1));

        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });
        add(btnLamMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 210, -1, -1));

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, -1, -1));

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });
        add(btnTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, -1, -1));
        add(txtNamSinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 188, -1));

        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, -1, -1));
        add(txtSearchByMa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 110, 24));
        add(btnSearchByTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 260, 120, 24));

        jLabel12.setText("Năm sinh");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, -1, -1));

        jLabel13.setText("Mã khách hàng");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, -1));

        jLabel14.setText("Tên khách hàng");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, -1, -1));

        jLabel4.setText("Email");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, -1, -1));
        add(txtSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, 188, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void rdoNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNuActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        fillFormFromSelectedRow();
    }//GEN-LAST:event_tblKhachHangMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JTextField btnSearchByTen;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtNamSinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSearchByMa1;
    private javax.swing.JTextField txtTenKhachHang;
    // End of variables declaration//GEN-END:variables
}
