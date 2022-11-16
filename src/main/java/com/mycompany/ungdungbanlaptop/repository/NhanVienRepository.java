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

    private Session session = HibernateUtil.getFACTORY().openSession();
    
    public List<NhanVien> getAll() {
        List<NhanVien> list = new ArrayList<>();
        try {
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
        try {
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
        try {
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
        try {
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
        try {
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
        try {
            String query = "SELECT nv "
                    + "FROM NhanVien nv "
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
        try {
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

    public static void main(String[] args) {
        //String ma, String hoTen, String gioiTinh, long ngaySinh, String sdt, String email, String password,
        //String diaChi, int trangThai, ChucVu chucVu
        long ngay = new ConverDate().dateToLong("17/10/1999", "dd/MM/yyyy");
//        NhanVien nhanVien = new NhanVien("455", "Nguyen Van A", "Nam", ngay, "0963852741", "anhvinh12a888@gmail.com", "123",
//                "Ha Noi", 0, null);
//        NhanVien add = new NhanVienRepository().addNhanVien(nhanVien);
//        System.out.println(add.toString());

        NhanVien getOne = new NhanVienRepository().getNhanVienByEmailAndPass("anhvinh12a888@gmail.com", "25F9E794323B453885F5181F1B624D0B");
        System.out.println(getOne);


//        NhanVien delete = new NhanVienRepository().delete(add);
//        System.out.println(delete);
    }
}
