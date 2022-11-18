/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository.impl;

import com.mycompany.ungdungbanlaptop.entity.GPM;
import com.mycompany.ungdungbanlaptop.repository.GPMRepository;
import com.mycompany.ungdungbanlaptop.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class GPMRepositoryImpl implements GPMRepository {

    private Session session = HibernateUtil.getFACTORY().openSession();

    @Override
    public List<GPM> getAll() {

        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            Query query = session.createQuery("FROM GPM");
            List<GPM> list = query.getResultList();
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public boolean addNew(GPM gpm) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            transaction = session.beginTransaction();
            session.save(gpm);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    @Override
    public boolean update(GPM gpm) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            transaction = session.beginTransaction();
            session.update(gpm);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;

    }

    @Override
    public GPM getOne(String ma) {
        Transaction transaction = null;
        GPM gpm = new GPM();
        try {
            String query = "SELECT gpm "
                    + "FROM GPM gpm "
                    + "WHERE gpm.ma = :ma ";
            Query<GPM> hth = session.createQuery(query);
            hth.setParameter("ma", ma);
            gpm = hth.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return gpm;
    }

    @Override
    public GPM getByTen(String ten) {
        Transaction transaction = null;
        GPM gpm = new GPM();
        try {
            String query = "SELECT gpm "
                    + "FROM GPM gpm "
                    + "WHERE gpm.ten = :ten ";
            Query<GPM> hth = session.createQuery(query);
            hth.setParameter("ten", ten);
            gpm = hth.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return gpm;
    }

}
