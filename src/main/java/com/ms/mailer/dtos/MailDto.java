package com.ms.mailer.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class MailDto {
  
  @NotBlank
  private String ownerRef;
  
  @NotBlank
  @Email
  private String mailFrom;
  
  @NotBlank
  @Email
  private String mailTo;
  
  @NotBlank
  private String subject;
  
  @NotBlank
  private String text;

  public String getMailFrom() {
    return mailFrom;
  }

  public String getMailTo() {
    return mailTo;
  }

  public String getOwnerRef() {
    return ownerRef;
  }

  public String getSubject() {
    return subject;
  }

  public void setMailFrom(String mailFrom) {
    this.mailFrom = mailFrom;
  }

  public void setMailTo(String mailTo) {
    this.mailTo = mailTo;
  }

  public void setOwnerRef(String ownerRef) {
    this.ownerRef = ownerRef;
  }


  public void setSubject(String subject) {
    this.subject = subject;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }
}
