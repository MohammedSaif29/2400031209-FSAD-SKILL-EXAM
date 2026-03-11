package com.klef.fsad.exam.controller;

import com.klef.fsad.exam.model.Transport;
import com.klef.fsad.exam.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transport")
public class TransportController {

    @Autowired
    private TransportService service;

    // 1. Add Transport (POST request)
    @PostMapping("/add")
    public ResponseEntity<String> addTransport(@RequestBody Transport transport) {
        if (transport.getTransportId() == null) {
            return ResponseEntity.badRequest().body("Transport ID MUST be provided manually and must not be null.");
        }
        service.addTransport(transport);
        return ResponseEntity.ok("Transport added successfully with ID: " + transport.getTransportId());
    }

    // 2. Second operation using DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTransport(@PathVariable Long id) {
        if (service.getTransportById(id).isPresent()) {
            service.deleteTransport(id);
            return ResponseEntity.ok("Transport deleted successfully");
        } else {
            return ResponseEntity.badRequest().body("Transport with ID " + id + " not found.");
        }
    }
}
