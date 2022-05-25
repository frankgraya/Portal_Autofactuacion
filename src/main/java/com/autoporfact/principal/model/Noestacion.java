package com.autoporfact.principal.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name = "Noestacion")
@NoArgsConstructor
public class Noestacion implements Serializable {



    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private final Long id = null;


    @Column(name = "num", nullable = false)
    private String num;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "direccion", nullable = false)
    private String direccion;




    //  6050 Valero       Nacozari
    //  6500 Valero       Quinta Avenida
    //  2584 Fosell       Ojo Caliente
    //  3245 Valero       Maestros
    //  4564 Valero       Servicios y Refinados AGS
    //  8546 Panamericana Aguascalientes
    //  1452 Valero       El Arco
    //  4566 Valero       Dayco
    //  4788 Teoloyucan
    //  3221 Huehuetoca
    //  4555 Servicio     Chiconautla


}
