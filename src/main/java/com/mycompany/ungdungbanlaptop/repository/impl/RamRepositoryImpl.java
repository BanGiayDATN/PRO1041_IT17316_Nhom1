/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository.impl;

import com.mycompany.ungdungbanlaptop.entity.HeDieuHanh;
import com.mycompany.ungdungbanlaptop.entity.Ram;
import com.mycompany.ungdungbanlaptop.repository.RamRepository;
import com.mycompany.ungdungbanlaptop.util.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 * @author thang
 */
public class RamRepositoryImpl implements RamRepository {

    @Override
    public List<Ram> getList() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM Ram");
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean insert(Ram ram) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(ram);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(Ram ram) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(ram);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Ram findByMa(String ma) {
        Ram ram = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query<Ram> query = session.createQuery("""
                    FROM Ram
                    WHERE ma LIKE :ma
                    """).setParameter("ma", ma);
            ram = query.uniqueResult();
        } catch (Exception e) {
        }
        return ram;
    }

    @Override
    public Ram getByTen(String ten) {

        Ram ram = new Ram();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String query = "SELECT ram "
                    + "FROM Ram ram "
                    + "WHERE ram.ten = :ten ";
            Query<Ram> hth = session.createQuery(query);
            hth.setParameter("ten", ten);
            ram = hth.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return ram;
    }
}
