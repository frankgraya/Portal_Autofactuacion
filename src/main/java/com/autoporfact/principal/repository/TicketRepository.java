package com.autoporfact.principal.repository;

import com.autoporfact.principal.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}