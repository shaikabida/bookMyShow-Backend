package com.example.project.bookmyshowbackend.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Show")
@Builder
@ToString
@EntityListeners(value = {AuditingEntityListener.class})
public class ShowTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="showDate",columnDefinition = "DATE",nullable = false)
    private LocalDate showDate;
    @Column(name="showTime",columnDefinition = "TIME",nullable = false)
    private LocalTime showTime;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name="createdDate")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(name="updatedDate")
    private Date updatedAt;

    @JsonIgnore
    @ManyToOne
    private Movie movie;

    @JsonIgnore
    @ManyToOne
    private Theatre theatre;

    @JsonIgnore
    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private List<Ticket> ticekts;

    @JsonIgnore
    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private List<ShowSeats> seats;
}
