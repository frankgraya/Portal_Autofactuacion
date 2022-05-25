package com.autoporfact.principal.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
public class Noestacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private final Long id;


    @Column(name = "num", nullable = false)
    private final Long num;

    @Column(name = "Valero", nullable = false)
    private final String Valero;

    @Column(name = "Quinta", nullable = false)
    private final String Quinta;


}
