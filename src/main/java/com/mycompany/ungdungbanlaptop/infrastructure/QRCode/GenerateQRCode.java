/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.infrastructure.QRCode;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.mycompany.ungdungbanlaptop.infrastructure.TaoChuoiNgauNhien;

/**
 *
 * @author vinhnv
 */
public class GenerateQRCode {

    public static void generateQRcode(String data, String path, String charset, Map map, int h, int w) throws WriterException, IOException {
        BitMatrix matrix = new MultiFormatWriter()
                .encode(new String(data.getBytes(charset), charset), BarcodeFormat.QR_CODE, w, h);
        MatrixToImageWriter.writeToFile(matrix, path.substring(path.lastIndexOf('.') + 1), new File(path));
    }

    public static void main(String args[]) throws WriterException, IOException, NotFoundException {
        //dữ liệu mà chúng tôi muốn lưu trữ trong mã QR 
        String str = "hhhhhh";
        //đường dẫn nơi chúng tôi muốn lấy Mã QR
        String path = "D:\\DuAn1\\PRO1041_IT17346_Nhom1\\target\\classes\\img\\9.png";
        //Mã hóa bộ ký tự được sử dụng 
        String charset = "UTF-8";
        Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
        //tạo mã QR với khả năng sửa lỗi ở mức độ thấp (L)  
        hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        //gọi phương thức do người dùng xác định để tạo mã QR 
        generateQRcode(str, path, charset, hashMap, 200, 200);//tăng giảm chiều cao, chiều rộng cho phù hợp   
        //in nếu mã QR được tạo   
        System.out.println("QR Code created successfully.");
    }

    public void CreateQRCode(String idHoaDon , String maQRHoaDonChiTiet) throws WriterException, IOException {
        String path = "D:\\DuAn1\\PRO1041_IT17346_Nhom1\\target\\classes\\img\\" + maQRHoaDonChiTiet + ".png";
        String charset = "UTF-8";
        Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
        hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        generateQRcode(idHoaDon, path, charset, hashMap, 200, 200);//tăng giảm chiều cao, chiều rộng cho phù hợp   
        //in nếu mã QR được tạo   
        System.out.println("QR Code created successfully.");
    }
}
