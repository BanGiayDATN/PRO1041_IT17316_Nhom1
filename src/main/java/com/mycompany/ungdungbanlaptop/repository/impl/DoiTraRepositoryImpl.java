/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository.impl;

import com.mycompany.ungdungbanlaptop.entity.DoiTRa;
import com.mycompany.ungdungbanlaptop.repository.DoiTraRepository;
import com.mycompany.ungdungbanlaptop.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


/**
 *
 * @author Diệm DZ
 */
public class DoiTraRepositoryImpl implements DoiTraRepository{

    @Override
    public List<DoiTRa> gelAll() {
          try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM DoiTra ");
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public DoiTRa add(DoiTRa doiTRa) {
         try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(doiTRa);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doiTRa;
    }
    
    
   
}
