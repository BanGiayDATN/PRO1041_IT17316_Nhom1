/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository;

import com.mycompany.ungdungbanlaptop.entity.Hang;
import com.mycompany.ungdungbanlaptop.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author thang
 */
public class HangRepository {
    
    public List<Hang> getList(){
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("FROM Hang ");
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean insert(Hang hang){
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            Transaction transaction = session.beginTransaction();
            session.save(hang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean update(Hang hang){
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(hang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public Hang findByMa(String ma){
        Hang hang = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            Query<Hang> query = session.createQuery("""
                                              FROM Hang
                                              Where ma LIKE :ma
                                              """).setParameter("ma", ma);
            hang = query.uniqueResult();
        } catch (Exception e) {
        }
        return hang;
    }
            
}
