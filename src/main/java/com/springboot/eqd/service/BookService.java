package com.springboot.eqd.service;

import com.springboot.eqd.domain.BookingDto;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

public interface BookService {

    void storeBooking(BookingDto bookingDto);
    Set<String> findAvailableRooms(Date date);
    List<BookingDto> findAllBookingByGuest(String guestName);
}
