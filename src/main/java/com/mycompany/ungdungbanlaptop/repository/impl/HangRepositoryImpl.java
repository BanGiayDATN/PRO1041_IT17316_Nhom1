/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository.impl;

import com.mycompany.ungdungbanlaptop.entity.Hang;
import com.mycompany.ungdungbanlaptop.repository.HangRepository;
import com.mycompany.ungdungbanlaptop.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author thang
 */
public class HangRepositoryImpl implements HangRepository {

    @Override
    public List<Hang> getList() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM Hang ");
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean insert(Hang hang) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(hang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(Hang hang) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(hang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Hang getByTen(String ten) {

        Hang hang = new Hang();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String query = "SELECT hang "
                    + "FROM Hang hang "
                    + "WHERE hang.ten = :ten ";
            Query<Hang> hth = session.createQuery(query);
            hth.setParameter("ten", ten);
            hang = hth.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return hang;
    }

    @Override
    public Hang getOne(String ma) {

        Hang hang = new Hang();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String query = "SELECT hang "
                    + "FROM Hang hang "
                    + "WHERE hang.ma = :ma ";
            Query<Hang> hth = session.createQuery(query);
            hth.setParameter("ma", ma);
            hang = hth.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return hang;
    }
}
