package com.airfrance.reservation.service;

import com.airfrance.reservation.model.Reservation;
import com.airfrance.reservation.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReservationService {

    private final ReservationRepository repository;

    public ReservationService(ReservationRepository repository) {
        this.repository = repository;
    }

    public List<Reservation> findAll() {
        return repository.findAll();
    }

    public Optional<Reservation> findById(Long id) {
        return repository.findById(id);
    }

    public Reservation save(Reservation reservation) {
        reservation.setTicketReference(UUID.randomUUID().toString());
        return repository.save(reservation);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
