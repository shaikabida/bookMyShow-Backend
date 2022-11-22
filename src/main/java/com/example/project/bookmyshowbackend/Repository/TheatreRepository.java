package com.example.project.bookmyshowbackend.Repository;

import com.example.project.bookmyshowbackend.Models.TheatreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepository extends JpaRepository<TheatreEntity,Integer> {
}
