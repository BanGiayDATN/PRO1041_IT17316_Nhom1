/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.entity;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="hoa_don")
@AllArgsConstructor
@NoArgsConstructor
public class HoaDon implements Serializable {

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
    private UUID idHoaDon;

    @Column(name = "ma", unique = true, length = 20)
    private String ma;

    @Column(name = "ngay_tao")
    private long ngayTao;

    @Column(name = "ngay_thanh_toan")
    private long ngayThanhToan;

    @Column(name = "ngay_ship")
    private long ngayShip;

    @Column(name = "ngay_nhan")
    private long ngayNhan;

    @Column(name = "tinh_trang")
    private int tinhTrang;

    @Column(name = "ten_nguoi_nhan", columnDefinition = "nvarchar(Max)")
    private String tenNguoiNhan;

    @Column(name = "dia_chi", columnDefinition = "nvarchar(Max)")
    private String diaChhi;

    @Column(name = "Sdt", length = 30)
    private String sdt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_nhan_vien")
    private NhanVien nhanVien;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_khuyen_mai")
    private KhuyenMai khuyenMai;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_khach_hang")
    private KhachHang khachHang;
    
}
