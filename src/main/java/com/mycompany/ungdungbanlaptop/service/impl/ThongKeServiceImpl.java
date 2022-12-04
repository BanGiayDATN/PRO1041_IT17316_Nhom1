/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service.impl;

import com.mycompany.ungdungbanlaptop.model.viewModel.Top10SanPhamBanChayViewModel;
import com.mycompany.ungdungbanlaptop.repository.ThongKeRepository;
import com.mycompany.ungdungbanlaptop.repository.impl.ThongKeRepositoryImpl;
import com.mycompany.ungdungbanlaptop.service.ThongKeService;
import java.util.List;

/**
 *
 * @author Diệm DZ
 */
public class ThongKeServiceImpl implements ThongKeService{
    private ThongKeRepository thongKeRepository = new ThongKeRepositoryImpl();

    @Override
    public List<Top10SanPhamBanChayViewModel> top10SanPhamBanChay() {
        return thongKeRepository.top10SanPhamBanChay();
    }

    @Override
    public List<com.mycompany.ungdungbanlaptop.model.viewModel.Top10KhachMuaNhieuNhat> Top10KhachMuaNhieuNhat() {
        return thongKeRepository.Top10KhachMuaNhieuNhat();
    }
    
}
