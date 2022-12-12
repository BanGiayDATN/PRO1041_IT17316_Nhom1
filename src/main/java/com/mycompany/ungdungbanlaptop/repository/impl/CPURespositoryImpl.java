/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository.impl;

import com.mycompany.ungdungbanlaptop.entity.CPU;
import com.mycompany.ungdungbanlaptop.model.viewModel.CPUViewModel;
import com.mycompany.ungdungbanlaptop.repository.CPURespository;
import com.mycompany.ungdungbanlaptop.util.HibernateUtil;
import java.util.List;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author HuynhPhung
 */
public class CPURespositoryImpl implements CPURespository {

    private Session session = HibernateUtil.getFACTORY().openSession();

    @Override
    public List<CPUViewModel> getAll() {
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            Query query = session.createQuery(" SELECT new com.mycompany.ungdungbanlaptop.model.viewModel.CPUViewModel"
                    + "(cpu.idCPU,cpu.ma ,cpu.ten ) FROM CPU cpu");
            List<CPUViewModel> list = query.getResultList();
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public CPU getOne(String ma) {
        Transaction transaction = null;
        CPU cpu = new CPU();
        try {
            String query = "SELECT cpu "
                    + "FROM CPU cpu "
                    + "WHERE cpu.ma = :ma ";
            Query<CPU> hth = session.createQuery(query);
            hth.setParameter("ma", ma);
            cpu = hth.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return cpu;
    }

    @Override
    public CPU getByTen(String ten) {
        CPU cpu = new CPU();
        try {
            String query = "SELECT cpu "
                    + "FROM CPU cpu "
                    + "WHERE cpu.ten = :ten ";
            Query<CPU> hth = session.createQuery(query);
            hth.setParameter("ten", ten);
            cpu = hth.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return cpu;
    }

    @Override
    public boolean add(CPU cpu) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            transaction = session.beginTransaction();
            session.save(cpu);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    @Override
    public boolean update(CPU cpu) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            transaction = session.beginTransaction();
            session.update(cpu);

            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public static void main(String[] args) {
//        CPU add = new CPU();
//        add.setMa("CPU2");
//        add.setTen("intel core i9");
//        CPU cpu = new CPURespositoryImpl().add(add);
//        System.out.println(cpu);

        //
//        List<CPU> list = new ArrayList<>();
//        for (CPU x : list) {
//            System.out.println(x);
//        }
//
        CPU cpu = new CPURespositoryImpl().getOne("123");
        System.out.println(cpu);
        cpu.setMa("vinh");
//        CPU update = new CPURespositoryImpl().update(cpu);
        System.out.println(cpu);

    }
}
