package com.autoporfact.principal.service;

import com.autoporfact.principal.model.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class MailServiceImpl implements MailService{
    @Autowired
    JavaMailSender mailSender;

    String content = "<b>Estimado Cliente:</b><br>" +
            "<br>" +
            "Usted esta recibiendo un comprobante fiscal digital (Factura Electrónica) de <b>AVALON INFORMATICA</b><br>" +
            "<br>" +
            "De acuerdo con la reglamentación del Servicio de Administración Tributaria (SAT) publicada en el Diario Oficial de la Federación (RMISC 2004) el 31 de mayo del 2004, la factura electrónica es 100% valida y legal.<br>" +
            "<br>" +
            "A partir de ahora la entrega del documento fiscal (FACTURA ELECTRONICA) será emitida y entregada por correo electrónico a nuestros socios de negocio.<br>" +
            "<br>" +
            "Cabe destacar que la factura electrónica se entregará en formato PDF y archivo XML, el cual podrá imprimir libremente e incluirla en su contabilidad (Articulo 29, Fracción IV de CFF), resguardar la impresión y archivo XML por un periodo de 5 años.<br>" +
            "<br>" +
            " <br>" +
            "<br>" +
            "<b>Importante: Contenido de la Factura Electrónica</b><br>" +
            "<br>" +
            "En el anexo 20 del Diario Oficial de la Federación, publicado el 1 de septiembre de 2004, en párrafo 2.22.8, se estipula que la impresión de la factura electrónica, que además de los datos fiscales y comerciales, deberá contener la cadena original, el certificado de sello digital, el sello digital y la leyenda: <b>\"Este documento es una impresión de un comprobante fiscal digital\"<b>.<br>" +
            "<br>" +
            " <br>" +
            "<br>" +
            " <br>" +
            "<br>" +
            "Saludos cordiales.<br>" +
            "<br>" +
            "AVALON INFORMATICA<br>" +
            "LAGO ALBERTO 375<br>" +
            "ANHUAC, I SECCION, 11320 MIGUEL HIDALGO CDMX";
    String subject = "Facturación Electrónica Avalon";

    public void sendEmail(Mail mail) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setFrom(new InternetAddress("dev.mail", "avaloninformatica.es"));
            mimeMessageHelper.setTo(mail.getMailTo());
            mimeMessageHelper.setText(content);

            mailSender.send(mimeMessageHelper.getMimeMessage());

        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void sendEmailHTML(Mail mail, List<FileSystemResource> attachments){
        try {

            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setSubject(subject);
            helper.setFrom(new InternetAddress("factura.electronica@icfdi.mx", "avaloninformatica.es"));
            helper.setTo(mail.getMailTo());

            boolean html = true;
            helper.setText(content, html);

            for (FileSystemResource attach: attachments) {
                helper.addAttachment( attach.getFilename(), attach);
            }

            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
