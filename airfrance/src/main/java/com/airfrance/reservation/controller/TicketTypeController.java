package com.airfrance.reservation.controller;

import com.airfrance.reservation.model.TicketType;
import com.airfrance.reservation.service.TicketTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket-types")
public class TicketTypeController {

    private final TicketTypeService service;

    public TicketTypeController(TicketTypeService service) {
        this.service = service;
    }

    @GetMapping
    public List<TicketType> listAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketType> getTicketType(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TicketType createTicketType(@RequestBody TicketType ticketType) {
        return service.save(ticketType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketType> updateTicketType(@PathVariable Long id, @RequestBody TicketType updatedTicketType) {
        return service.findById(id)
                .map(existing -> {
                    updatedTicketType.setId(existing.getId());
                    return ResponseEntity.ok(service.save(updatedTicketType));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicketType(@PathVariable Long id) {
        if (service.findById(id).isPresent()) {
            service.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
