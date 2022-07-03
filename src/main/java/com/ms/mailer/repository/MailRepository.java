package com.ms.mailer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.mailer.models.Mail;

public interface MailRepository extends JpaRepository<Mail, Long> {
  
}
