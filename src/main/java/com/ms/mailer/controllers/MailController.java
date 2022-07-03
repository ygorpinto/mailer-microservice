package com.ms.mailer.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ms.mailer.dtos.MailDto;
import com.ms.mailer.models.Mail;
import com.ms.mailer.services.MailService;

@RestController
public class MailController {

  @Autowired
  MailService mailService;

  @PostMapping("/api/v1/send")
  public ResponseEntity<Mail> sendMail (@RequestBody @Valid MailDto mailDto) {
    
    Mail mail = new Mail();

    mail.copyFromDto(mailDto);

    mailService.send(mail);

    return new ResponseEntity<>(mail, HttpStatus.CREATED);
  }
  
}
