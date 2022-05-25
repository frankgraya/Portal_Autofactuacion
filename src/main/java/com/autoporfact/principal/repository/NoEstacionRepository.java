package com.autoporfact.principal.repository;

import com.autoporfact.principal.model.Noestacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoEstacionRepository  extends JpaRepository<Noestacion, Long> {
}
