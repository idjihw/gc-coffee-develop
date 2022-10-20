package com.example.gccoffee.controller;

import com.example.gccoffee.model.Category;

import java.util.UUID;

public record UpdateProductRequest (UUID productId, String productName, Category category, long price, String description){
}
