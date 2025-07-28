package com.urban.service;

import com.urban.dto.BookingRequest;
import com.urban.model.entity.Booking;
import com.urban.model.entity.Booking.BookingStatus;
import com.urban.model.entity.User;
import com.urban.model.document.CompanionProfile;
import com.urban.repository.mysql.BookingRepository;
import com.urban.repository.mysql.UserRepository;
import com.urban.repository.mongo.CompanionProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final CompanionProfileRepository companionProfileRepository;

    public Booking createBooking(BookingRequest request) {
        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        CompanionProfile companion = companionProfileRepository.findById(request.companionId())
                .orElseThrow(() -> new IllegalArgumentException("Companion not found"));

        if (!companion.getAvailable()) {
            throw new IllegalArgumentException("Companion is not available");
        }

        Booking booking = Booking.builder()
                .userId(user.getId())
                .companionId(companion.getId())
                .dateTime(request.dateTime())
                .duration(request.duration())
                .status(BookingStatus.PENDING)
                .totalPrice(BigDecimal.valueOf(300).multiply(BigDecimal.valueOf(request.duration())))
                .build();

        return bookingRepository.save(booking);
    }

    public List<Booking> getUserBookings(Long userId) {
        return bookingRepository.findByUserIdOrderByDateTimeDesc(userId);
    }
}
