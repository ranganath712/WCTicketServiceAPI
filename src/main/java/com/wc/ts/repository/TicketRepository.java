package com.wc.ts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wc.ts.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer>{

}
