package com.ba.apti.comm;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class Emailer {

    final private static String USER_NAME = "banjara.aptitude"; 
    final private static String PASSWORD = "Reema.vh16"; 
    private static String RECIPIENT = "banjara.aptitude@gmail.com";

    public static void mailCandidate(String name, String id, String email) {
 	
        String from = USER_NAME;
        String pass = PASSWORD;
        String[] to = { email }; // list of recipient email addresses
        String subject = "Banjara Academy - Thank You!";
        String body = "Hi <b>" + name + "</b>," + 
        		" <br><br> Thank you for taking up the Banjara aptitude test. Your ID is " + id + "." +  
        		" Please use the same in any future communication with Banjara, in this regard." +  
        		"<br><br> Good Luck! <br> <b>Banjara Academy</b>";

        sendFromGMail(from, pass, to, subject, body);
    }
    
    public static void mail(String content, String id) {
        String from = USER_NAME;
        String pass = PASSWORD;
        String[] to = { RECIPIENT }; // list of recipient email addresses
        String subject = "Aptitude Test Result - " + id;
        String body = content;

        sendFromGMail(from, pass, to, subject, body);
    }

    private static void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setContent(body,"text/html");
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }
}
