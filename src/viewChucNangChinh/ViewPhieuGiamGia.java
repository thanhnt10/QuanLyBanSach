/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package viewChucNangChinh;

import Repository.PhieuGiamGiaRepository;
import Model.PhieuGiamGia;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ViewPhieuGiamGia extends javax.swing.JPanel {

    /**
     * Creates new form ViewPhieuGiamGia
     */
    private PhieuGiamGiaRepository repository;
    private DefaultTableModel tableModel;

    public ViewPhieuGiamGia() {
        initComponents();
        repository = new PhieuGiamGiaRepository();
        tableModel = (DefaultTableModel) tblPhieuGiamGia.getModel();
        loadTableData(); // Load dữ liệu khi khởi tạo
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSoTienGiam = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNgayBatDau = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNgayKetThuc = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhieuGiamGia = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(800, 700));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("QUẢN LÍ PHIẾU GIẢM GIÁ");

        jLabel2.setText("Mã : ");

        jLabel3.setText("Tên phiếu giảm giá : ");

        txtTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenActionPerformed(evt);
            }
        });

        jLabel4.setText("Số tiền giảm");

        jLabel5.setText("Ngày bắt đầu : ");

        jLabel6.setText("Ngày kết thúc : ");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/PhieuGiamGia.png"))); // NOI18N

        tblPhieuGiamGia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã giảm giá ", "Tên giảm giá", "Số lượng", "Số tiền giảm", "Ngày bắt đầu", "Ngày kết thúc"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPhieuGiamGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuGiamGiaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPhieuGiamGia);
        if (tblPhieuGiamGia.getColumnModel().getColumnCount() > 0) {
            tblPhieuGiamGia.getColumnModel().getColumn(0).setResizable(false);
            tblPhieuGiamGia.getColumnModel().getColumn(1).setResizable(false);
            tblPhieuGiamGia.getColumnModel().getColumn(2).setResizable(false);
            tblPhieuGiamGia.getColumnModel().getColumn(3).setResizable(false);
            tblPhieuGiamGia.getColumnModel().getColumn(4).setResizable(false);
            tblPhieuGiamGia.getColumnModel().getColumn(5).setResizable(false);
            tblPhieuGiamGia.getColumnModel().getColumn(6).setResizable(false);
        }

        btnAdd.setText("Thêm ");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuaMouseClicked(evt);
            }
        });
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xoá");
        btnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaMouseClicked(evt);
            }
        });

        jLabel7.setText("Mã giảm giá ");

        btnSearch.setText("Tìm kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel9.setText("Số lượng");

        txtSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtMa, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                            .addComponent(txtTen)
                                            .addComponent(txtSoTienGiam)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnAdd)
                                                .addGap(50, 50, 50)
                                                .addComponent(btnSua)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(55, 55, 55)
                                                .addComponent(btnXoa))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel5)
                                                    .addComponent(jLabel6)
                                                    .addComponent(jLabel9))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                                                    .addComponent(txtNgayBatDau, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtSoLuong)))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(60, 60, 60)
                                        .addComponent(btnSearch)))
                                .addGap(0, 18, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)))
                        .addComponent(jLabel8))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtMa, txtSoTienGiam, txtTen});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtSoTienGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel8))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnSua)
                    .addComponent(btnXoa))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(btnSearch))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtMa, txtSoTienGiam, txtTen});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtNgayBatDau, txtNgayKetThuc});

    }// </editor-fold>//GEN-END:initComponents
    private void clearForm() {
        txtMa.setText("");
        txtTen.setText("");
        txtSoTienGiam.setText("");
        txtSoLuong.setText("");
        txtNgayBatDau.setText("");
        txtNgayKetThuc.setText("");
    }
    private boolean isMaPhieuExists(String maPhieu, int excludeId) {
        List<PhieuGiamGia> list = repository.getAll();
        for (PhieuGiamGia pgg : list) {
            if (pgg.getMaPhieuGiamGia().equals(maPhieu) && pgg.getId() != excludeId) {
                return true; // Mã đã tồn tại
            }
        }
        return false; // Mã chưa tồn tại
    }

    private void loadTableData() {
        tableModel.setRowCount(0); // Xóa dữ liệu cũ
        List<PhieuGiamGia> list = repository.getAll();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < list.size(); i++) {
            PhieuGiamGia pgg = list.get(i);
            Object[] row = {
                i + 1, // STT
                pgg.getMaPhieuGiamGia(),
                pgg.getTenPhieuGiamGia(),
                pgg.getSoLuong(), // Số lượng
                pgg.getSoTienGiam(), // Số tiền giảm
                pgg.getNgayBatDau() != null ? sdf.format(pgg.getNgayBatDau()) : "",
                pgg.getNgayKetThuc() != null ? sdf.format(pgg.getNgayKetThuc()) : ""
            };
            tableModel.addRow(row);
        }
    }

    private int getIdByMa(String maPhieu) {
        List<PhieuGiamGia> list = repository.getAll();
        for (PhieuGiamGia pgg : list) {
            if (pgg.getMaPhieuGiamGia().equals(maPhieu)) {
                return pgg.getId();
            }
        }
        return -1; // Không tìm thấy
    }
    private void txtTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            String maPhieu = txtMa.getText().trim();
            if (maPhieu.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Mã phiếu không được để trống!");
                return;
            }

            if (isMaPhieuExists(maPhieu, -1)) {
                JOptionPane.showMessageDialog(this, "Mã phiếu đã tồn tại!");
                return;
            }

            PhieuGiamGia pgg = new PhieuGiamGia();
            pgg.setMaPhieuGiamGia(maPhieu);
            pgg.setTenPhieuGiamGia(txtTen.getText());
            pgg.setSoTienGiam(txtSoTienGiam.getText().isEmpty() ? BigDecimal.ZERO : new BigDecimal(txtSoTienGiam.getText()));
            pgg.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            pgg.setNgayBatDau(txtNgayBatDau.getText().isEmpty() ? null : sdf.parse(txtNgayBatDau.getText()));
            pgg.setNgayKetThuc(txtNgayKetThuc.getText().isEmpty() ? null : sdf.parse(txtNgayKetThuc.getText()));

            if (repository.add(pgg)) {
                JOptionPane.showMessageDialog(this, "Thêm thành công!");
                loadTableData();
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại!");
            }
        } catch (NumberFormatException | ParseException e) {
            JOptionPane.showMessageDialog(this, "Lỗi: Vui lòng kiểm tra định dạng dữ liệu nhập vào!");
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaMouseClicked
        int selectedRow = tblPhieuGiamGia.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một phiếu để sửa!");
            return;
        }

        try {
            String maPhieu = txtMa.getText().trim();
            if (maPhieu.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Mã phiếu không được để trống!");
                return;
            }

            String oldMaPhieu = (String) tableModel.getValueAt(selectedRow, 1);
            int id = getIdByMa(oldMaPhieu);

            if (!maPhieu.equals(oldMaPhieu) && isMaPhieuExists(maPhieu, id)) {
                JOptionPane.showMessageDialog(this, "Mã phiếu đã tồn tại!");
                return;
            }

            PhieuGiamGia pgg = repository.getById(id);
            pgg.setMaPhieuGiamGia(maPhieu);
            pgg.setTenPhieuGiamGia(txtTen.getText());
            pgg.setSoTienGiam(txtSoTienGiam.getText().isEmpty() ? BigDecimal.ZERO : new BigDecimal(txtSoTienGiam.getText()));
            pgg.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            pgg.setNgayBatDau(txtNgayBatDau.getText().isEmpty() ? null : sdf.parse(txtNgayBatDau.getText()));
            pgg.setNgayKetThuc(txtNgayKetThuc.getText().isEmpty() ? null : sdf.parse(txtNgayKetThuc.getText()));

            if (repository.update(pgg)) {
                JOptionPane.showMessageDialog(this, "Sửa thành công!");
                loadTableData();
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Sửa thất bại!");
            }
        } catch (NumberFormatException | ParseException e) {
            JOptionPane.showMessageDialog(this, "Lỗi: Vui lòng kiểm tra định dạng dữ liệu nhập vào!");
        }
    }//GEN-LAST:event_btnSuaMouseClicked

    private void btnXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseClicked
        int selectedRow = tblPhieuGiamGia.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một phiếu để xóa!");
            return;
        }

        String maPhieu = (String) tableModel.getValueAt(selectedRow, 1);
        int id = getIdByMa(maPhieu);
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa phiếu này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            if (repository.delete(id)) {
                JOptionPane.showMessageDialog(this, "Xóa thành công!");
                loadTableData();
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại!");
            }
        }
    }//GEN-LAST:event_btnXoaMouseClicked

    private void tblPhieuGiamGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuGiamGiaMouseClicked
        int selectedRow = tblPhieuGiamGia.getSelectedRow();
        if (selectedRow >= 0) {
            txtMa.setText((String) tableModel.getValueAt(selectedRow, 1));
            txtTen.setText((String) tableModel.getValueAt(selectedRow, 2));
            txtSoLuong.setText(String.valueOf(repository.getById(getIdByMa(txtMa.getText())).getSoLuong()));
            txtSoTienGiam.setText(tableModel.getValueAt(selectedRow, 4).toString());
            txtNgayBatDau.setText((String) tableModel.getValueAt(selectedRow, 5));
            txtNgayKetThuc.setText((String) tableModel.getValueAt(selectedRow, 6));
        }
    }//GEN-LAST:event_tblPhieuGiamGiaMouseClicked

    private void txtSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String searchText = txtSearch.getText().trim().toLowerCase();
        if (searchText.isEmpty()) {
            loadTableData(); // Nếu không nhập gì, hiển thị toàn bộ dữ liệu
            return;
        }

        tableModel.setRowCount(0); // Xóa dữ liệu cũ
        List<PhieuGiamGia> list = repository.getAll();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        int stt = 1;

        for (PhieuGiamGia pgg : list) {
            boolean match = pgg.getMaPhieuGiamGia().toLowerCase().contains(searchText) ||
                           pgg.getTenPhieuGiamGia().toLowerCase().contains(searchText) ||
                           String.valueOf(pgg.getSoLuong()).contains(searchText) ||
                           pgg.getSoTienGiam().toString().contains(searchText) ||
                           (pgg.getNgayBatDau() != null && sdf.format(pgg.getNgayBatDau()).toLowerCase().contains(searchText)) ||
                           (pgg.getNgayKetThuc() != null && sdf.format(pgg.getNgayKetThuc()).toLowerCase().contains(searchText));

            if (match) {
                Object[] row = {
                    stt++, // STT
                    pgg.getMaPhieuGiamGia(),
                    pgg.getTenPhieuGiamGia(),
                    pgg.getSoLuong(),
                    pgg.getSoTienGiam(),
                    pgg.getNgayBatDau() != null ? sdf.format(pgg.getNgayBatDau()) : "",
                    pgg.getNgayKetThuc() != null ? sdf.format(pgg.getNgayKetThuc()) : ""
                };
                tableModel.addRow(row);
            }
        }

        if (tableModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy kết quả!");
        }
    }//GEN-LAST:event_btnSearchActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPhieuGiamGia;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtNgayBatDau;
    private javax.swing.JTextField txtNgayKetThuc;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtSoTienGiam;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
