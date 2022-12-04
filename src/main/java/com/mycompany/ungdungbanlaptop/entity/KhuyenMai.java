/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.entity;

import com.mycompany.ungdungbanlaptop.infrastructure.constant.EnumLoaiKhuyenMai;
import java.math.BigDecimal;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author vinhnv
 */
@Entity
@Data
@Setter
@Getter
@Table(name="khuyen_mai")
@AllArgsConstructor
@NoArgsConstructor
public class KhuyenMai {

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
    private UUID idKhuyenMai;

    @Column(name = "ma")
    private String ma;
    
    @Column(name = "ten", columnDefinition = "nvarchar(Max)")
    private String  ten;

    @Column(name = "ngay_bat_dau")
    private long ngayBatDau;

    @Column(name = "ngay_ket_thuc")
    private long ngayKetThuc;

    @Column(name = "trang_thai",  columnDefinition = "int default 0")
    private int trangThai;

    @Column(name = "so_luong")
    private int soLuong;
    
    @Column(name = "hinh_thuc")
    private boolean hinhThuc;
    
    @Column(name = "phan_tram")
    private int phanTram;
    
    @Column(name = "gia_tien_giam")
    private BigDecimal giaTienGiam;
    
    @Column(name = "dieu_kien_giam_gia")
    private BigDecimal dieuKienGiamGia;
    
    @Column(name = "loai_khuyen_mai")
    private EnumLoaiKhuyenMai loaiKhuyenMai;
    
    @Column(name = "mo_ta", columnDefinition = "nvarchar(Max)")
    private String  moTa;

    public KhuyenMai(String ma) {
        this.ma = ma;
    }
    
    
}
