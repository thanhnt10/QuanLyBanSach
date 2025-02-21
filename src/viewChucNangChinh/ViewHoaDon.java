/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package viewChucNangChinh;

import Model.HoaDon;
import Repository.HoaDonRepo;
import Repository.ChiTietHoaDonRepo;
import Model.ChiTietHoaDon;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.Document; // Lớp để tạo tài liệu PDF
import com.itextpdf.text.DocumentException; // Xử lý ngoại lệ khi tạo PDF
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph; // Thêm đoạn văn bản vào PDF
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable; // Tạo bảng trong PDF
import com.itextpdf.text.pdf.PdfWriter; // Ghi nội dung vào file PDF
import javax.swing.*; // Thư viện để sử dụng các thành phần GUI như JOptionPane
import java.io.FileOutputStream; // Để ghi dữ liệu ra file
import java.io.IOException; // Xử lý ngoại lệ khi làm việc với file

/**
 *
 * @author Hoang
 */
public class ViewHoaDon extends javax.swing.JPanel {

    private HoaDonRepo hoaDonRepo;
    private ChiTietHoaDonRepo chiTietHoaDonRepo;

    public ViewHoaDon() {
        initComponents();
        hoaDonRepo = new HoaDonRepo();
        chiTietHoaDonRepo = new ChiTietHoaDonRepo();  // Repository cho chi tiết hóa đơn
        loadHoaDonList();
    }

    private void loadHoaDonList() {
        DefaultTableModel model = (DefaultTableModel) HoaDon.getModel();
        model.setRowCount(0);
        ArrayList<HoaDon> hoaDons = hoaDonRepo.getAllHoaDon();
        for (HoaDon hoaDon : hoaDons) {
            model.addRow(new Object[]{
                hoaDon.getMaHoaDon(),
                hoaDon.getMaKhachHang(),
                hoaDon.getMaNhanVien(),
                hoaDon.getMaPhieuGiamGia(),
                hoaDon.getNgayTao(),
                hoaDon.getTongTien(),
                hoaDon.getSoTienGiam(),
                hoaDon.getThanhTien()
            });
        }
    }

    private void loadChiTietHoaDon(String maHoaDon) {
        DefaultTableModel model = (DefaultTableModel) ChiTietHoaDon.getModel();
        model.setRowCount(0);

        ArrayList<ChiTietHoaDon> chiTietList = chiTietHoaDonRepo.getChiTietByHoaDon(maHoaDon);

        for (ChiTietHoaDon chiTiet : chiTietList) {
            model.addRow(new Object[]{
                chiTiet.getMaSanPham(),
                chiTiet.getTenSanPham(),
                chiTiet.getSoLuong(),
                chiTiet.getDonGia(),
                chiTiet.getThanhTien()
            });
        }
    }

    private void HoaDonMouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = HoaDon.getSelectedRow();
        if (selectedRow != -1) {
            String maHoaDon = (String) HoaDon.getValueAt(selectedRow, 0);
            loadChiTietHoaDon(maHoaDon);
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

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        HoaDon = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ChiTietHoaDon = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        MaHoaDon = new javax.swing.JTextField();
        MaNhanVien = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        MaKhachHang = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ThoiGianTu = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        ThoiGianDen = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        Xuat = new javax.swing.JButton();

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("QUẢN LÍ HOÁ ĐƠN");

        HoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hoá đơn", "Mã khách hàng", "Mã nhân viên", "Mã giảm giá", "Ngày tạo", "Tổng tiền", "Giảm giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(HoaDon);
        if (HoaDon.getColumnModel().getColumnCount() > 0) {
            HoaDon.getColumnModel().getColumn(0).setResizable(false);
            HoaDon.getColumnModel().getColumn(1).setResizable(false);
            HoaDon.getColumnModel().getColumn(2).setResizable(false);
            HoaDon.getColumnModel().getColumn(3).setResizable(false);
            HoaDon.getColumnModel().getColumn(4).setResizable(false);
            HoaDon.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Chi tiết hoá đơn");

        ChiTietHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(ChiTietHoaDon);
        if (ChiTietHoaDon.getColumnModel().getColumnCount() > 0) {
            ChiTietHoaDon.getColumnModel().getColumn(0).setResizable(false);
            ChiTietHoaDon.getColumnModel().getColumn(1).setResizable(false);
            ChiTietHoaDon.getColumnModel().getColumn(2).setResizable(false);
            ChiTietHoaDon.getColumnModel().getColumn(3).setResizable(false);
            ChiTietHoaDon.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Mã hoá đơn");

        jLabel4.setText("Mã nhân viên");

        jLabel5.setText("Mã khách hàng");

        jLabel6.setText("Thời gian từ");

        ThoiGianTu.setDateFormatString("yyyy-MM-dd");

        jLabel7.setText("đến");

        ThoiGianDen.setDateFormatString("yyyy-MM-dd");

        jButton1.setText("Tìm kiếm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26)
                        .addComponent(MaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(MaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(MaKhachHang)
                            .addComponent(ThoiGianTu, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(ThoiGianDen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(MaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(MaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ThoiGianDen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(MaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addComponent(ThoiGianTu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        Xuat.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        Xuat.setText("In hoá đơn");
        Xuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XuatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(15, 15, 15))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(150, 150, 150)
                .addComponent(Xuat)
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Xuat, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String maHoaDon = MaHoaDon.getText().trim();
        String maNhanVien = MaNhanVien.getText().trim();
        String maKhachHang = MaKhachHang.getText().trim();

// Lấy giá trị ngày từ JDateChooser
        java.util.Date tuNgay = ThoiGianTu.getDate();
        java.util.Date denNgay = ThoiGianDen.getDate();

        DefaultTableModel model = (DefaultTableModel) HoaDon.getModel();
        model.setRowCount(0);

        ArrayList<HoaDon> hoaDons = hoaDonRepo.getAllHoaDon();

        for (HoaDon hoaDon : hoaDons) {
            boolean matches = true;

            // Kiểm tra mã hóa đơn
            if (!maHoaDon.isEmpty() && !hoaDon.getMaHoaDon().contains(maHoaDon)) {
                matches = false;
            }

            // Kiểm tra mã nhân viên
            if (!maNhanVien.isEmpty() && !hoaDon.getMaNhanVien().contains(maNhanVien)) {
                matches = false;
            }

            // Kiểm tra mã khách hàng
            if (!maKhachHang.isEmpty() && !hoaDon.getMaKhachHang().contains(maKhachHang)) {
                matches = false;
            }

            // Kiểm tra thời gian từ và đến
            if (tuNgay != null && denNgay != null) {
                java.util.Date ngayTaoHoaDon = hoaDon.getNgayTao(); // Giả sử getNgayTao() trả về kiểu java.util.Date
                if (ngayTaoHoaDon.before(tuNgay) || ngayTaoHoaDon.after(denNgay)) {
                    matches = false;
                }
            }
// hekiiii
            // Nếu tất cả điều kiện khớp, thêm vào bảng
            if (matches) {
                model.addRow(new Object[]{
                    hoaDon.getMaHoaDon(),
                    hoaDon.getMaKhachHang(),
                    hoaDon.getMaNhanVien(),
                    hoaDon.getMaPhieuGiamGia(),
                    hoaDon.getNgayTao(),
                    hoaDon.getTongTien()
                });
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void XuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XuatActionPerformed
        int option = JOptionPane.showConfirmDialog(
                this,
                "Bạn có muốn in hóa đơn không?",
                "Xác nhận in hóa đơn",
                JOptionPane.YES_NO_OPTION
        );

        if (option == JOptionPane.YES_OPTION) {
            Document document = new Document();
            try {
                String userHome = System.getProperty("user.home");
                String downloadsPath = userHome + "/Downloads/HoaDon.pdf";

                PdfWriter.getInstance(document, new FileOutputStream(downloadsPath));
                document.open();

                Font font = FontFactory.getFont(FontFactory.HELVETICA, 12);

                document.add(new Paragraph("HOA DON BAN HANG", font));
                document.add(new Paragraph("Ngay: " + new java.util.Date(), font));
                document.add(new Paragraph(" "));

                PdfPTable table = new PdfPTable(8);
                table.setWidthPercentage(100);

                table.addCell(new Paragraph("Ma hoa don", font));
                table.addCell(new Paragraph("Ma khach hang", font));
                table.addCell(new Paragraph("Ma nhan vien", font));
                table.addCell(new Paragraph("Ma giam gia", font));
                table.addCell(new Paragraph("Ngay tao", font));
                table.addCell(new Paragraph("Tong tien", font));
                table.addCell(new Paragraph("Giam gia", font));
                table.addCell(new Paragraph("Thanh tien", font));

                DefaultTableModel model = (DefaultTableModel) HoaDon.getModel();
                int rowCount = model.getRowCount();

                for (int i = 0; i < rowCount; i++) {
                    String maHoaDon = model.getValueAt(i, 0) != null ? model.getValueAt(i, 0).toString() : "";
                    String maKhachHang = model.getValueAt(i, 1) != null ? model.getValueAt(i, 1).toString() : "";
                    String maNhanVien = model.getValueAt(i, 2) != null ? model.getValueAt(i, 2).toString() : "";
                    String maGiamGia = model.getValueAt(i, 3) != null ? model.getValueAt(i, 3).toString() : "";
                    String ngayTao = model.getValueAt(i, 4) != null ? model.getValueAt(i, 4).toString() : "";
                    String tongTien = model.getValueAt(i, 5) != null ? model.getValueAt(i, 5).toString() : "";
                    String giamGia = model.getValueAt(i, 6) != null ? model.getValueAt(i, 6).toString() : "";
                    String thanhTien = model.getValueAt(i, 7) != null ? model.getValueAt(i, 7).toString() : "";

                    table.addCell(new Paragraph(maHoaDon, font));
                    table.addCell(new Paragraph(maKhachHang, font));
                    table.addCell(new Paragraph(maNhanVien, font));
                    table.addCell(new Paragraph(maGiamGia, font));
                    table.addCell(new Paragraph(ngayTao, font));
                    table.addCell(new Paragraph(tongTien, font));
                    table.addCell(new Paragraph(giamGia, font));
                    table.addCell(new Paragraph(thanhTien, font));
                }

                document.add(table);
                document.close();

                JOptionPane.showMessageDialog(this, "Xuất hóa đơn thành công: " + downloadsPath);
            } catch (DocumentException | IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Lỗi khi xuất hóa đơn: " + e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Lỗi không xác định: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Bạn đã hủy in hóa đơn.");
        }

    }//GEN-LAST:event_XuatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ChiTietHoaDon;
    private javax.swing.JTable HoaDon;
    private javax.swing.JTextField MaHoaDon;
    private javax.swing.JTextField MaKhachHang;
    private javax.swing.JTextField MaNhanVien;
    private com.toedter.calendar.JDateChooser ThoiGianDen;
    private com.toedter.calendar.JDateChooser ThoiGianTu;
    private javax.swing.JButton Xuat;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
