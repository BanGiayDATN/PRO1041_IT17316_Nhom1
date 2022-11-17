/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service;

import com.mycompany.ungdungbanlaptop.entity.CPU;
import com.mycompany.ungdungbanlaptop.entity.NhanVien;
import com.mycompany.ungdungbanlaptop.model.viewModel.CPUViewModel;
import java.util.List;

/**
 *
 * @author HuynhPhung
 */
public interface CPUService {

    List<CPUViewModel> getALl();

    String add(CPU cpu);

    String update(CPU cpu);
    
    CPU getOne(String ma);
    
   CPU getByTen(String ten);
}
