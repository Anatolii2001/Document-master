package com.example.Spring_boot.repositories;

import com.example.Spring_boot.entities.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepository extends JpaRepository<Passport, Long> {
    Passport findPassportById (Long id);
}
