/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository.impl;

import com.mycompany.ungdungbanlaptop.entity.SanPham;
import com.mycompany.ungdungbanlaptop.model.viewModel.Top10KhachMuaNhieuNhat;
import com.mycompany.ungdungbanlaptop.model.viewModel.Top10SanPhamBanChayViewModel;
import com.mycompany.ungdungbanlaptop.repository.ThongKeRepository;
import com.mycompany.ungdungbanlaptop.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Diệm DZ
 */
public class ThongKeRepositoryImpl implements ThongKeRepository {

    @Override
    public List<Top10SanPhamBanChayViewModel> top10SanPhamBanChay() {
        List<Top10SanPhamBanChayViewModel> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT  new com.mycompany.ungdungbanlaptop.model.viewModel.Top10SanPhamBanChayViewModel( sp.ten,SUM(hdct.soLuong),hdct.donGia)  FROM SanPham sp"
                    + " INNER JOIN HoaDonChiTiet hdct "
                    + " ON sp.idSanPham = hdct.sanPham.idSanPham"
                    + " GROUP BY sp.ten,hdct.donGia"
                    + " ORDER BY SUM(hdct.soLuong) DESC";
            Query<Top10SanPhamBanChayViewModel> query = session.createQuery(hql);
            list = query.setMaxResults(10).getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

  

    @Override
    public List<Top10KhachMuaNhieuNhat> Top10KhachMuaNhieuNhat() {
        List<Top10KhachMuaNhieuNhat> list = new ArrayList<>();
         try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT new com.mycompany.ungdungbanlaptop.model.viewModel.Top10KhachMuaNhieuNhat( kh.hoTen,count(hd.ma) ) FROM KhachHang kh "
                    + " inner join HoaDon hd"
                    + " ON kh.idKhachHang = hd.khachHang.idKhachHang"
                    + " GROUP BY kh.hoTen"
                    + " ORDER BY count(hd.ma) DESC";
            Query<Top10KhachMuaNhieuNhat> query = session.createQuery(hql);
             list = query.setMaxResults(10).getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
      public static void main(String[] args) {
        System.out.println(new ThongKeRepositoryImpl().Top10KhachMuaNhieuNhat());
    }
}
