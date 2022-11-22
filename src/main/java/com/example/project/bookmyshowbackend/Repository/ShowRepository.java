package com.example.project.bookmyshowbackend.Repository;

import com.example.project.bookmyshowbackend.Models.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<ShowTime,Integer> {
}
