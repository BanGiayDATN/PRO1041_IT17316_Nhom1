/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository;

import com.mycompany.ungdungbanlaptop.entity.HeDieuHanh;
import com.mycompany.ungdungbanlaptop.util.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 * @author thang
 */
public class HeDieuHanhRepository {

    public List<HeDieuHanh> getList() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM HeDieuHanh ");
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean insert(HeDieuHanh heDieuHanh) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(heDieuHanh);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean update(HeDieuHanh heDieuHanh) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(heDieuHanh);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public HeDieuHanh findByMa(String ma) {
        HeDieuHanh heDieuHanh = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query<HeDieuHanh> query = session.createQuery("""
                    FROM HeDieuHanh 
                    WHERE ma LIKE :ma
                    """).setParameter("ma", ma);
            heDieuHanh = query.uniqueResult();
        } catch (Exception e) {

        }
        return heDieuHanh;
    }
}
