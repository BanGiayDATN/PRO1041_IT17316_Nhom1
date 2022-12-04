/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service;

import com.mycompany.ungdungbanlaptop.model.viewModel.Top10KhachMuaNhieuNhat;
import com.mycompany.ungdungbanlaptop.model.viewModel.Top10SanPhamBanChayViewModel;
import java.util.List;

/**
 *
 * @author Diệm DZ
 */
public interface ThongKeService {
     List<Top10SanPhamBanChayViewModel> top10SanPhamBanChay();
       List<Top10KhachMuaNhieuNhat>  Top10KhachMuaNhieuNhat();
}
