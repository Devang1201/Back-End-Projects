package com.shashi.walletservice.service;
import com.shashi.walletservice.Util.EmailUtil;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Date;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import javax.mail.internet.AddressException;

public class EmailService {
     public static void sendEmail(String toEmail){
        final String fromEmail = "akshatshrivastav1234@gmail.com"; //requires valid gmail id
        final String password = "tanvi1201"; // correct password for gmail id
        //final String toEmail = "umangd98@gmail.com"; // can be any email id

        System.out.println("SSLEmail Start");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
        props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
        props.put("mail.smtp.port", "465"); //SMTP Port

        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };

        Session session = Session.getDefaultInstance(props, auth);
        System.out.println("Session created");
        EmailUtil.sendEmail(session, toEmail,"Mail from e_wallet", "Transaction");
    }
     
     public static void sendEmailWithAttachments( String toAddress,
             String subject, String message, String attachFiles)
     {
    	 final String userName = "akshatshrivastav1234@gmail.com"; //requires valid gmail id
         final String password = "tanvi1201"; // correct password for gmail id
         
    	 System.out.println("SSLEmail Start");
         Properties props = new Properties();
         props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
         props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
         props.put("mail.smtp.socketFactory.class",
                 "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
         props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
         props.put("mail.smtp.port", "465"); //SMTP Port

         Authenticator auth = new Authenticator() {
             //override the getPasswordAuthentication method
             protected PasswordAuthentication getPasswordAuthentication() {
                 return new PasswordAuthentication(userName, password);
             }
         };

         Session session = Session.getDefaultInstance(props, auth);
         System.out.println("Session created");
         try {
         // creates a new e-mail message
	       MimeMessage msg = new MimeMessage(session);
	
	       msg.setFrom(new InternetAddress(userName));
	       InternetAddress toAddresses =  new InternetAddress(toAddress) ;
	       msg.addRecipient(Message.RecipientType.TO, toAddresses);
	       msg.setSubject(subject);
	       msg.setSentDate(new Date());
	
	       // creates message part
	       MimeBodyPart messageBodyPart = new MimeBodyPart();
	       messageBodyPart.setText(message);
	
	       MimeBodyPart messageBodyPart1 = new MimeBodyPart();
	       DataSource source = new FileDataSource(attachFiles);
	       messageBodyPart1.setDataHandler(new DataHandler(source));
	       messageBodyPart1.attachFile(attachFiles);
	       
	       // creates multi-part
	       Multipart multipart = new MimeMultipart();
	       multipart.addBodyPart(messageBodyPart);
	       multipart.addBodyPart(messageBodyPart1);
	
	       msg.setContent(multipart);

	       Transport.send(msg);
	       System.out.println("Message sent");
         }
         catch(Exception e)
         {
        	 System.out.println("Problem sending email");
        	 e.printStackTrace();
         }
     }
//    public static void sendEmailWithAttachments( String toAddress,
//                                                String subject, String message, String attachFiles)
//            throws AddressException, MessagingException {
//    	String host = "smtp.gmail.com";
//    	String port = "465";
//    	final String userName = "akshatshrivastav1234@gmail.com";
//    	final String password = "tanvi1201";
//        // sets SMTP server properties
//        Properties properties = new Properties();
//        properties.put("mail.smtp.host", host);
//        properties.put("mail.smtp.port", port);
//        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.starttls.enable", "true");
//        properties.put("mail.user", userName);
//        properties.put("mail.password", password);
//
//        // creates a new session with an authenticator
//        Authenticator auth = new Authenticator() {
//            public PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(userName, password);
//            }
//        };
//        Session session = Session.getInstance(properties, auth);
//
//        // creates a new e-mail message
//        Message msg = new MimeMessage(session);
//
//        msg.setFrom(new InternetAddress(userName));
//        InternetAddress toAddresses =  new InternetAddress(toAddress) ;
//        msg.setRecipient(Message.RecipientType.TO, toAddresses);
//        msg.setSubject(subject);
//        msg.setSentDate(new Date());
//
//        // creates message part
//        MimeBodyPart messageBodyPart = new MimeBodyPart();
//        messageBodyPart.setContent(message, "text/html");
//
//        // creates multi-part
//        Multipart multipart = new MimeMultipart();
//        multipart.addBodyPart(messageBodyPart);
//
//        // adds attachments
//        String filePath = attachFiles;
//
//                MimeBodyPart attachPart = new MimeBodyPart();
//
//                try {
//                    attachPart.attachFile(filePath);
//                } catch (IOException ex) {
//                    ex.printStackTrace();
//                }
//
//                multipart.addBodyPart(attachPart);
//
//        // sets the multi-part as e-mail's content
//        msg.setContent(multipart);
//        // sends the e-mail
//        Transport.send(msg);
//    }
}
