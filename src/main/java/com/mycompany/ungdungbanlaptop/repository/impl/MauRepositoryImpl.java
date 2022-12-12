/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository.impl;

import com.mycompany.ungdungbanlaptop.entity.Mau;
import com.mycompany.ungdungbanlaptop.repository.MauRepository;
import com.mycompany.ungdungbanlaptop.util.HibernateUtil;
import java.util.List;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class MauRepositoryImpl implements MauRepository {

    private Session session = HibernateUtil.getFACTORY().openSession();

    @Override
    public List<Mau> getAll() {

        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            Query query = session.createQuery("FROM Mau");
            List<Mau> list = query.getResultList();
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public boolean addNew(Mau mau) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            transaction = session.beginTransaction();
            session.save(mau);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    @Override
    public boolean update(Mau mau) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            transaction = session.beginTransaction();
            session.update(mau);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;

    }

    @Override
    public Mau getOne(String ma) {
        Transaction transaction = null;
        Mau mau = new Mau();
        try {
            String query = "SELECT mau "
                    + "FROM Mau mau "
                    + "WHERE mau.ma = :ma ";
            Query<Mau> hth = session.createQuery(query);
            hth.setParameter("ma", ma);
            mau = hth.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return mau;
    }

    @Override
    public Mau getByTen(String ten) {
        Transaction transaction = null;
        Mau mau = new Mau();
        try {
            String query = "SELECT mau "
                    + "FROM Mau mau "
                    + "WHERE mau.ten = :ten ";
            Query<Mau> hth = session.createQuery(query);
            hth.setParameter("ten", ten);
            mau = hth.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return mau;
    }
    
}
