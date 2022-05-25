package com.autoporfact.principal.restcontroller;


import com.autoporfact.principal.model.Noestacion;
import com.autoporfact.principal.service.NoEstacionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class NoEstacionRest {


   // http://localhost:4000/api/estacion

    @Autowired
    private NoEstacionService noEstacionService;

    @GetMapping("/estacion")
    public List<Noestacion> noestacion() {
        return noEstacionService.findAll();
    }
}
