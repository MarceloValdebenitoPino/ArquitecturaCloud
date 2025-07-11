package com.reservas.repository;

import com.reservas.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    // Aquí se pueden agregar métodos de consulta personalizados si es necesario.
    // Por ejemplo, para buscar reservas por userId o resourceId.
}
                
