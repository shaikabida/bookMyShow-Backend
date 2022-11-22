package com.example.project.bookmyshowbackend.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EntityListeners(value={AuditingEntityListener.class})
@Table(name="Ticket")
@ToString
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="allotedSeats",nullable = false)
    private String allotedSeats;
    @Column(name="amount",nullable = false)
    private double amount;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="bookedAt",columnDefinition = "DATE",nullable = false)
    private Date bookedAt;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private UserEntity user;

    //show entity
    @ManyToOne
    @JsonIgnore
    @JoinColumn
    private ShowEntity show;

    //showSeat entity
    @OneToMany(mappedBy = "ticket",cascade=CascadeType.ALL)    //bi directional mapping
    @JsonIgnore
    private List<ShowSeatsEntity> seats;
}
