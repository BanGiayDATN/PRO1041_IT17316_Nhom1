/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository;

import com.mycompany.ungdungbanlaptop.entity.CPU;
import com.mycompany.ungdungbanlaptop.util.ConverDate;
import com.mycompany.ungdungbanlaptop.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author HuynhPhung
 */
public class CPURespository {

    private Session session = HibernateUtil.getFACTORY().openSession();

     public List<CPU> getAll(){
        
        try (Session session = HibernateUtil.getFACTORY().openSession();){
            Query query = session.createQuery("FROM CPU");
            List<CPU> list = query.getResultList();
            return list;
        } catch (Exception e) {
        }
        return null;
    }
    public CPU addOrUpdateCPU(CPU cpu) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(cpu);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return cpu;
    }

    public static void main(String[] args) {
        CPU add = new CPU();
        add.setMa("CPU1");
        add.setTen("intel core i5");
        CPU cpu = new CPURespository().addOrUpdateCPU(add);
        System.out.println(cpu);
        
        //
//        List<CPU> list = new ArrayList<>();
//        for (CPU x : list) {
//            System.out.println(x);
//        }
    }
}
