/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.entity;

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
public class ManHinh {

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
    private UUID idManHinh;

    @Column(name = "ma")
    private String ma;
    
    @Column(name = "do_phan_giai",columnDefinition = "nvarchar(Max)")
    private String doPhanGiaMan;
    
    @Column(name = "kich_thuoc",columnDefinition = "nvarchar(Max)")
    private String kichThuoc;
    
    @Column(name = "loai_cam_ung",columnDefinition = "nvarchar(50)")
    private String loaiCamUng;
    
    @Column(name = "tan_so",columnDefinition = "nvarchar(100)")
    private String tanSo;

    
    @Column(name = "cong_nghe_man_hinh",columnDefinition = "nvarchar(100)")
    private String congNgheMH;

    public ManHinh(UUID idManHinh) {
        this.idManHinh = idManHinh;
    }
}
