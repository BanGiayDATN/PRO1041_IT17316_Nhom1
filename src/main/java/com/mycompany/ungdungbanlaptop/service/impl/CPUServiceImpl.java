/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service.impl;

import com.mycompany.ungdungbanlaptop.entity.CPU;
import com.mycompany.ungdungbanlaptop.entity.NhanVien;
import com.mycompany.ungdungbanlaptop.repository.CPURespository;
import com.mycompany.ungdungbanlaptop.repository.NhanVienRepository;
import com.mycompany.ungdungbanlaptop.service.CPUService;
import java.util.List;

/**
 *
 * @author HuynhPhung
 */
public class CPUServiceImpl implements CPUService {

    private CPURespository cpuRespository = new CPURespository();

    @Override
    public String add(CPU cpu) {
        
        if(cpu.getMa().isEmpty() || cpu.getTen().isEmpty()){
            return "Không được để trống thông tin";
        }
        if (cpu == null) {
            return " Add thất bại";
        }
        return "Add thành công ";
    }

    @Override
    public List<CPU> getALl() {
        return cpuRespository.getAll();
    }

  

    @Override
    public String update(CPU cpu) {
        if(cpu==null){
            return "update thất bại";
        }
        return "update thành công";
    }

};
