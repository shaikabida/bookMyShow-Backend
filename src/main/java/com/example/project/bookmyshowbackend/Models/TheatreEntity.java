package com.example.project.bookmyshowbackend.Models;

import com.example.project.bookmyshowbackend.ENUM.TheatreType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Theatre")
@Builder
public class TheatreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="address",nullable = false)
    private String address;

    @Column(name="city",nullable = false)
    private String city;

    @Enumerated(EnumType.STRING)
    @Column(name="type",nullable = false)
    private TheatreType type;

    @OneToMany(mappedBy = "theatre",cascade=CascadeType.ALL)    //bi directional mapping
    @JsonIgnore
    private List<ShowEntity> listOfShows;

    @OneToMany(mappedBy = "theatre",cascade=CascadeType.ALL)    //bi directional mapping
    @JsonIgnore
    private List<TheatreSeatsEntity> threatreSeats;
}
