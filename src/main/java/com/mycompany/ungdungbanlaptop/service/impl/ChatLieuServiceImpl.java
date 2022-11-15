/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service.impl;

import com.mycompany.ungdungbanlaptop.entity.ChatLieu;
import com.mycompany.ungdungbanlaptop.repository.ChatLieuRepository;
import com.mycompany.ungdungbanlaptop.service.ChatLieuService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hoàng Ngô
 */
public class ChatLieuServiceImpl implements ChatLieuService {

    private ChatLieuRepository chatLieuRepo = new ChatLieuRepository();

    @Override
    public List<ChatLieu> getAll() {
        return chatLieuRepo.getAll();
    }

    @Override
    public Boolean addNew(ChatLieu chatLieu) {
        if (chatLieu == null) {
            return false;
        }
        return true;
    }

}
