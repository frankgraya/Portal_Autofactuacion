package com.autoporfact.principal.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name = "Estacion")
@NoArgsConstructor
public class Estacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private final Long id = null;

    @Column(name = "NoEstacion", nullable = false)
    private long noEstacion;

    @Column(name = "Folio", nullable = false)
    private String folio;

    @Column(name = "Fecha", nullable = false)
    private String fecha;

    @Column(name = "WebId", nullable = false)
    private String webId;

    @Column(name = "SubTotal", nullable = false)
    private double subTotal;

    @Column(name = "IVA", nullable = false)
    private double iva;

    @Column(name = "Total", nullable = false)
    private double total;

}
