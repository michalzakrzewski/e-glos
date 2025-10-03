package com.zakrzewski.eglos.service;

import com.zakrzewski.eglos.model.request.CustomerRegisterRequest;
import com.zakrzewski.eglos.repository.AuthenticationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private static final Logger LOG = LoggerFactory.getLogger(AuthenticationService.class);

    private final AuthenticationRepository authenticationRepository;

    @SuppressWarnings("unused")
    public AuthenticationService() {
        this(null);
    }

    @Autowired
    public AuthenticationService(final AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
    }

    public Integer register(final CustomerRegisterRequest customerRegisterRequest) {
        return 1001;
    }
}
