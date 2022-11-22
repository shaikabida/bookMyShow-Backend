package com.example.project.bookmyshowbackend.Repository;

import com.example.project.bookmyshowbackend.Models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
}
