/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository;

import com.mycompany.ungdungbanlaptop.entity.CPU;
import com.mycompany.ungdungbanlaptop.model.viewModel.CPUViewModel;
import java.util.List;

/**
 *
 * @author vinhnv
 */
public interface CPURespository {

    List<CPUViewModel> getAll();

    CPU getOne(String ma);

    CPU getByTen(String ten);

    boolean add(CPU cpu);

    boolean update(CPU cpu);
}
