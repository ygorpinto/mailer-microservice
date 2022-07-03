package com.ms.mailer.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ms.mailer.dtos.MailDto;
import com.ms.mailer.enums.MailStatus;


@Entity
@Table(name = "MAIL")
public class Mail implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)

  private Long mailId;
  private String ownerRef;
  private String mailFrom;
  private String mailTo;
  private String subject;
  @Column(columnDefinition = "TEXT")
  private String text;
  private LocalDateTime sendDateMail;
  private MailStatus mailStatus;

  public void copyFromDto (MailDto mailDto) {
    this.ownerRef = mailDto.getOwnerRef();
    this.mailFrom = mailDto.getMailFrom();
    this.mailTo = mailDto.getMailTo();
    this.subject = mailDto.getSubject();
    this.text = mailDto.getText();
  }

  public String getMailFrom() {
    return mailFrom;
  }

  public Long getMailId() {
    return mailId;
  }

  public String getMailTo() {
    return mailTo;
  }

  public String getOwnerRef() {
    return ownerRef;
  }

  public MailStatus getMailStatus() {
    return mailStatus;
  }

  public String getText() {
    return text;
  }

  public String getSubject() {
    return subject;
  }

  public LocalDateTime getSendDateMail() {
    return sendDateMail;
  }

  public void setMailStatus(MailStatus mailStatus) {
    this.mailStatus = mailStatus;
  }

  public void setSendDateMail(LocalDateTime sendDateMail) {
    this.sendDateMail = sendDateMail;
  }

}
