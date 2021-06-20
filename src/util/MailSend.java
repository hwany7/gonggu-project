package util;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSend {
	
    public MailSend(String email, String codeMsg) {	
    	
    	//정보 입력
        Properties prop = System.getProperties();
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.port", "587");
        
        //보내는 객체 생성
        Authenticator auth = new MailAuth();  
        
        //세션 할당
        Session session = Session.getDefaultInstance(prop, auth);
        
        //메세지 생성
        MimeMessage msg = new MimeMessage(session);
        
        try {
        	
            msg.setSentDate(new Date());
            msg.setFrom(new InternetAddress("hwannymail", "GongGu"));
            
            //받는이 생성
            InternetAddress to = new InternetAddress(email);   
            
            //내용 셋팅
            msg.setRecipient(Message.RecipientType.TO, to); 
            msg.setSubject("[GongGu] 이메일 인증 코드", "UTF-8");            
            msg.setText(codeMsg + "를 입력해 주세요", "UTF-8"); 
            		 	      
            
            //메일 보내기
            Transport.send(msg);
            
        } catch(AddressException e) {            
        	e.printStackTrace();
        } catch(MessagingException e) {            
        	e.printStackTrace();
        } catch(UnsupportedEncodingException e) {
        	e.printStackTrace();
        }
    }
}
