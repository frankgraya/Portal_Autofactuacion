package com.autoporfact.principal.service;

import com.autoporfact.principal.model.Estacion;

public interface EstacionService {
    Estacion findEscenario1(long NoEstacion, String Folio, String Fecha, String WebId);
    Estacion findEscenario2(long NoEstacion, String Folio);

    void save(Estacion estacion);
}
