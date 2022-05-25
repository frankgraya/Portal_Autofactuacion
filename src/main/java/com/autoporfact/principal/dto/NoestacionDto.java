package com.autoporfact.principal.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class NoestacionDto implements Serializable {

    private final Long id;
    private final Long num;
    private final String Valero;
    private final String Quinta;
    private final String Avenida;

}
