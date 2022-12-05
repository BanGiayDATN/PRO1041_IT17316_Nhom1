/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.model.viewModel;

import com.mycompany.ungdungbanlaptop.util.ConverDate;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author thang
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HoaDonRespone {

    private String ma;
    private long ngayTao;
    private String maNhanVien;
    private String tenNhanVien;
    private String tenKhachHang;
    private int tinhTrang;
    private long soLuong;
    private BigDecimal tong;

    public String getTrangThai() {
        if (tinhTrang == 1) {
            return "Hóa đơn chờ";
        } else {
            return "Đã thanh toán";
        }
    }

    public String getMocThoiGian(long dateHT) {
        Calendar c = new ConverDate().longToCalendar(ngayTao);
        c.add(Calendar.DATE, 30);
        String mocThoiGian = new ConverDate().convertDateToString(c.getTime(), "dd/MM/yyyy");
        long mocTG = new ConverDate().dateToLong(mocThoiGian, "dd/MM/yyyy");
        return dateHT > mocTG ? "hết hạn" : "còn hạn";
    }
}
