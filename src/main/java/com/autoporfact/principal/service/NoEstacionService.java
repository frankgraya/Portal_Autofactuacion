package com.autoporfact.principal.service;


import com.autoporfact.principal.model.Noestacion;

import java.util.List;

public interface NoEstacionService {

    public Noestacion saveNoestacion(Noestacion noestacion);
    public void delete(long id);
    public Noestacion findById(long id);
    public List<Noestacion> findAll();
}
