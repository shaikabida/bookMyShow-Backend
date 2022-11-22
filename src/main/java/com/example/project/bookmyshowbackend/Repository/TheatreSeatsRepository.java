package com.example.project.bookmyshowbackend.Repository;

import com.example.project.bookmyshowbackend.Models.TheatreSeatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreSeatsRepository extends JpaRepository<TheatreSeatsEntity,Integer> {
}
