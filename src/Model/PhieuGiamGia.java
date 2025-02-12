/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author nguye
 */
public class PhieuGiamGia {
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

        public PhieuGiamGia() {
        }

        // Constructor
        public PhieuGiamGia(int ID_voucher, String tenKhuyenMai, Date ngayBatDau, Date ngayKetThuc, Date ngayTao, String trangThai, double mucGiamGia, String dieuKienApDung, String hinhThucGiamGia, double mucGiamGiaToiDa) {
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

    public int getID_voucher() {
        return ID_voucher;
    }

    public void setID_voucher(int ID_voucher) {
        this.ID_voucher = ID_voucher;
    }

    public String getTenKhuyenMai() {
        return tenKhuyenMai;
    }

    public void setTenKhuyenMai(String tenKhuyenMai) {
        this.tenKhuyenMai = tenKhuyenMai;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public double getMucGiamGia() {
        return mucGiamGia;
    }

    public void setMucGiamGia(double mucGiamGia) {
        this.mucGiamGia = mucGiamGia;
    }

    public String getDieuKienApDung() {
        return dieuKienApDung;
    }

    public void setDieuKienApDung(String dieuKienApDung) {
        this.dieuKienApDung = dieuKienApDung;
    }

    public String getHinhThucGiamGia() {
        return hinhThucGiamGia;
    }

    public void setHinhThucGiamGia(String hinhThucGiamGia) {
        this.hinhThucGiamGia = hinhThucGiamGia;
    }

    public double getMucGiamGiaToiDa() {
        return mucGiamGiaToiDa;
    }

    public void setMucGiamGiaToiDa(double mucGiamGiaToiDa) {
        this.mucGiamGiaToiDa = mucGiamGiaToiDa;
    }

    }

