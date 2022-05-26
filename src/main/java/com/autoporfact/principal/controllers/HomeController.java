package com.autoporfact.principal.controllers;

import com.autoporfact.principal.model.Mail;
import com.autoporfact.principal.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public void sendMail(@RequestParam("email") String email, RedirectAttributes redirectAttributes) {
        Mail mail = new Mail();
        mail.setMailFrom("mail.tmp.dev@gmail.com");
        mail.setMailTo(email);
        mail.setMailSubject("Spring Boot - Email Example TEST");
        mail.setMailContent("Learn How to send Email using Spring Boot!!!\n\nThanks\nwww.technicalkeeda.com");
        mailService.sendEmail(mail);
    }
}
