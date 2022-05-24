package com.autoporfact.principal.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import static com.autoporfact.principal.views.viewRouteHelper.HOME;


@Slf4j
@Controller
public class HomeController {

    //    @Secured("ADMIN")
    @GetMapping({"/index", "/home", "/"})
    public String index(Model model) {
        log.info("estas en el home controller");
        return HOME;
    }
}
