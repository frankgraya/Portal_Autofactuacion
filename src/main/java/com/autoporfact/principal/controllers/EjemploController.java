package com.autoporfact.principal.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.autoporfact.principal.views.viewRouteHelper.EJEMPLO_LISTAR;

@Controller
@RequestMapping("/views/ejemplo")
public class EjemploController {


    @GetMapping("/")
    public String listarEjemplo() {
        return EJEMPLO_LISTAR;
    }
}
