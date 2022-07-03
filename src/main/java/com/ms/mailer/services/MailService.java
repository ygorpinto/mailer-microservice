package com.ms.mailer.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ms.mailer.enums.MailStatus;
import com.ms.mailer.models.Mail;
import com.ms.mailer.repository.MailRepository;

@Service
public class MailService {
  
  @Autowired
  MailRepository mailRepository;

  @Autowired
  private JavaMailSender mailSender;

  public Mail send (Mail mail) {
    mail.setSendDateMail(LocalDateTime.now());
    try {
      SimpleMailMessage message = new SimpleMailMessage();

      message.setFrom(mail.getMailFrom());
      message.setTo(mail.getMailTo());
      message.setSubject(mail.getSubject());
      message.setText(mail.getText());
      
      mailSender.send(message);

      mail.setMailStatus(MailStatus.SENT);

    } catch (MailException e) {
      mail.setMailStatus(MailStatus.ERROR); 
    } finally {
      return mailRepository.save(mail);
    }
  }
}
