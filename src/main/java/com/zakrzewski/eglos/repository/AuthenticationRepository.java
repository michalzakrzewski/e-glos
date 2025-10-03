package com.zakrzewski.eglos.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class AuthenticationRepository {

    @PersistenceContext
    private EntityManager entityManager;
}
