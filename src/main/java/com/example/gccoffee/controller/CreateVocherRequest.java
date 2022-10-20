package com.example.gccoffee.controller;

import java.time.LocalDateTime;

public record CreateVocherRequest(String vocherName, int discount, LocalDateTime expirationAt) {

}
