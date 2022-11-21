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

import com.mycompany.ungdungbanlaptop.infrastructure.constant.EnumHeDieuHanh;
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
@Table(name="he_dieu_hanh")
@AllArgsConstructor
@NoArgsConstructor
public class HeDieuHanh {

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
    private UUID idHeDieuHanh;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten_he_dieu_hanh",columnDefinition = "nvarchar(Max)")
    private String ten;

    @Column(name="he_dieu_hanh")
    private EnumHeDieuHanh heDieuHanh;

    public HeDieuHanh(UUID idHeDieuHanh) {
        this.idHeDieuHanh = idHeDieuHanh;
    }
    
    
}
