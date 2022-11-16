/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository;


import com.mycompany.ungdungbanlaptop.entity.KhachHang;
import com.mycompany.ungdungbanlaptop.util.ConverDate;
import com.mycompany.ungdungbanlaptop.util.HibernateUtil;
import com.mycompany.ungdungbanlaptop.viewmodel.LichSuMuaHangViewModel;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Diệm DZ
 */
public class KhachHangRepository {
    
    public List<KhachHang> getAll(){
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("FROM KhachHang");
            List<KhachHang> list = query.getResultList();
            
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public KhachHang add(KhachHang khachHang){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.save(khachHang);
            transaction.commit();
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return khachHang;
    }
    public KhachHang update(KhachHang khachHang){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.update(khachHang);
            transaction.commit();
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return khachHang;
    }
    public KhachHang delete(KhachHang khachHang){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.delete(khachHang);
            transaction.commit();
           
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return khachHang;
    }
    public KhachHang getOne(String maKh){
        
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            String hql = "SELECT kh FROM KhachHang kh WHERE kh.ma like :ma";
            Query<KhachHang> query = session.createQuery(hql);
            query.setParameter("ma", "%"+ maKh+ "%");
            KhachHang kh = query.uniqueResult();
            return kh;
        } catch (Exception e) {
             e.printStackTrace(System.out);
        }
        return null;
    }
    public List<KhachHang> sreach(String tenKh){
        List<KhachHang> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            String hql = "SELECT kh FROM KhachHang kh WHERE kh.hoTen like :hoTen";
            Query<KhachHang> query = session.createQuery(hql);
            query.setParameter("hoTen", "%"+ tenKh+ "%");
            list= query.getResultList();
            return list;
        } catch (Exception e) {
             e.printStackTrace(System.out);
        }
        return null;
    }
     public List<LichSuMuaHangViewModel> lichSuMuaHang(UUID idKH){
                  Transaction transaction = null;
        List<LichSuMuaHangViewModel> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            transaction = session.beginTransaction();
            String HQL = "SELECT new com.mycompany.ungdungbanlaptop.viewmodel.LichSuMuaHangViewModel(hd.ma,hdct.soLuong,hdct.donGia,hd.ngayTao,hd.ngayThanhToan,hd.tinhTrang) "
                    + "FROM HoaDon hd "
                    + "join HoaDonChiTiet hdct"
                    + " ON hd.idHoaDon = hdct.hoaDon.idHoaDon"
                    + "join KhachHang kh"
                    + "on kh.idKhachHang = hd.khachHang.idKhachHang "
                    + "WHERE kh.idKhachHang like :idKhachHang";
            Query<LichSuMuaHangViewModel> query = session.createQuery(HQL);
            query.setParameter("idKhachHang", idKH);
            list = query.getResultList();

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        return list;
      }
    
    public static void main(String[] args) {
//          long ngay = new ConverDate().dateToLong("21/07/2002", "dd/MM/yyyy");
//        KhachHang kh  = new KhachHang("KH2", "Huỳnh", "Nam", ngay, "0354903402", "huynh2107@gmail.com", "huynh2002", "Nam Định", 1);
//        KhachHang add = new KhachHangRepository().add(kh);
//        System.out.println(add.toString());
//        
//         SanPham delete = new SanPhamRepository().delete(add);
//        System.out.println(delete);

//        System.out.println(new KhachHangRepository().getAll());
//        System.out.println(new SanPhamRepository().getOne("MH1"));
   System.out.println(new KhachHangRepository().lichSuMuaHang(UUID.fromString("c0a83801-847e-1400-8184-7e7403cd0000")));
    }
}
