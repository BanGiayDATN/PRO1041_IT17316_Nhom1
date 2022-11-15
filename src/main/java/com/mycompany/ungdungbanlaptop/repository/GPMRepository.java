/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository;

import com.mycompany.ungdungbanlaptop.entity.GPM;
import com.mycompany.ungdungbanlaptop.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class GPMRepository {
    
    private Session session = HibernateUtil.getFACTORY().openSession();
    
    public List<GPM> getAll() {
        
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            Query query = session.createQuery("FROM GPM");
            List<GPM> list = query.getResultList();
            return list;
        } catch (Exception e) {
        }
        return null;
    }
    
    public GPM addGPM(GPM gpm) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(gpm);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return gpm;
    }
    
    public static void main(String[] args) {
        GPM add = new GPM();
        add.setMa("GPM0001");
        add.setTen("Gigabyte N710D5-1GL");
        GPM gpm = new GPMRepository().addGPM(add);
        System.out.println(gpm);
        List<GPM> list = new ArrayList<>();
        for (GPM x : list) {
            System.out.println(x);
        }
    }
}
