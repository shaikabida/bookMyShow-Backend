package com.example.project.bookmyshowbackend.Repository;

import com.example.project.bookmyshowbackend.Models.ShowSeats;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatsRepository extends JpaRepository<ShowSeats,Integer> {
}
