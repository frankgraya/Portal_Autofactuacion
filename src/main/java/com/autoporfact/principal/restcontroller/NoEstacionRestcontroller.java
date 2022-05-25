package com.autoporfact.principal.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class NoEstacionRestcontroller {

   //  http://localhost:4000/NoEstacion

    @GetMapping("/NoEstacion")
    public List<Noestacion> obtentenNoEstacion() {
        List<Noestacion> noEstacion = new ArrayList<>();
        noEstacion.add(new Noestacion(1, "6500", "Valero ", "Quinta Avenida"));
        noEstacion.add(new Noestacion(2, "2584", "Fosell ", "Valero Quinta Avenida"));
        noEstacion.add(new Noestacion(3, "3245 ", "Valero ", "Valero Maestros Avenida"));
        noEstacion.add(new Noestacion(2, "8546  ", "Valero ", "Servicios y Refinados AGS"));
        noEstacion.add(new Noestacion(3, "1452 ", "Panamericana  ", "Aguascalientes"));
        noEstacion.add(new Noestacion(2, "4566 ", "Valero ", ""));
        noEstacion.add(new Noestacion(3, "4788 ", "Teoloyucan ", ""));
        return Noestacion;
    }
}


//6500 Valero Quinta Avenida