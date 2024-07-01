package com.sujal.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SendMail
 */
@WebServlet("/SendMail")
public class SendMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			String email=request.getParameter("email");
			String subject=request.getParameter("subject");
			String content=request.getParameter("content");
			//send mail code
			String sEmail="Your Gmail ID";
			String sPassword="password";
			
			Properties props=new Properties();
            props.put("mail.smtp.host","smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port","465");
            props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth","true");
            props.put("mail.smtp.port","465");
            Session ses=Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication(){
                        return new PasswordAuthentication(sEmail,sPassword);
                    }
                }
            );
            Message message=new MimeMessage(ses);
            message.setFrom(new InternetAddress(sEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject(subject);
            message.setContent(content,"text/html" );
            Transport.send(message);
            
            HttpSession session=request.getSession();
            session.setAttribute("msg","Mail Sent Successfully!");
            response.sendRedirect("index.jsp");
			//end
		}catch (Exception e) {
			e.printStackTrace();
			out.print(e);
		}
	}

	}

