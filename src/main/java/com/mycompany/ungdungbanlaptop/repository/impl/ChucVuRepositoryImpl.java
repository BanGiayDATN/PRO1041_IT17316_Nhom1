/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository.impl;

import com.mycompany.ungdungbanlaptop.entity.ChucVu;
import com.mycompany.ungdungbanlaptop.repository.ChucVuRepository;
import com.mycompany.ungdungbanlaptop.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Diệm DZ
 */
public class ChucVuRepositoryImpl implements ChucVuRepository {

    private Session session = HibernateUtil.getFACTORY().openSession();

    @Override
    public ChucVu getOneByeName(String name) {
        Transaction transaction = null;
        ChucVu chucVu = new ChucVu();
        try {
            transaction = session.beginTransaction();
            String query = "SELECT cv FROM ChucVu cv WHERE cv.ten = :name";
            chucVu = (ChucVu) session.createQuery(query).setParameter("name", name ).uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            System.out.println(System.out);
        }
        return chucVu;
    }

    public static void main(String[] args) {
        ChucVu chucVu = new ChucVuRepositoryImpl().getOneByeName("Nhân viên");
        System.out.println(chucVu);
    }

}
