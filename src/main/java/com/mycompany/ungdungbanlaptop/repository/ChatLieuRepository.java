/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository;

import com.mycompany.ungdungbanlaptop.entity.ChatLieu;
import com.mycompany.ungdungbanlaptop.util.HibernateUtil;
import com.mycompany.ungdungbanlaptop.util.ConverDate;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class ChatLieuRepository {

    private Session session = HibernateUtil.getFACTORY().openSession();

    public List<ChatLieu> getAll() {

        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            Query query = session.createQuery("FROM ChatLieu");
            List<ChatLieu> list = query.getResultList();
            return list;
        } catch (Exception e) {
        }
        return null;
    }

//    public ChatLieu addNew(ChatLieu chatLieu) {
//        Transaction transaction = null;
//        try {
//            transaction = session.beginTransaction();
//            session.save(chatLieu);
//            transaction.commit();
//        } catch (Exception e) {
//            e.printStackTrace(System.out);
//        }
//        return chatLieu;
//    }
    public boolean addNew(ChatLieu chatLieu) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            transaction = session.beginTransaction();
            session.save(chatLieu);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public boolean update(ChatLieu chatLieu) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            transaction = session.beginTransaction();
            session.update(chatLieu);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public ChatLieu getOne(String ma) {
        
        ChatLieu chatLieu = new ChatLieu();
        try {
            String query = "SELECT chatLieu "
                    + "FROM ChatLieu chatLieu "
                    + "WHERE chatLieu.ma = :ma ";
            Query<ChatLieu> hth = session.createQuery(query);
            hth.setParameter("ma", ma);
            chatLieu = hth.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return chatLieu;
    }
    public ChatLieu getByTen(String ten){
        ChatLieu chatLieu = new ChatLieu();
        try {
            String query = "SELECT chatLieu "
                    + "FROM ChatLieu chatLieu "
                    + "WHERE chatLieu.ten = :ten ";
            Query<ChatLieu> hth = session.createQuery(query);
            hth.setParameter("ten", ten);
            chatLieu = hth.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return chatLieu;
    }

}
