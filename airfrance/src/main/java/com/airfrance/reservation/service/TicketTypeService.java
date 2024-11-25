package com.airfrance.reservation.service;

import com.airfrance.reservation.model.TicketType;
import com.airfrance.reservation.repository.TicketTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketTypeService {

    private final TicketTypeRepository repository;

    public TicketTypeService(TicketTypeRepository repository) {
        this.repository = repository;
    }

    public List<TicketType> findAll() {
        return repository.findAll();
    }

    public Optional<TicketType> findById(Long id) {
        return repository.findById(id);
    }

    public TicketType save(TicketType ticketType) {
        return repository.save(ticketType);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
