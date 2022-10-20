package com.example.gccoffee.controller;

import com.example.gccoffee.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String productsPage(Model model){
        var products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "product-list";
    }

    @GetMapping("new-product")
    public String newProductPage(){
        return "new-product";
    }

    @GetMapping("update-product")
    public String updateProductPage(){
        return "update-product";
    }

    @GetMapping("delete-product")
    public String deleteProductPage(){
        return "delete-product";
    }

    @PostMapping("/products")
    public String newProduct(CreateProductRequest createProductRequest){
        productService.createProduct(
                createProductRequest.productName(),
                createProductRequest.category(),
                createProductRequest.price(),
                createProductRequest.description());
        return "redirect:/products";
    }

    @PostMapping("/update")
    public String updateProduct(UpdateProductRequest updateProductRequest){
        productService.updateProduct(
                updateProductRequest.productId(),
                updateProductRequest.productName(),
                updateProductRequest.category(),
                updateProductRequest.price(),
                updateProductRequest.description());
        return "redirect:/products";
    }

    @PostMapping("/delete")
    public String deleteProduct(DeleteProductRequest deleteProductRequest){
        productService.deleteProduct(
                deleteProductRequest.productId()
        );
        return "redirect:/products";
    }
}
