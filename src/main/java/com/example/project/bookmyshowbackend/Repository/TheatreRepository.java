package com.example.project.bookmyshowbackend.Repository;

import com.example.project.bookmyshowbackend.Models.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre,Integer> {
}
