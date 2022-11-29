/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.entity;

import com.mycompany.ungdungbanlaptop.infrastructure.constant.EnumHinhThucDoiTra;
import java.math.BigDecimal;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
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
@Table(name="doi_tra")
@ToString
public class DoiTRa {
    
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
    private UUID idDoiTra;

    @Column(name = "ngay_bat_dau")
    private long ngayBatDau;

    @Column(name = "ngay_ket_thuc")
    private long ngayKetThuc;
    
    @Column(name = "mo_ta",columnDefinition="nvarchar(Max)")
    private String moTa;
    
    @Column(name = "hinh_thuc",columnDefinition="nvarchar(Max)")
    private EnumHinhThucDoiTra hinhThucDoiTra;
    
    @Column(name = "tien_thu")
    private BigDecimal tienThu;
    
    @Column(name = "tien_tra")
    private BigDecimal tienTra;
    
    @Column(name = "ly_do",columnDefinition="nvarchar(Max)")
    private String liDo;
    
    @Column(name = "tinh_trang")
    private int tinhTrang;
    
    @Column(name = "trang_thai")
    private int trangThai;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_khach_hang")
    private KhachHang khachHang;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_hoa_don_chi_tiet")
    private HoaDonChiTiet hoaDonChiTiet;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_nhan_vien")
    private NhanVien nhanVien;
    
    
}
