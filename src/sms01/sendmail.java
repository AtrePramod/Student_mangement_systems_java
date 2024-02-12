package sms01;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
public class sendmail
{
 
 public  void send(String body,String subject,String to)        
 {
//Get the session object
  Properties props = new Properties();
  props.put("mail.smtp.host", "smtp.gmail.com");
  props.put("mail.smtp.socketFactory.port", "465");
  props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
  props.put("mail.smtp.auth","true");
  props.put("mail.smtp.port","465");
   Session session = Session.getDefaultInstance(props,
   new javax.mail.Authenticator()
   	{
   protected PasswordAuthentication getPasswordAuthentication()
   {
   return new PasswordAuthentication("firstproject05@gmail.com","12345@abcde$12345");//change accordingly
   }
  });
//compose message
  try
  {
     
   MimeMessage message = new MimeMessage(session);
   message.setFrom(new InternetAddress("firstproject05@gmail.com"));//change accordingly   // mail from
   message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
   message.setSubject(subject);
   message.setText(body);

   //send message
   Transport.send(message);

   System.out.println("message sent successfully");
  }
  catch (MessagingException e)
  {
      throw new RuntimeException(e);
      
  }

 }
}