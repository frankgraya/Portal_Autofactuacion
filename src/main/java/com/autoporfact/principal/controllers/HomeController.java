package com.autoporfact.principal.controllers;

import com.autoporfact.principal.model.Estacion;
import com.autoporfact.principal.model.Mail;
import com.autoporfact.principal.service.EstacionService;
import com.autoporfact.principal.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.autoporfact.principal.views.viewRouteHelper.HOME;


@Slf4j
@Controller
public class HomeController {

    @Autowired
    MailService mailService;

    @Autowired
    EstacionService estacionService;
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

    @GetMapping({"/esc1"})
    public ResponseEntity<Estacion> esc1(@RequestParam("NoEstacion") long NoEstacion, @RequestParam("Folio") String Folio,
                                         @RequestParam("Fecha") String Fecha, @RequestParam("WebId") String WebId) throws ParseException {
        Estacion estacion = new Estacion();
        //Formato inicial.
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date d = formato.parse(Fecha);
        //Aplica formato requerido.
        formato.applyPattern("dd/MM/yyyy");
        Fecha = formato.format(d);

        if (Folio.equals("922111")&&Fecha.equals("18/05/2022")&&WebId.equals("3326")){
            estacion.setNoEstacion(6050);
            estacion.setFolio("922111");
            estacion.setFecha("18/05/2022");
            estacion.setSubTotal(302.73);
            estacion.setIva(47.2);
            estacion.setTotal(350);
            estacion.setWebId("3326");
            estacion.setFacturado(false);
        } else if (Folio.equals("1644432")&&Fecha.equals("15/05/2022")&&WebId.equals("CB33")) {
            estacion.setNoEstacion(6050);
            estacion.setFolio("164432");
            estacion.setFecha("15/05/2022");
            estacion.setSubTotal(302.73);
            estacion.setIva(47.27);
            estacion.setTotal(350);
            estacion.setWebId("CB33");
            estacion.setFacturado(false);
        }
        return new ResponseEntity<>(estacion, HttpStatus.OK);
    }

    @GetMapping({"/esc2"})
    public ResponseEntity<Estacion> esc2(@RequestParam("NoEstacion") long NoEstacion, @RequestParam("Folio") String Folio) {
        //return estacionService.findEscenario2(NoEstacion, Folio);
        Estacion estacion = new Estacion();
        switch (Folio) {
            case "468892":
                estacion.setNoEstacion(6500);
                estacion.setFolio("468892");
                estacion.setFecha("12/05/2022");
                estacion.setSubTotal(345.98);
                estacion.setIva(54.02);
                estacion.setTotal(400);
                estacion.setFacturado(false);
                break;
            case "482747":
                estacion.setNoEstacion(6050);
                estacion.setFolio("482747");
                estacion.setFecha("20/05/2022");
                estacion.setSubTotal(302.73);
                estacion.setIva(47.27);
                estacion.setTotal(350);
                estacion.setFacturado(false);
                break;
            case "33232":
                estacion.setFacturado(true);
                break;
        }
        return new ResponseEntity<>(estacion, HttpStatus.OK);
    }
}
