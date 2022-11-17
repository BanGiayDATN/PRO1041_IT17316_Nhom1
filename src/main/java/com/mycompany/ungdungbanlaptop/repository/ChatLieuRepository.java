/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository;

import com.mycompany.ungdungbanlaptop.entity.ChatLieu;
import java.util.List;

/**
 *
 * @author vinhnv
 */
public interface ChatLieuRepository {

    List<ChatLieu> getAll();

    boolean addNew(ChatLieu chatLieu);

    boolean update(ChatLieu chatLieu);

    ChatLieu getOne(String ma);

    ChatLieu getByTen(String ten);
}
