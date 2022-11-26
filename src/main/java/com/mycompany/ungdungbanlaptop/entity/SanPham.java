/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.entity;

import java.io.Serializable;
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
@Table(name="san_pham")
@AllArgsConstructor
@NoArgsConstructor
public class SanPham implements Serializable {

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
    private UUID idSanPham;

    @Column(name = "nam_bao_hanh")
    private int namBH;

    @Column(name = "ma", length = 50)
    private String ma;
    
    @Column(name = "ten_san_pham",columnDefinition = "nvarchar(Max)")
    private String ten;

    @Column(name = "trong_luong")
    private float trongLuong;

    @Column(name = "so_luong_ton")
    private int soLuongTon;

    @Column(name = "gia_nhap")
    private BigDecimal giaNhap;

    @Column(name = "gia_ban")
    private BigDecimal giaBan;

    @Column(name = "mo_ta", columnDefinition = "nvarchar(Max)")
    private String moTa;

    //Map cac bang
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_man_hinh")
    private ManHinh manHinh;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cpu")
    private CPU cpu;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_mau")
    private Mau mau;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_he_dieu_hanh")
    private HeDieuHanh heDieuHanh;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_ram")
    private Ram ram;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_chat_lieu")
    private ChatLieu chatLieu;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_hang")
    private Hang hang;


}
