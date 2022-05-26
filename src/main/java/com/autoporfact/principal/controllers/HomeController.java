package com.autoporfact.principal.controllers;

import com.autoporfact.principal.model.Mail;
import com.autoporfact.principal.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static com.autoporfact.principal.views.viewRouteHelper.HOME;


@Slf4j
@Controller
public class HomeController {

    @Autowired
    MailService mailService;
    //    @Secured("ADMIN")
    @GetMapping({"/index", "/home", "/"})
    public String index(Model model) {
        log.info("estas en el home controller");
        return HOME;
    }

    @GetMapping({"/mail"})
    public void sendMail(@RequestParam("email") String email, @RequestParam("estacion") String estacion, RedirectAttributes redirectAttributes) {
        Mail mail = new Mail();
        List<FileSystemResource> attachments = new ArrayList<>();
        mail.setMailTo(email);
        //ATTACHMENTS
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        FileSystemResource PDF;
        FileSystemResource XML;
        if (estacion.equals("6500 Valero Quinta Avenida")){
            PDF = new FileSystemResource(new File(s + "/src/main/resources/static/filesPAC/AIS021008E60GAGFK922111.pdf"));
            XML = new FileSystemResource(new File(s + "/src/main/resources/static/filesPAC/AIS021008E60GAGFK922111.xml"));
        } else {
            PDF = new FileSystemResource(new File(s + "/src/main/resources/static/filesPAC/AIS021008E60GCJCK493432.pdf"));
            XML = new FileSystemResource(new File(s + "/src/main/resources/static/filesPAC/AIS021008E60GCJCK493432.xml"));
        }
        attachments.add(PDF);
        attachments.add(XML);


        mail.setAttachments(attachments);
        mailService.sendEmailHTML(mail, attachments);
    }
}
