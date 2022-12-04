/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service;

import com.mycompany.ungdungbanlaptop.entity.HoaDonChiTiet;
import com.mycompany.ungdungbanlaptop.model.viewModel.HoaDonChiTietKhuyenMai;
import com.mycompany.ungdungbanlaptop.model.viewModel.GioHangViewModel;
import com.mycompany.ungdungbanlaptop.model.viewModel.HoaDonChiTietSanPham;
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
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> develop

    List<GioHangViewModel> getGioHang(UUID idHoaDon);

    HoaDonChiTiet getById(UUID idHDCT);
<<<<<<< HEAD
=======
    
     List<GioHangViewModel> getGioHang(UUID idHoaDon);
     
         HoaDonChiTiet getById(UUID idHDCT);
=======
>>>>>>> develop

    List<HoaDonChiTietKhuyenMai> getListHoaDonApDungKhuyenMai(long ngayBatDau, long ngạyetThuc);

    List<HoaDonChiTietSanPham> getListHDCTSP(String ma);

    List<HoaDonChiTiet> getAllByMa(String ma);

<<<<<<< HEAD
    List<GioHangViewModel> getGioHang(UUID idHoaDon);
>>>>>>> fd2951e2e0f49c1c610dbceed8407c70cd5441e2

    List<HoaDonChiTietKhuyenMai> getListHoaDonApDungKhuyenMai(long ngayBatDau, long ngayketThuc);

    HoaDonChiTiet getByIdHoaDon(UUID idHD);

=======
>>>>>>> develop
}
