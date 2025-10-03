package com.zakrzewski.eglos.controller;

import com.zakrzewski.eglos.model.request.CustomerRegisterRequest;
import com.zakrzewski.eglos.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @SuppressWarnings("unused")
    public AuthenticationController() {
        this(null);
    }

    @Autowired
    public AuthenticationController(final AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping(path = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> register(@RequestBody CustomerRegisterRequest customerRegisterRequest) {
        final Integer customerId = authenticationService.register(customerRegisterRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerId);
    }
}
