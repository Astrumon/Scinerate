package com.kpi.scineticle.model;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.io.IOException;

import java.util.Properties;

public class ReportTransfer extends javax.mail.Authenticator{
    private String report;
    private String mail;


    public void sendToEmail() throws MessagingException, IOException {
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.host", "smtp.gmail.com");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.fallback", "false");
        properties.setProperty("mail.smtp.quitwait", "false");

        Session mailSession = Session.getDefaultInstance(properties, this);
        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress("scienticle@gmail.com"));
        message.setSubject("Scienticle");
        message.setText(report);
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(mail));


        Transport.send(message);
    }

    protected PasswordAuthentication getPasswordAuthentication() {
       return new PasswordAuthentication("scienticle@gmail.com", "Astrumon98!");
    }

    public boolean send() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sendToEmail();
                } catch (MessagingException e) {
                    e.printStackTrace();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

        return true;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
