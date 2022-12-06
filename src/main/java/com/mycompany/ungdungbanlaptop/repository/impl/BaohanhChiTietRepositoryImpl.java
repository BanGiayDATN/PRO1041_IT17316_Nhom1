/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository.impl;

import com.mycompany.ungdungbanlaptop.entity.BaoHanhChiTiet;
import com.mycompany.ungdungbanlaptop.repository.BaoHanhChiTietRepository;
import com.mycompany.ungdungbanlaptop.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Diệm DZ
 */
public class BaohanhChiTietRepositoryImpl implements BaoHanhChiTietRepository{

    @Override
    public BaoHanhChiTiet add(BaoHanhChiTiet baoHanhChiTiet) {
         Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(baoHanhChiTiet);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return baoHanhChiTiet;
    }
    

    
}
