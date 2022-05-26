package com.autoporfact.principal.service;

import com.autoporfact.principal.model.Mail;
import org.springframework.core.io.FileSystemResource;

import java.util.List;

public interface MailService {
    void sendEmail(Mail mail);
    void sendEmailHTML(Mail mail, List<FileSystemResource> attachments);
}
