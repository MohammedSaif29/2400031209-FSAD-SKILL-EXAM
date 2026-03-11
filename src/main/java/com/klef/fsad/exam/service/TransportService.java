package com.klef.fsad.exam.service;

import com.klef.fsad.exam.model.Transport;
import com.klef.fsad.exam.repository.TransportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransportService {

    @Autowired
    private TransportRepository repository;

    public Transport addTransport(Transport transport) {
        return repository.save(transport);
    }

    public void deleteTransport(Long id) {
        repository.deleteById(id);
    }
    
    public Optional<Transport> getTransportById(Long id) {
        return repository.findById(id);
    }
}
