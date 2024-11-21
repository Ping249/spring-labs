package com.lt.spring.labs.controllers;

import com.lt.spring.labs.dto.TransferFundsDTO;
import com.lt.spring.labs.services.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transfers")
public class TransferController {
    private final UserService userSvc;

    public TransferController(UserService userSvc){
        this.userSvc = userSvc;
    }

    @PostMapping
    public boolean transfer(@RequestBody @Valid TransferFundsDTO request) {
        return userSvc.performTransfer(request);
    }
}