/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository;

import com.mycompany.ungdungbanlaptop.entity.NhanVien;
import com.mycompany.ungdungbanlaptop.util.ConverDate;
import com.mycompany.ungdungbanlaptop.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 * @author vinhnv
 */
public class NhanVienRepository {

    
    
    public List<NhanVien> getAll() {
        List<NhanVien> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession();){
            Query query = session.createQuery("FROM NhanVien");
            list = query.getResultList();
            return list;
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public NhanVien addNhanVien(NhanVien nhanVien) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            transaction = session.beginTransaction();
            session.save(nhanVien);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return nhanVien;
    }

    public NhanVien update(NhanVien nv) {
        Transaction transaction = null;
        try  (Session session = HibernateUtil.getFACTORY().openSession();){
            transaction = session.beginTransaction();
            session.update(nv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return nv;
    }

    public NhanVien delete(NhanVien nv) {
        Transaction transaction = null;
        try  (Session session = HibernateUtil.getFACTORY().openSession();){
            transaction = session.beginTransaction();
            session.delete(nv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return nv;
    }

    public NhanVien getNhanVienByEmail(String email) {
        NhanVien nv = new NhanVien();
        try  (Session session = HibernateUtil.getFACTORY().openSession();){
            String query = "SELECT nv "
                    + "FROM NhanVien nv "
                    + "WHERE nv.email = :email ";
            Query<NhanVien> hth = session.createQuery(query);
            hth.setParameter("email", email);
            nv = hth.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return nv;
    }

    public NhanVien getNhanVienByEmailAndPass(String email, String password) {
        NhanVien nv = new NhanVien();
        try  (Session session = HibernateUtil.getFACTORY().openSession();){
            String query = "SELECT nv "
                    + "FROM NhanVienhth.setParameter(\"email\", email); nv "
                    + "WHERE nv.email = :email AND nv.password = :password";
            Query<NhanVien> hth = session.createQuery(query);
            hth.setParameter("email", email);
            hth.setParameter("password", password);
            nv = hth.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return nv;
    }

    public NhanVien getNhanVienByEmailAndSDT(String email, String sdt) {
        NhanVien nv = new NhanVien();
        try  (Session session = HibernateUtil.getFACTORY().openSession();){
            String query = "SELECT nv "
                    + "FROM NhanVien nv "
                    + "WHERE nv.email = :email AND nv.sdt = :sdt ";
            Query<NhanVien> hth = session.createQuery(query);
            hth.setParameter("email", email);
            hth.setParameter("sdt", sdt);
            nv = hth.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return nv;
    }
    
    public List<NhanVien> search(String hoTen,String email,String soDienThoai) {
        List<NhanVien> list = new ArrayList<>();
        try  (Session session = HibernateUtil.getFACTORY().openSession();){
            String query = "SELECT nv "
                    + "FROM NhanVien nv "
                    + "WHERE nv.hoTen like :hoTen AND nv.email like :email AND nv.sdt like :sdt";
            Query<NhanVien> hth = session.createQuery(query);
            hth.setParameter("hoTen","%" +hoTen +"%");
            hth.setParameter("email","%" +email +"%");
            hth.setParameter("sdt","%" +soDienThoai +"%");
            list = hth.getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(new NhanVienRepository().search("Diệm", "", ""));
    }
}
