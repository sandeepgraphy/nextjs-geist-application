package com.urban.controller;

import com.urban.dto.BookingRequest;
import com.urban.model.entity.Booking;
import com.urban.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<Booking> create(@RequestBody BookingRequest request) {
        return ResponseEntity.ok(bookingService.createBooking(request));
    }

    @GetMapping("/history")
    public ResponseEntity<List<Booking>> history(@RequestParam Long userId) {
        return ResponseEntity.ok(bookingService.getUserBookings(userId));
    }
}
