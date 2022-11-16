/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository;

import com.mycompany.ungdungbanlaptop.entity.BaoHanh;
import com.mycompany.ungdungbanlaptop.util.HibernateUtil;
import com.mycompany.ungdungbanlaptop.view.viewBaoHanh.BaoHanh1;
import java.util.List;
import jdk.net.Sockets;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Du
 */
public class BaoHanhRespository {
    private Session session = HibernateUtil.getFACTORY().openSession();
    
    public List<BaoHanh> getAll(){
         try (Session session = HibernateUtil.getFACTORY().openSession();) {
            Query query = session.createQuery("FROM BaoHanh");
            List<BaoHanh> list = query.getResultList();
            return list;
        } catch (Exception e) {
        }
        return null;
    }
    public BaoHanh getOne(String id) {
        Transaction transaction = null;
        BaoHanh bh = new BaoHanh();
        try {
            String query = "SELECT BaoHanh "
                    + "FROM BaoHanh id "
                    + "WHERE BaoHanh.id = :id ";
            Query<BaoHanh> hth = session.createQuery(query);
            hth.setParameter("id", id);
            bh = hth.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return bh;
    }
    
     public static void main(String[] args) {
        System.out.println(new BaoHanhRespository().getAll());
    }
} 
