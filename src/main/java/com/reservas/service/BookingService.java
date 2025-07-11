package com.reservas.service;

import com.reservas.dto.BookingRequest;
import com.reservas.dto.BookingResponse;
import com.reservas.model.Booking;
import com.reservas.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingResponse createBooking(BookingRequest request) {
        // En una implementación real, aquí se llamaría al 'Resource Service'
        // para verificar la disponibilidad del recurso y al 'Auth Service' para validar el usuario.
        // Por simplicidad, asumimos que la reserva es siempre válida.
        log.info("Creando reserva para el recurso: {}", request.getResourceId());

        Booking booking = new Booking();
        booking.setUserId(request.getUserId());
        booking.setResourceId(request.getResourceId());
        booking.setStartTime(request.getStartTime());
        booking.setEndTime(request.getEndTime());

        Booking savedBooking = bookingRepository.save(booking);

        // En una implementación real, aquí se publicaría un evento
        // a un bus de mensajería (RabbitMQ/Kafka) para que el 'Notification Service'
        // envíe una confirmación.

        log.info("Reserva creada con ID: {}", savedBooking.getId());
        return mapToBookingResponse(savedBooking);
    }

    public Optional<BookingResponse> getBookingById(Long id) {
        return bookingRepository.findById(id)
                .map(this::mapToBookingResponse);
    }

    public List<BookingResponse> getAllBookings() {
        return bookingRepository.findAll().stream()
                .map(this::mapToBookingResponse)
                .collect(Collectors.toList());
    }

    private BookingResponse mapToBookingResponse(Booking booking) {
        return BookingResponse.builder()
                .id(booking.getId())
                .resourceId(booking.getResourceId())
                .userId(booking.getUserId())
                .startTime(booking.getStartTime())
                .endTime(booking.getEndTime())
                .status(booking.getStatus())
                .build();
    }
}
                
