/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service;

import com.mycompany.ungdungbanlaptop.entity.HoaDonChiTiet;
import com.mycompany.ungdungbanlaptop.model.viewModel.HoaDonChiTietKhuyenMai;
import com.mycompany.ungdungbanlaptop.model.viewModel.GioHangViewModel;
import com.mycompany.ungdungbanlaptop.model.viewModel.HoaDonChiTietRespone;
import com.mycompany.ungdungbanlaptop.model.viewModel.HoaDonChiTietSanPham;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author Diệm DZ
 */
public interface HoaDonChiTietService {

    List<HoaDonChiTiet> getAll();

    HoaDonChiTiet add(HoaDonChiTiet hoaDonChiTiet);

    HoaDonChiTiet update(HoaDonChiTiet hoaDonChiTiet);

    HoaDonChiTiet delete(HoaDonChiTiet hoaDonChiTiet);

    boolean saveAllHoaDonChiTiet(Map<UUID, GioHangViewModel> list);

    List<HoaDonChiTiet> getWord(UUID idHoaDon);

    List<GioHangViewModel> getGioHang(UUID idHoaDon);

    HoaDonChiTiet getById(UUID idHDCT);
     
    List<HoaDonChiTietKhuyenMai> getListHoaDonApDungKhuyenMai(long ngayBatDau, long ngạyetThuc);

    List<HoaDonChiTietSanPham> getListHDCTSP(String ma);

    List<HoaDonChiTiet> getAllByMa(String ma);

    HoaDonChiTiet getByIdHoaDon(UUID idHD);
    
     BigDecimal tongDoanhThu();

    BigDecimal toDay(long toDay);

    BigDecimal theoKhoangNgay(long ngayBatDau, long ngayKetThuc);

    long soHoaDontheoKhoangNgay(long ngayBatDau, long ngayKetThuc);

    long soHoaDonTong();
    
    long soHoaDontheoNgay(long toDay);

    List<HoaDonChiTietRespone> findHoaDonChiTietByMaHoaDon(String ma);
    
}
