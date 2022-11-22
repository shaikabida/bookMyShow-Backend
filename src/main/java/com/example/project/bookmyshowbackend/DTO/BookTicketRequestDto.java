package com.example.project.bookmyshowbackend.DTO;

import com.example.project.bookmyshowbackend.ENUM.seatType;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookTicketRequestDto {
    int userId;
    int showId;
    Set<String> requestedSeats;
    seatType seatType;
}
