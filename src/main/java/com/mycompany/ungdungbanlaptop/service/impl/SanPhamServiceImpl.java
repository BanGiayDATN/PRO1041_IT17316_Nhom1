/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service.impl;

import com.mycompany.ungdungbanlaptop.entity.SanPham;
import com.mycompany.ungdungbanlaptop.infrastructure.TaoChuoiNgauNhien;
import com.mycompany.ungdungbanlaptop.infrastructure.importExcel.SanPhamImport;
import com.mycompany.ungdungbanlaptop.model.resquest.SanPhamRequest;
import com.mycompany.ungdungbanlaptop.model.resquest.SanPhamSearchRequest;
import com.mycompany.ungdungbanlaptop.model.viewModel.SanPhamBanHangViewModel;
import com.mycompany.ungdungbanlaptop.model.viewModel.SanPhamCustomRespone;
import com.mycompany.ungdungbanlaptop.repository.SanPhamRepository;
import com.mycompany.ungdungbanlaptop.repository.impl.SanPhamRepositoryImpl;
import com.mycompany.ungdungbanlaptop.service.SanPhamService;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

/**
 *
 * @author Diệm DZ
 */
public class SanPhamServiceImpl implements SanPhamService {

    private SanPhamRepository sanPhamRepository = new SanPhamRepositoryImpl();

    @Override
    public List<SanPham> getAll() {
        return sanPhamRepository.getAll();
    }

    @Override
    public Boolean add(SanPham sanPham) {
        if (sanPham.getMoTa().isEmpty()) {
            return false;
        }
        if (sanPham.getTen().isEmpty()) {
            return false;
        }
        if (sanPham.getHeDieuHanh() == null || sanPham.getChatLieu() == null || sanPham.getCpu() == null || sanPham.getHang() == null
                || sanPham.getManHinh() == null || sanPham.getMau() == null || sanPham.getRam() == null) {
            return false;
        }
        SanPham add = sanPhamRepository.add(sanPham);
        return true;
    }

    @Override
    public Boolean update(SanPham sanPham) {
        if (sanPham.getMoTa().isEmpty()) {
            return false;
        }
        if (sanPham.getTen().isEmpty()) {
            return false;
        }
        if (sanPham.getHeDieuHanh() == null || sanPham.getChatLieu() == null || sanPham.getCpu() == null || sanPham.getHang() == null
                || sanPham.getManHinh() == null || sanPham.getMau() == null || sanPham.getRam() == null) {
            return false;
        }
        SanPham add = sanPhamRepository.update(sanPham);
        return true;
    }

    @Override
    public String delete(SanPham sanPham) {
        SanPham delete = sanPhamRepository.delete(sanPham);
        if (delete != null) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }

    @Override
    public SanPham getOne(String ma) {
        return sanPhamRepository.getOne(ma);
    }

    @Override
    public List<SanPham> search(List<SanPham> list, String maSp) {
        return sanPhamRepository.search(maSp);
    }

    @Override
    public List<SanPham> searchByTen(List<SanPham> list, String tenSp) {
        return sanPhamRepository.searchByTen(tenSp);
    }

    @Override
    public List<SanPham> searchFill(SanPhamSearchRequest request) {
        return sanPhamRepository.searchFill(request);
    }

    @Override
    public List<SanPhamBanHangViewModel> getSanPhamBanHang() {
        return sanPhamRepository.getSanPhamBanHang();
    }

    @Override
    public List<SanPhamBanHangViewModel> getByGia(BigDecimal min, BigDecimal max) {
        return sanPhamRepository.getByGia(min, max);
    }

    @Override
    public List<SanPhamBanHangViewModel> searchByTenBanHang(List<SanPhamBanHangViewModel> list, String tenSp) {
        return sanPhamRepository.searchByTenBanHang(tenSp);

    }

    @Override
    public void updateSoLuongSanPham(Map<UUID, SanPham> list) {
        sanPhamRepository.updateSoLuongSanPham(list);
    }

    @Override
    public SanPham getById(UUID id) {
        return sanPhamRepository.getById(id);
    }

    @Override
    public SanPham updateTrangThai(SanPham sanPham, int trangThai) {
        sanPham.setTrangThai(trangThai);
        return sanPhamRepository.update(sanPham);
    }

    @Override
    public List<SanPham> getAllByTrangThai(int trangThai) {
        return sanPhamRepository.getAllByTrangThai(trangThai);
    }

    @Override
    public List<SanPhamCustomRespone> getListSanPham() {
        return sanPhamRepository.getListSanPham();
    }

    public List<SanPhamRequest> checkValidFile(List<SanPhamRequest> list) {
        Map<String, SanPham> mapSanPham = new HashMap<>();
        if (list == null) {
            return null;
        }
        for (SanPhamRequest sp : list) {
            SanPham sanPham = new SanPham();
            sanPham.setMa(sp.getMa());
            sanPham.setTen(sp.getTen());
//            sanPham.setGiaBan(BigDecimal.valueOf(Double.valueOf(sp.getGiaBan())));
//            sanPham.setNamBH(Integer.valueOf(sp.getNamBH()));
//            sanPham.setSoLuongTon(Integer.valueOf(sp.getSoLuongTon()));
//            sanPham.setTrongLuong(Float.parseFloat(sp.getTrongLuong()));
            mapSanPham.put(sanPham.getMa(), sanPham);
        }
//        sanPhamRepository.saveAllSanPham(mapSanPham);
        System.out.println(mapSanPham.values());
        return list;
    }

    public String SanPhamImport(File file) {
        List<SanPhamRequest> listSanPham = new ArrayList<>();
        String message = "";
        try {
            boolean check = true;
            SanPhamImport sanPhamImport = new SanPhamImport();
            List<SanPhamRequest> listSP = sanPhamImport.importData(file);
            Map<String, String> map = new HashMap<>();

            listSP.stream().forEach(sp -> {
                System.out.println("hello");
                if (sp.getMa().isEmpty() || sp.getTen().isEmpty() || sp.getGiaBan().isEmpty() || sp.getSoLuongTon().isEmpty() || sp.getNamBH().isEmpty()) {
//                    check = false;
//                    message = "Không được để trống";
                    return;
                }

                if (sp.getTen().trim().length() < 8) {
//                    check = false;
//                    message ="Tên sản phẩm lớn hơn 8";
                    return;
                }

                if (sp.getGiaBan().matches("\\d+")) {
//                    check = false;
//                    message =" ";
                    return;
                }

                if (sp.getSoLuongTon().matches("\\d+")) {
//                    check = false;
//                    message = " ";
                    return;
                }

                if (sp.getNamBH().matches("\\d+")) {
//                    check = false;
//                    message =" ";
                    return;
                }

                SanPhamRequest sanPhamRequest = new SanPhamRequest();
                sanPhamRequest.setMa(sp.getMa());
                sanPhamRequest.setTen(sp.getTen());
                sanPhamRequest.setGiaBan(sp.getGiaBan());
                sanPhamRequest.setTrongLuong(sp.getTrongLuong());
                sanPhamRequest.setSoLuongTon(sp.getSoLuongTon());
                sanPhamRequest.setNamBH(sp.getNamBH());
                listSanPham.add(sanPhamRequest);
            });
            if (check == true) {
                checkValidFile(listSanPham);
            }
        } catch (Exception e) {
            System.out.println(e);
            return "thất bại";
        }
        return "thành công";
    }

    public static void main(String[] args) {
        SanPhamServiceImpl sanPhamServiceImpl = new SanPhamServiceImpl();
        System.out.println(sanPhamServiceImpl.SanPhamImport(new File("C:\\Users\\thang\\Downloads\\12.xlsx")));
    }
}
