package com.autoporfact.principal.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TicketDto implements Serializable {
    private final Long id;
    private final String NumeroDeEstacion;
    private final String FolioTicket;
    private final String UsoCFDI;
    private final String RFC;
    private final String RazonSocial;
    private final String FormaDePago;
    private final String Email;
}
