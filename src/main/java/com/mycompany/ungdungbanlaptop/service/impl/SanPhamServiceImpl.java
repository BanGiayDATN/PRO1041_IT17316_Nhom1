/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service.impl;

import com.mycompany.ungdungbanlaptop.entity.CPU;
import com.mycompany.ungdungbanlaptop.entity.Hang;
import com.mycompany.ungdungbanlaptop.entity.HeDieuHanh;
import com.mycompany.ungdungbanlaptop.entity.ManHinh;
import com.mycompany.ungdungbanlaptop.entity.Mau;
import com.mycompany.ungdungbanlaptop.entity.Ram;
import com.mycompany.ungdungbanlaptop.entity.SanPham;
import com.mycompany.ungdungbanlaptop.infrastructure.TaoChuoiNgauNhien;
import com.mycompany.ungdungbanlaptop.infrastructure.constant.EnumHeDieuHanh;
import com.mycompany.ungdungbanlaptop.infrastructure.constant.EnumLoaiRam;
import com.mycompany.ungdungbanlaptop.infrastructure.importExcel.MessageErrorImport;
import com.mycompany.ungdungbanlaptop.infrastructure.importExcel.SanPhamImport;
import com.mycompany.ungdungbanlaptop.model.resquest.ChiTietSanPhamImportResquest;
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
    public SanPham updateTrangThai(SanPham sanPham , int trangThai) {
        sanPham.setTrangThai(trangThai);
        return sanPhamRepository.update(sanPham);
    }

    @Override
    public List<SanPham> getAllByTrangThai(int trangThai) {
        return sanPhamRepository.getAllByTrangThai(trangThai);
    }

    public List<SanPhamCustomRespone> getListSanPham() {
        return sanPhamRepository.getListSanPham();
    }
    
    @Override
    public List<SanPhamRequest> checkValidFile(List<SanPhamRequest> list) {
        Map<String, ChiTietSanPhamImportResquest> mapSanPham = new HashMap<>();
        if (list == null) {
            return null;
        }
        for (SanPhamRequest sp : list) {
            ChiTietSanPhamImportResquest ctsp = new ChiTietSanPhamImportResquest();
            SanPham sanPham = new SanPham();
            sanPham.setMa(sp.getMa());
            sanPham.setTen(sp.getTen());
            sanPham.setGiaBan(BigDecimal.valueOf(Double.valueOf(sp.getGiaBan())));
            sanPham.setNamBH(Integer.valueOf(sp.getNamBH()));
            sanPham.setSoLuongTon(Integer.valueOf(sp.getSoLuongTon()));
            sanPham.setTrongLuong(Float.parseFloat(sp.getTrongLuong()));
            ctsp.setSanPham(sanPham);
            
            ManHinh manHinh = new ManHinh();
            manHinh.setMa(new TaoChuoiNgauNhien().getMkRanMa("MH",10));
            manHinh.setDoPhanGiaMan(sp.getDoPhanGiaMan());
            manHinh.setKichThuoc(sp.getKichThuoc());
            ctsp.setManHinh(manHinh);
            
            CPU cpu = new CPU();
            cpu.setMa(new TaoChuoiNgauNhien().getMkRanMa("CPU",10));
            cpu.setTen(sp.getTenCPU());
            ctsp.setCpu(cpu);
            
            Mau mau = new Mau();
            mau.setMa(new TaoChuoiNgauNhien().getMkRanMa("Mau",10));
            mau.setTen(sp.getTenMau());
            ctsp.setMauSac(mau);
            
            HeDieuHanh heDieuHanh = new HeDieuHanh();
            heDieuHanh.setMa(new TaoChuoiNgauNhien().getMkRanMa("HDH",10));
            heDieuHanh.setHeDieuHanh(getEumHeDieuHanh(sp.getHeDieuHanh()));
            heDieuHanh.setTen(sp.getTenHeDieuHanh());
            ctsp.setHeDieuHanh(heDieuHanh);
            
            Ram ram = new Ram();
            ram.setMa(new TaoChuoiNgauNhien().getMkRanMa("RAM",10));
            ram.setDungLuong(Integer.parseInt(sp.getDungLuong()));
            ram.setEnumLoaiRam(getLoaiRam(sp.getEnumLoaiRam()));
            ctsp.setRam(ram);
            
            Hang hang = new Hang();
            hang.setMa(new TaoChuoiNgauNhien().getMkRanMa("Hang",10));
            hang.setTen(sp.getTenHang());
            ctsp.setHang(hang);
            
            mapSanPham.put(sanPham.getMa(), ctsp);
        }
        sanPhamRepository.saveAllSanPham(mapSanPham);
        System.out.println(mapSanPham.values());
        return list;
    }

   public EnumHeDieuHanh getEumHeDieuHanh(String tenHeDieuHanh) {
        if (tenHeDieuHanh.equalsIgnoreCase("Windows")) {
            return EnumHeDieuHanh.WINDOWS;
        } else if (tenHeDieuHanh.equalsIgnoreCase("Macos")) {
            return EnumHeDieuHanh.MACOS;
        } else if (tenHeDieuHanh.equalsIgnoreCase("Linux")) {
            return EnumHeDieuHanh.LINUX;
        }
        return EnumHeDieuHanh.KHAC;
    }
    
    private EnumLoaiRam getLoaiRam(String loaiRam) {
       
        if (loaiRam.equals("SDRAM")) {
            return EnumLoaiRam.SDRAM;
        } else if (loaiRam.equals("DDR1")) {
            return EnumLoaiRam.DDR1;
        } else if (loaiRam.equals("DDR2")) {
            return EnumLoaiRam.DDR2;
        } else if (loaiRam.equals("DDR3")) {
            return EnumLoaiRam.DDR3;
        } else if (loaiRam.equals("DDR4")) {
            return EnumLoaiRam.DDR4;
        }
        return EnumLoaiRam.DDR5;
    }
    
    @Override
    public String SanPhamImport(File file) {
        List<SanPhamRequest> listSanPham = new ArrayList<>();

        try {
            MessageErrorImport messageErrorImport = new MessageErrorImport();
            SanPhamImport sanPhamImport = new SanPhamImport();
            List<SanPhamRequest> listSP = sanPhamImport.importData(file);
            Map<String, String> map = new HashMap<>();
            messageErrorImport.setCheck(true);
            
            listSP.stream().forEach(sp -> {
                if (sp.getMa().isEmpty() || sp.getTen().isEmpty() || sp.getGiaBan().isEmpty() || sp.getSoLuongTon().isEmpty() || sp.getNamBH().isEmpty()) {
                    messageErrorImport.setCheck(false);
                    messageErrorImport.setMessage("vui long khong de trong ");
                    return;
                }

                if (sp.getTen().trim().length() < 8) {
                    return;
                }

                if (!sp.getGiaBan().matches("\\d+")) {
                    return;
                }

                if (!sp.getSoLuongTon().matches("\\d+")) {
                    return;
                }

                if (!sp.getNamBH().matches("\\d+")) {

                    return;
                }

                SanPhamRequest sanPhamRequest = new SanPhamRequest();
                sanPhamRequest.setMa(sp.getMa());
                sanPhamRequest.setTen(sp.getTen());
                sanPhamRequest.setGiaBan(sp.getGiaBan());
                sanPhamRequest.setTrongLuong(sp.getTrongLuong());
                sanPhamRequest.setSoLuongTon(sp.getSoLuongTon());
                sanPhamRequest.setNamBH(sp.getNamBH());
                sanPhamRequest.setDoPhanGiaMan(sp.getDoPhanGiaMan());
                sanPhamRequest.setKichThuoc(sp.getKichThuoc());
                sanPhamRequest.setTenCPU(sp.getTenCPU());
                sanPhamRequest.setTenMau(sp.getTenMau());
                sanPhamRequest.setTenHeDieuHanh(sp.getTenHeDieuHanh());
                sanPhamRequest.setHeDieuHanh(sp.getHeDieuHanh());
                sanPhamRequest.setDungLuong(sp.getDungLuong());
                sanPhamRequest.setEnumLoaiRam(sp.getEnumLoaiRam());
                sanPhamRequest.setTenHang(sp.getTenHang());
                listSanPham.add(sanPhamRequest);
            });
            if (messageErrorImport.isCheck()) {
                checkValidFile(listSanPham);
            }
        } catch (Exception e) {
            System.out.println(e);
            return "thất bại";
        }
        return "thành công";
    }

}
