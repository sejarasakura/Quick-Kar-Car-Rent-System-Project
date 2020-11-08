/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _module.client_side;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author xps
 */
public class SendMailPassword {
    
    public static void main(String[] args){
        try {
            SendMailPassword.sendMail("sejarasakura@gmail.com","Wahahah", "Hahahhaha");
        } catch (MessagingException ex) {
            Logger.getLogger(SendMailPassword.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void sendMail(String recepient, String subject, String html) throws MessagingException{
        Properties p = new Properties();
        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.put("mail.smtp.port", "587");
        String myAccount = "sejarasakura12@gmail.com";
        String password = "Aa73218324";
        Session session = Session.getInstance(p, new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccount, password);
            }            
        });
        Message message = prepareMessage_secure(session, myAccount, recepient, subject, html);
        Transport.send(message);
        System.out.print("Send successful");
    }

    private static Message prepareMessage_secure(Session session, String myAccount, 
            String recepient, String subject, String html) {
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccount));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject(subject);
            message.setContent(html, "text/html");
            return message;
        } catch (AddressException ex) {
            Logger.getLogger(SendMailPassword.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(SendMailPassword.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(SendMailPassword.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
