package com.example.gccoffee.service;

import com.example.gccoffee.model.Product;
import com.example.gccoffee.model.Vocher;
import com.example.gccoffee.repository.VocherRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Service
public class DefaultVocherService implements VocherService{

    private final VocherRepository vocherRepository;

    public DefaultVocherService(VocherRepository vocherRepository) {
        this.vocherRepository = vocherRepository;
    }


    @Override
    public List<Vocher> getAllVochers() {
        return vocherRepository.findAll();
    }

    @Override
    public Vocher createVocher(String vocherName, int discount, LocalDateTime expirationAt) {
        var vocher = new Vocher(vocherName, discount, expirationAt);
        return vocherRepository.insert(vocher);
    }

    @Override
    public Vocher createVocher(String vocherName, int discount) {
        var vocher = new Vocher(vocherName, discount);
        return vocherRepository.insert(vocher);
    }
}
