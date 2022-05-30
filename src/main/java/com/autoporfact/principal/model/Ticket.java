package com.autoporfact.principal.model;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "Ticket")
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "NumeroDeEstacion", nullable = false)
    private String NumeroDeEstacion;

    @Column(name = "FolioTicket", nullable = false)
    private String FolioTicket;

    @Column(name = "UsoCFDI", nullable = false)
    private String UsoCFDI;

    @Column(name = "RFC", nullable = false)
    private String RFC;

    @Column(name = "RazonSocial", nullable = false)
    private String RazonSocial;

    @Column(name = "FormaDePago", nullable = false)
    private String FormaDePago;

    @Column(name = "Email", nullable = false)
    private String Email;
}
