package com.autoporfact.principal.service;

import com.autoporfact.principal.model.Estacion;
import com.autoporfact.principal.repository.EstacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstacionServiceImpl implements EstacionService{
    @Autowired
    private EstacionRepository estacionRepository;
    @Override
    public Estacion findEscenario1(long NoEstacion, String Folio, String Fecha, String WebId) {
        return estacionRepository.findEstacionByNoEstacionAndFolioAndFechaAndWebId(NoEstacion, Folio, Fecha, WebId);
    }

    @Override
    public Estacion findEscenario2(long NoEstacion, String Folio) {
        return estacionRepository.findEstacionByNoEstacionAndFolio(NoEstacion, Folio);
    }

    @Override
    public void save(Estacion estacion) {
        estacionRepository.save(estacion);
    }
}
