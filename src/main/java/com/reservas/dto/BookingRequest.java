package com.reservas.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class BookingRequest {
    private String resourceId;
    private String userId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
                
