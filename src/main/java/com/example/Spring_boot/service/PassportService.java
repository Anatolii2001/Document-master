package com.example.Spring_boot.service;

import com.example.Spring_boot.entities.Passport;

import java.util.List;

public interface PassportService {
    List<Passport> getAllPassports();
    void save(Passport passport);
    Passport findById(long id);
    void update(long id, Passport updatePassport);
    void delete(long id);
    Passport isExistById(Passport passport);
}
