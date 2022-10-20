package com.example.gccoffee.controller;

import com.example.gccoffee.service.ProductService;
import com.example.gccoffee.service.VocherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VocherController {
    private final VocherService vocherService;

    public VocherController(VocherService vocherService) {
        this.vocherService = vocherService;
    }

    @GetMapping("/vochers")
    public String vochersPage(Model model){
        var vochers = vocherService.getAllVochers();
        model.addAttribute("vochers", vochers);
        return "vocher-list";
    }

    @GetMapping("new-vocher")
    public String newVocherPage(){
        return "new-vocher";
    }

    @PostMapping("/vochers")
    public String newVocher(CreateVocherRequest createVocherRequest){
        vocherService.createVocher(
                createVocherRequest.vocherName(),
                createVocherRequest.discount(),
                createVocherRequest.expirationAt());
        return "redirect:/vochers";
    }
}
