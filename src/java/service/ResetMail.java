/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author okanh
 */
public class ResetMail {
       public String getRandom() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }
    
    public void send(String toEmail, String subject, String verifyCode) {
        //provide sender's email ID
        String fromEmail = "happyprogrammingisp392@gmail.com";
        String fromPassword = "lqehkbdsoigragaw";

        //provide Mailtrap's host address
        String host = "smtp.gmail.com";
        //configure Mailtrap's SMTP server details
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        //create the Session object
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, fromPassword);
            }
        });

        try {
            //create a MimeMessage object
            Message message = new MimeMessage(session);

            //set From email field
            message.setFrom(new InternetAddress(fromEmail));

            //set To email field
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(toEmail));
                        //set email subject field
            message.setSubject(subject);

            //set the content of the email message
            message.setContent("<div\n"
                    + "      style=\"\n"
                    + "      width: 50vw;\n"
                    + "      margin: 0 auto;\n"
                    + "      padding: 20px 100px;\n"
                    + "      text-align: center; \n"
                    + "      border: 3px solid black; \n"
                    + "      border-radius: 10px\n"
                    + "      \"\n"
                    + "    >\n"
                    + "    <h1>Here your new password!</h1>\n"
                    + "      <small\n"
                    + "        >Comback and log in again</small>\n"
                    + "      <div\n"
                    + "        style=\"\n"
                    + "          background-color: rgb(171, 168, 168);\n"
                    + "          border-radius: 10px;\n"
                    + "          padding: 10px;\n"
                    + "          width: 30%;\n"
                    + "          margin: 20px auto;\n"
                    + "          letter-spacing: 10px;\">\n"
                    + "        <h1>"+verifyCode+"</h1>\n"
                    + "      </div>\n"
                    + "      <small\n"
                    + "        >If you didn't request a code, you can safely ignore this email.</small\n"
                    + "      >\n"
                    + "      <button\n"
                    + "        style=\"\n"
                    + "          padding: 10px;\n"
                    + "          border-radius: 10px;\n"
                    + "          display: block;\n"
                    + "          margin: 20px auto;\n"
                    + "        \"\n"
                    + "      >\n"
                    + "        <a style=\"text-decoration: none\" href=\"http://localhost:9999/HP/SignIn.jsp\">Reset</a>\n"
                    + "      </button>\n"
                    + "      <h5>Questions? <a href=\"\">We're here to help</a></h5>\n"
                    + "    </div>",
                     "text/html");

            //send the email message
            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
