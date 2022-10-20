package com.example.gccoffee.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Vocher {
    private String vocherName;

    private int discount;
    private LocalDateTime expirationAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Vocher(String vocherName, int discount, LocalDateTime expirationAt) {
        this.vocherName = vocherName;
        this.discount = discount;
        this.expirationAt = expirationAt;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Vocher(String vocherName, int discount, LocalDateTime expirationAt, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.vocherName = vocherName;
        this.discount = discount;
        this.expirationAt = expirationAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Vocher(String vocherName, int discount) {
        this.vocherName = vocherName;
        this.discount = discount;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public String getVocherName() {
        return vocherName;
    }

    public int getDiscount() {
        return discount;
    }

    public LocalDateTime getExpirationAt() {
        return expirationAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }


    public void setVocherName(String vocherName) {
        this.vocherName = vocherName;
        this.updatedAt = LocalDateTime.now();
    }

    public void setProductName(int discount) {
        this.discount = discount;
        this.updatedAt = LocalDateTime.now();
    }

    public void setExpirationAt(LocalDateTime expirationAt) {
        this.expirationAt = expirationAt;
        this.updatedAt = LocalDateTime.now();
    }
}
