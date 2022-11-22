package com.example.project.bookmyshowbackend.Service.Implementation;

import com.example.project.bookmyshowbackend.Convertor.TicketConvertor;
import com.example.project.bookmyshowbackend.DTO.BookTicketRequestDto;
import com.example.project.bookmyshowbackend.DTO.ResponseDTO.TicketResponseDto;
import com.example.project.bookmyshowbackend.Models.ShowTime;
import com.example.project.bookmyshowbackend.Models.ShowSeats;
import com.example.project.bookmyshowbackend.Models.Ticket;
import com.example.project.bookmyshowbackend.Models.User;
import com.example.project.bookmyshowbackend.Repository.ShowRepository;
import com.example.project.bookmyshowbackend.Repository.TicketRepository;
import com.example.project.bookmyshowbackend.Repository.UserRepository;
import com.example.project.bookmyshowbackend.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class TicketServiceImplement implements TicketService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ShowRepository showRepository;
    @Autowired
    TicketRepository ticketRepository;

    @Override
    public TicketResponseDto getTicket(int id) {
        Ticket ticket=ticketRepository.findById(id).get();
        TicketResponseDto ticketDto=TicketConvertor.convertEntityToDto(ticket);
        return ticketDto;
    }

    @Override
    public TicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto) {
        User user=userRepository.findById(bookTicketRequestDto.getUserId()).get();
        ShowTime show=showRepository.findById(bookTicketRequestDto.getShowId()).get();
        Set<String> requestedSeats=bookTicketRequestDto.getRequestedSeats();

        List<ShowSeats> showSeatsList=show.getSeats();

//        List<ShowSeats> availableSeats=new ArrayList<>();
//        for(ShowSeats seat:showSeatsList){
//            if(!seat.isBooked() && seat.getSeatType().equals(bookTicketRequestDto.getSeatType()) &&
//            requestedSeats.contains(seat.getSeatNo())){
//                availableSeats.add(seat);
//            }
//        }
        //Step 1
        List<ShowSeats> availableSeats=showSeatsList.stream()
                .filter(seat -> seat.getSeatType().equals(bookTicketRequestDto.getSeatType()) && !seat.isBooked() &&
                        requestedSeats.contains(seat.getSeatNo())).collect(Collectors.toList());

        if(availableSeats.size() != requestedSeats.size()){
            throw new Error("All Seats not available");
        }

        //Step 2
        Ticket ticket=Ticket.builder().user(user).show(show).seats(availableSeats).build();

        //Step 3
        double amount=0;
        for(ShowSeats seat:availableSeats){
            seat.setBooked(true);
            seat.setBookedAt(new Date());
            seat.setTicket(ticket);
            seat.setShow(show);
            amount+=seat.getRate();
        }
        ticket.setAmount(amount);
        ticket.setAllotedSeats(convertListOfSeatsToString(availableSeats));

        user.getListOfTickets().add(ticket);
        show.getTicekts().add(ticket);

        ticket=ticketRepository.save(ticket);
        return TicketConvertor.convertEntityToDto(ticket);
    }

    public String convertListOfSeatsToString(List<ShowSeats> bookedSeats){
        String str="";
        for(ShowSeats showSeats:bookedSeats){
            str=str+showSeats.getSeatNo()+" ";
        }
        return str;
    }
}
