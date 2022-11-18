/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository;

import com.mycompany.ungdungbanlaptop.entity.GPM;
import java.util.List;

/**
 *
 * @author vinhnv
 */
public interface GPMRepository {

    List<GPM> getAll();

    boolean addNew(GPM gpm);

    boolean update(GPM gpm);

    GPM getOne(String ma);

    GPM getByTen(String ten);
}
