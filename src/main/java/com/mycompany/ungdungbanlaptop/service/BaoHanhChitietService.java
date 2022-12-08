/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service;

import com.mycompany.ungdungbanlaptop.entity.BaoHanhChiTiet;
import com.mycompany.ungdungbanlaptop.model.viewModel.BaoHanhChiTietViewMoDel;
import java.util.List;

/**
 *
 * @author Diệm DZ
 */
public interface BaoHanhChitietService {

    String add(BaoHanhChiTiet baoHanhChiTiet);

    List<BaoHanhChiTietViewMoDel> getBHCT(String maBH);
}
