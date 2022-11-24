/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service;

import com.mycompany.ungdungbanlaptop.model.viewModel.GioHangViewModel;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author thang
 */
public interface HoaDonChiTietServive {
    
    boolean saveAllHoaDonChiTiet(Map<UUID, GioHangViewModel> list);
}
