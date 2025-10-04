package com.zakrzewski.eglos.controller;

import com.zakrzewski.eglos.model.request.CustomerLoginRequest;
import com.zakrzewski.eglos.model.request.CustomerRegisterRequest;
import com.zakrzewski.eglos.model.session.CustomerData;
import com.zakrzewski.eglos.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path = "/register", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> register(@RequestBody CustomerRegisterRequest customerRegisterRequest) {
        final Integer customerId = authenticationService.register(customerRegisterRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerId);
    }

    @PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerData> login(@RequestBody CustomerLoginRequest customerLoginRequest) {
        final CustomerData customerData = authenticationService.login(customerLoginRequest);
        return ResponseEntity.status(HttpStatus.OK).body(customerData);
    }

    @DeleteMapping(path = "/logout", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> logout() {
        final Boolean logoutCorrectly = authenticationService.logout();
        return ResponseEntity.status(HttpStatus.OK).body(logoutCorrectly);
    }
}
