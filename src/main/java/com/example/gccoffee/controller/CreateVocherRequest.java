package com.example.gccoffee.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record CreateVocherRequest(String vocherName, int discount, LocalDateTime expirationAt) {

}
