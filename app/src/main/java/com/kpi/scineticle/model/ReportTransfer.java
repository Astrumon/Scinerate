package com.kpi.scineticle.model;


import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import java.io.OutputStreamWriter;
import java.util.Properties;

public class ReportTransfer extends javax.mail.Authenticator {
    private String report;
    private String mail;
    private Properties mProperties;
    private MimeMessage mMimeMessage;
    private static final String MAIL_FROM = "scienticle@gmail.com";
    private static final String PASSWORD = "Astrumon98!";
    private boolean status;

    private void send() throws MessagingException {
        setProperties();
        createMessage();
        Transport.send(mMimeMessage);
    }

    private void createMessage() throws MessagingException {
        Session mailSession = Session.getDefaultInstance(mProperties, this);
        mMimeMessage = new MimeMessage(mailSession);
        mMimeMessage.setFrom(new InternetAddress("scienticle@gmail.com"));
        mMimeMessage.setSubject("Scienticle");
        mMimeMessage.setText(report);
        mMimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(mail));
    }

    private void setProperties() {
        mProperties = new Properties();
        mProperties.setProperty("mail.transport.protocol", "smtp");
        mProperties.setProperty("mail.host", "smtp.gmail.com");
        mProperties.put("mail.smtp.auth", "true");
        mProperties.put("mail.smtp.port", "465");
        mProperties.put("mail.smtp.socketFactory.port", "465");
        mProperties.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        mProperties.put("mail.smtp.socketFactory.fallback", "false");
        mProperties.setProperty("mail.smtp.quitwait", "false");
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(MAIL_FROM, PASSWORD);
    }

    public boolean sendToEmail() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    send();
                    status = true;
                } catch (MessagingException e) {
                    e.printStackTrace();
                    status = false;

                }
            }
        });
        thread.start();
        try {
            thread.join(1);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

        return status;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public boolean writeToFile() {
            File path = Environment.getExternalStorageDirectory();
            path = new File(path.getAbsolutePath() + "/Download/data/scienticle");

            path.mkdirs();


            File file = new File(path, mail + "_report.txt");

            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
                bufferedWriter.write(report);
                return true;
            } catch (FileNotFoundException exception) {
                exception.printStackTrace();
                return false;
            } catch (IOException exception) {
                exception.printStackTrace();
                return false;
            }


    }

}
