/*
*
* Modified by xbowery on 9/2/2021
*
*/

package util;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Emailer {

    public static void sendEmail(String recipient, String femail, String fpass) {


        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.mail.yahoo.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", "smtp.mail.yahoo.com"); 

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            //Authenticating the password
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(femail, fpass);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(femail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject("Enter your subject here");
            message.setText("Enter your message here");

            Transport.send(message);


        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}