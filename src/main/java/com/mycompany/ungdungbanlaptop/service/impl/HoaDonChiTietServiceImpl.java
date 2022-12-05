/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service.impl;

import com.mycompany.ungdungbanlaptop.entity.HoaDonChiTiet;
import com.mycompany.ungdungbanlaptop.model.viewModel.HoaDonChiTietKhuyenMai;
import com.mycompany.ungdungbanlaptop.model.viewModel.GioHangViewModel;
import com.mycompany.ungdungbanlaptop.model.viewModel.HoaDonChiTietSanPham;
import com.mycompany.ungdungbanlaptop.repository.HoaDonChiTietRepository;
import com.mycompany.ungdungbanlaptop.repository.impl.HoaDonChiTietRepositoryImpl;
import com.mycompany.ungdungbanlaptop.service.HoaDonChiTietService;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author Diệm DZ
 */
public class HoaDonChiTietServiceImpl implements HoaDonChiTietService {

    private HoaDonChiTietRepository hoaDonChiTietRepository = new HoaDonChiTietRepositoryImpl();

    @Override
    public List<HoaDonChiTiet> getAll() {
        return hoaDonChiTietRepository.getAll();
    }

    @Override
    public HoaDonChiTiet add(HoaDonChiTiet hoaDonChiTiet) {
        return hoaDonChiTietRepository.add(hoaDonChiTiet);
    }

    @Override
    public HoaDonChiTiet update(HoaDonChiTiet hoaDonChiTiet) {
        return hoaDonChiTietRepository.update(hoaDonChiTiet);
    }

    @Override
    public HoaDonChiTiet delete(HoaDonChiTiet hoaDonChiTiet) {
        return hoaDonChiTietRepository.delete(hoaDonChiTiet);
    }

    @Override
    public List<HoaDonChiTietKhuyenMai> getListHoaDonApDungKhuyenMai(long ngayBatDau, long ngayketThuc) {
        return hoaDonChiTietRepository.getListHoaDonApDungKhuyenMai(ngayBatDau, ngayketThuc);
    }

    @Override
    public boolean saveAllHoaDonChiTiet(Map<UUID, GioHangViewModel> list) {
        return hoaDonChiTietRepository.saveAllHoaDonChiTiet(list);
    }

    @Override
    public List<HoaDonChiTiet> getWord(UUID idHoaDon) {
        return hoaDonChiTietRepository.getWord(idHoaDon);
    }

    @Override
    public List<HoaDonChiTietSanPham> getListHDCTSP(String ma) {
        return hoaDonChiTietRepository.getListHoaDonSanPham(ma);
    }

    @Override
    public List<HoaDonChiTiet> getAllByMa(String ma) {
        return hoaDonChiTietRepository.getAllByMa(ma);
    }

   
    public List<GioHangViewModel> getGioHang(UUID idHoaDon) {
        return hoaDonChiTietRepository.getGioHang(idHoaDon);
    }



    public HoaDonChiTiet getById(UUID idHDCT) {
        return hoaDonChiTietRepository.getById(idHDCT);

    }


    @Override
    public HoaDonChiTiet getByIdHoaDon(UUID idHD) {
        return hoaDonChiTietRepository.getByIdHoaDon(idHD);
    }

    @Override
    public BigDecimal tongDoanhThu() {
        return hoaDonChiTietRepository.tongDoanhThu();
    }

    @Override
    public BigDecimal toDay(long toDay) {
          return hoaDonChiTietRepository.toDay(toDay);
    }

    @Override
    public BigDecimal theoKhoangNgay(long ngayBatDau, long ngayKetThuc) {
           return hoaDonChiTietRepository.theoKhoangNgay(ngayBatDau, ngayKetThuc);
    }

    @Override
    public long soHoaDontheoKhoangNgay(long ngayBatDau, long ngayKetThuc) {
           return hoaDonChiTietRepository.soHoaDontheoKhoangNgay(ngayBatDau, ngayKetThuc);
    }

    @Override
    public long soHoaDonTong() {
           return hoaDonChiTietRepository.soHoaDonTong();
    }

    @Override
    public long soHoaDontheoNgay(long toDay) {
           return hoaDonChiTietRepository.soHoaDontheoNgay(toDay);
    }
}
