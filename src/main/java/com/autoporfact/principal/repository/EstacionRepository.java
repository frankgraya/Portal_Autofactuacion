package com.autoporfact.principal.repository;

import com.autoporfact.principal.model.Estacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstacionRepository extends JpaRepository<Estacion, Long> {
    Estacion findEstacionByNoEstacionAndFolioAndFechaAndWebId(long NoEstacion, String Folio, String Fecha, String WebId);
    Estacion findEstacionByNoEstacionAndFolio(long NoEstacion, String Folio);
}