/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository.impl;

import com.mycompany.ungdungbanlaptop.entity.ChatLieu;
import com.mycompany.ungdungbanlaptop.entity.DoiTRa;
import com.mycompany.ungdungbanlaptop.model.resquest.SeachDoiTraRequest;
import com.mycompany.ungdungbanlaptop.repository.DoiTraRepository;
import com.mycompany.ungdungbanlaptop.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Diệm DZ
 */
public class DoiTraRepositoryImpl implements DoiTraRepository{
   
    @Override
    public List<DoiTRa> getList(SeachDoiTraRequest request){
         try (Session session = HibernateUtil.getFACTORY().openSession();) {
            Query query = session.createQuery("""
                                              FROM DoiTRa dt
                                              WHERE (
                                                (:firtDay = 0L AND :lastDay = 0L)
                                              OR dt.ngayBatDau = :firtDay 
                                                OR (dt.ngayBatDau BETWEEN :firtDay AND :lastDay )
                                              )
                                              AND (:maNhanVien IS NULL
                                                   OR :maNhanVien LIKE ''
                                                   OR dt.nhanVien.ma LIKE CONCAT('%',:maNhanVien,'%'))
                                              AND (:maNhanVien IS NULL
                                                   OR :maNhanVien LIKE ''
                                                    OR dt.nhanVien.ma LIKE CONCAT('%',:maNhanVien,'%'))
                                              AND (:tenKhach IS NULL
                                                   OR :tenKhach LIKE ''
                                                    OR dt.khachHang.hoTen LIKE CONCAT('%',:tenKhach,'%'))
                                             
                                              """).setParameter("firtDay", request.getFirtDay())
                                                    .setParameter("lastDay", request.getLastDay())
                    .setParameter("maNhanVien", request.getMaNhanVien())
                    .setParameter("tenKhach", request.getTenKhach());
            List<DoiTRa> list = query.getResultList();
            return list;
        } catch (Exception e) {
             System.out.println(e);
        }
        return null;
    } 
}
