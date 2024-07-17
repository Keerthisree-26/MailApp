package com.credmarg.data.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.credmarg.data.model.EmailRecord;
import com.credmarg.data.repository.EmailRecordRepository;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private EmailRecordRepository emailRecordRepository;

    @Value("${spring.mail.username}")
    private String fromEmailId;

    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmailId);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);

        EmailRecord record = new EmailRecord();
        record.setRecipient(to);
        record.setSubject(subject);
        record.setBody(body);
        record.setSentTime(LocalDateTime.now());
        emailRecordRepository.save(record);
    }

    public List<EmailRecord> getAllEmailRecords() {
        return emailRecordRepository.findAll();
    }
}
