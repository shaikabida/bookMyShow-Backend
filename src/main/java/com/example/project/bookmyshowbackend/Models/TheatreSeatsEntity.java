package com.example.project.bookmyshowbackend.Models;

import com.example.project.bookmyshowbackend.ENUM.seatType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="TheatreSeats")
@Builder
@ToString
public class TheatreSeatsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="seatNumber",nullable = false)
    private String seatNumber;

    @Column(name="rate",nullable = false)
    private int rate;

    @Enumerated(EnumType.STRING)
    @Column(name = "seatType",nullable = false)
    private seatType seatType;

    @ManyToOne
    @JsonIgnore
    @JoinColumn
    private TheatreEntity theatre;

}
