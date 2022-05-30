package com.autoporfact.principal.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.autoporfact.principal.views.viewRouteHelper.HOME;

@Slf4j
@Controller
@RequestMapping("/ticket")
public class TicketController {
    @GetMapping({"/"})
    public String index(Model model) {
        log.info("estas en el home controller");
        return HOME;
    }
}
