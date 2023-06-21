package com.BookMyShow.book_my_show.Controller;

import com.BookMyShow.book_my_show.RequestDto.TicketRequestDto;
import com.BookMyShow.book_my_show.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for managing ticket-related endpoints.
 */
@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    /**
     * Book a ticket.
     *
     * @param ticketRequestDto Request body containing ticket details.
     * @return A success message indicating the ticket was booked successfully, or
     *         an error message if booking failed.
     */
    @PostMapping("book")
    public String bookTicket(@RequestBody TicketRequestDto ticketRequestDto) {
        try {
            return ticketService.bookTicket(ticketRequestDto);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /**
     * Cancel a ticket.
     *
     * @param ticketId The ID of the ticket to cancel.
     * @return A success message indicating the ticket was canceled successfully, or
     *         an error message if cancellation failed.
     */
    @DeleteMapping("cancel")
    public String cancelTicket(@RequestParam("id") int ticketId) {
        try {
            return ticketService.cancelTicket(ticketId);
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
