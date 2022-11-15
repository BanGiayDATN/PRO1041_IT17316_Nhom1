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

    public ChatLieu addNew(ChatLieu chatLieu) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(chatLieu);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return chatLieu;
    }

    public static void main(String[] args) {
        ChatLieu add = new ChatLieu();
        add.setMa("M0001");
        add.setTen("Kim loại");
        ChatLieu chatLieu = new ChatLieuRepository().addNew(add);
        System.out.println(chatLieu);
        List<ChatLieu> list = new ArrayList<>();
        for (ChatLieu x : list) {
            System.out.println(x);
        }
    }
}
