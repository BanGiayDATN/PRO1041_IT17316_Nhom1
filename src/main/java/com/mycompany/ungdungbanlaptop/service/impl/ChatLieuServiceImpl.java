/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service.impl;

import com.mycompany.ungdungbanlaptop.entity.ChatLieu;
import com.mycompany.ungdungbanlaptop.repository.ChatLieuRepository;
import com.mycompany.ungdungbanlaptop.repository.impl.ChatLieuRepositoryImpl;
import com.mycompany.ungdungbanlaptop.service.ChatLieuService;
import java.util.List;

public class ChatLieuServiceImpl implements ChatLieuService {

    private ChatLieuRepository chatLieuRepo = new ChatLieuRepositoryImpl();

    @Override
    public List<ChatLieu> getAll() {
        return chatLieuRepo.getAll();
    }

    @Override
    public String addNew(ChatLieu chatLieu) {
        ChatLieu check = chatLieuRepo.getOne(chatLieu.getMa());
        if (check != null) {
            return "Mã chất liệu đã tồn tại";
        }
        if (chatLieu.getMa().isEmpty() || chatLieu.getTen().isEmpty()) {
            return "Không được để trống thông tin";
        }
        boolean add = chatLieuRepo.addNew(chatLieu);
        if (add) {
            return " Thêm thành công";
        }
        return "Thêm thất bại";
    }

    @Override
    public ChatLieu getOne(String ma) {
        return chatLieuRepo.getOne(ma);
    }

    @Override
    public String update(ChatLieu chatLieu) {
        String ma = chatLieu.getMa();
        if (chatLieu.getMa().isEmpty() || chatLieu.getTen().isEmpty()) {
            return "Không được để trống thông tin";
        }
        boolean update = chatLieuRepo.update(chatLieu);
        if (update) {
            return "Update thành công";
        }
        return "Update thất bại";
    }

    @Override
    public ChatLieu getByTen(String ten) {
        return chatLieuRepo.getByTen(ten);
    }

    

}
