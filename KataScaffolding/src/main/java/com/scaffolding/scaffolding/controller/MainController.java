package com.scaffolding.scaffolding.controller;

import com.scaffolding.scaffolding.dto.MainResponseDTO;
import com.scaffolding.scaffolding.service.impl.MainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @Autowired
    MainServiceImpl mainService;

    @GetMapping("/getMethod")
    private MainResponseDTO getMethod() {
        return mainService.getMethod();
    }

    @PostMapping("/postMethod")
    private MainResponseDTO postMethod() {
        return mainService.postMethod();
    }

    @PutMapping("/putMethod")
    private MainResponseDTO putMethod() {
        return mainService.putMethod();
    }

    @DeleteMapping("/deleteMethod")
    private MainResponseDTO deleteMethod() {
        return mainService.deleteMethod();
    }

    @PatchMapping("/patchMethod")
    private MainResponseDTO patchMethod() {
        return mainService.patchMethod();
    }


}
