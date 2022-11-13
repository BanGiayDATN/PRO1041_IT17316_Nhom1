/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author vinhnv
 */
@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class KhachHang implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator",
        parameters = {
            @Parameter(
                name = "uuid_gen_strategy_class",
                value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
            )
        }
    )
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    private UUID idKhachHang;

    @Column(name = "ma", unique = true, length = 20)
    private String ma;

    @Column(name = "ho_ten", columnDefinition="nvarchar(30)")
    private String hoTen;

    @Column(name = "gioi_tinh", columnDefinition="nvarchar(10)")
    private String gioiTinh;

    @Column(name = "ngay_sinh")
    private long ngaySinh;

    @Column(name = "sdt", length = 30)
    private String sdt;

    @Column(name = "email", length = 30)
    private String email;

    @Column(name = "mat_khau", length = 30)
    private String password;

    @Column(name = "dia_chi", columnDefinition="nvarchar(500)")
    private String diaChi;

    @Column(name = "trang_thai")
    private int trangThai;
   
}
