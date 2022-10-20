package com.example.gccoffee.service;

import com.example.gccoffee.model.Category;
import com.example.gccoffee.model.Product;
import com.example.gccoffee.model.Vocher;

import java.time.LocalDateTime;
import java.util.List;

public interface VocherService {

    List<Vocher> getAllVochers();
    Vocher createVocher(String vocherName, int discount, LocalDateTime expirationAt);

}
