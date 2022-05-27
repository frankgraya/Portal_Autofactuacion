package com.autoporfact.principal.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class EstacionDto implements Serializable {
    private final long NoEstacion;
    private final String Folio;
    private final String Fecha;
    private final String WebId;
    private final double SubTotal;
    private final double IVA;
    private final double Total;
}
