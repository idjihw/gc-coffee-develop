package com.example.gccoffee.repository;

import com.example.gccoffee.model.Category;
import com.example.gccoffee.model.Product;
import com.example.gccoffee.model.Vocher;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VocherRepository {

    List<Vocher> findAll();

    Vocher insert(Vocher vocher);

    Vocher update(Vocher vocher);

    void deleteAll();
}
