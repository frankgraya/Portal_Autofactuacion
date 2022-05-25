package com.autoporfact.principal.service;

import com.autoporfact.principal.model.Noestacion;
import com.autoporfact.principal.repository.NoEstacionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class NoEstacionServiceImpl implements NoEstacionService {


    @Autowired
    private NoEstacionRepository noEstacionRepository;

    @Override
    public Noestacion saveNoestacion(Noestacion noestacion) {
        log.info("saveNoestacion con exito ");
        return noEstacionRepository.save(noestacion);
    }

    @Override
    public void delete(long id) {
        log.info("delete con exito ");
        noEstacionRepository.deleteById(id);

    }

    @Override
    public Noestacion findById(long id) {
        log.info("findById exito ");

        Optional<Noestacion> optional = noEstacionRepository.findById(id);
        Noestacion noestacion = null;
        if (optional.isPresent()) {
            noestacion = optional.get();
        } else {
            throw new RuntimeException(" noestacion not found for id :: " + id);
        }
        return noestacion;
    }

    @Override
    public List<Noestacion> findAll() {
        log.info("findAll con exit ");
        return noEstacionRepository.findAll();
    }
}
