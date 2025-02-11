/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author nguye
 */
public class PhieuGiamGia {

    public class Voucher {
        @Getter
        @Setter
        private int ID_voucher;
        private String tenKhuyenMai;
        private Date ngayBatDau;
        private Date ngayKetThuc;
        private Date ngayTao;
        private String trangThai;
        private double mucGiamGia;
        private String dieuKienApDung;
        private String hinhThucGiamGia;
        private double mucGiamGiaToiDa;

        // Constructor
        public Voucher(int ID_voucher, String tenKhuyenMai, Date ngayBatDau, Date ngayKetThuc, Date ngayTao, String trangThai, double mucGiamGia, String dieuKienApDung, String hinhThucGiamGia, double mucGiamGiaToiDa) {
            this.ID_voucher = ID_voucher;
            this.tenKhuyenMai = tenKhuyenMai;
            this.ngayBatDau = ngayBatDau;
            this.ngayKetThuc = ngayKetThuc;
            this.ngayTao = ngayTao;
            this.trangThai = trangThai;
            this.mucGiamGia = mucGiamGia;
            this.dieuKienApDung = dieuKienApDung;
            this.hinhThucGiamGia = hinhThucGiamGia;
            this.mucGiamGiaToiDa = mucGiamGiaToiDa;
        }
        
    }
}
