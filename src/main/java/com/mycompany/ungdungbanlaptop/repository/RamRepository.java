/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository;

import com.mycompany.ungdungbanlaptop.entity.Ram;
import com.mycompany.ungdungbanlaptop.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author thang
 */
public class RamRepository {
    
    public List<Ram> getList(){
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("FROM Ram");
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean insert(Ram ram){
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            Transaction transaction = session.beginTransaction();
            session.save(ram);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean update(Ram ram){
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(ram);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public Ram findByMa(String ma){
        Ram ram = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            Query<Ram> query = session.createQuery("""
                                                   FROM Ram
                                                   WHERE ma LIKE :ma
                                                   """).setParameter("ma", ma);
            ram = query.uniqueResult();
        } catch (Exception e) {
        }
        return ram;
    }
}
