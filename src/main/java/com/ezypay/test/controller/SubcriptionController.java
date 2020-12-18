package com.ezypay.test.controller;

import com.ezypay.test.controller.dto.SubscriptionDto;
import com.ezypay.test.service.SubscriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SubcriptionController {



    private final SubscriptionService service;

    public SubcriptionController(SubscriptionService service) {
        this.service = service;
    }

    @PostMapping("/subscription")
    public ResponseEntity<SubscriptionDto> createSubscription(@RequestBody SubscriptionDto dto){

        SubscriptionDto result = service.createSubscription(dto);

        return ResponseEntity.ok(result);
    }

}
