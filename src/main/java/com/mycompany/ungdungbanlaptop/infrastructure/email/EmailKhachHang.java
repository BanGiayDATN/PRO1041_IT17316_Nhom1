/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.infrastructure.email;

import java.io.File;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;
import javax.mail.internet.AddressException;

/**
 *
 * @author vinhnv
 */
public class EmailKhachHang {

    private final static String fromEmail = "t39022749@gmail.com";
    private final static String password = "enjkxtscsburacui";
    private final String subject = "POSt - Laptop";
    private String body = " Kính chào quý khách ";

    public  void guiEmailDinhKiem(String toEmail, String tenFile) throws AddressException, MessagingException {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(fromEmail));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
        message.setSubject(subject);
        // Phan 1 gom doan tin nhan
        BodyPart messageBodyPart1 = new MimeBodyPart();
        messageBodyPart1.setText(body);
        // phan 2 chua tap tin txt
        MimeBodyPart messageBodyPart2 = new MimeBodyPart();
        // Duong dan den file cua ban
        String home = System.getProperty("user.home");
        String filePath = new File(home + "/Downloads/"+ tenFile + ".doc") + " ";
        DataSource source1 = new FileDataSource(filePath);
        messageBodyPart2.setDataHandler(new DataHandler(source1));
        messageBodyPart2.setFileName(filePath);
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart1);
        multipart.addBodyPart(messageBodyPart2);
        message.setContent(multipart);
        Transport.send(message);
        System.out.println("Gui mail thanh cong");
    }

    public static void main(String[] args) throws MessagingException {
        String filePath = "D:\\DuAn1\\word\\HD986.doc";
        new EmailKhachHang().guiEmailDinhKiem("anhvinh12a888@gmail.com", filePath);
    }

   
}
