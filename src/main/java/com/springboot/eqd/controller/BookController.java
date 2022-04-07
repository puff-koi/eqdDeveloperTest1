package com.springboot.eqd.controller;

import com.springboot.eqd.common.CustomRestResult;
import com.springboot.eqd.domain.BookingDto;
import com.springboot.eqd.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/store")
    public CustomRestResult<Object> storeBooking(@RequestBody @Valid BookingDto bookingDto) {
        bookService.storeBooking(bookingDto);
        return CustomRestResult.success("booking success!");
    }

    @GetMapping("/list/room/by/{date}")
    public CustomRestResult<Set<String>> findAvailableRooms(@PathVariable("date") @DateTimeFormat(pattern="yyyy-MM-dd") Date date){
        return CustomRestResult.success(bookService.findAvailableRooms(date),"success");
    }

    @GetMapping("/list/by/{name}")
    public CustomRestResult<List<BookingDto>> findAllBookingByGuest(@PathVariable("name") String guestName){
        return CustomRestResult.success(bookService.findAllBookingByGuest(guestName),"success");
    }
}
