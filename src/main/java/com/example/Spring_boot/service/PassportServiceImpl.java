package com.example.Spring_boot.service;

import com.example.Spring_boot.entities.Passport;
import com.example.Spring_boot.repositories.PassportRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PassportServiceImpl implements PassportService {

    private final PassportRepository passportRepository;

    public PassportServiceImpl(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    @Override
    public List<Passport> getAllPassports() {
        return passportRepository.findAll();
    }

    @Override
    @Transactional
    public void save(Passport passport) {
        passportRepository.save(passport);
    }

    @Override
    public Passport findById(long id) {
        return passportRepository.findPassportById(id);
    }

    @Override
    @Transactional
    public void update(long id, Passport updatePassport) {
        passportRepository.save(updatePassport);
    }

    @Override
    @Transactional
    public void delete(long id) {
        passportRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Passport isExistById(Passport passport) {
        return passportRepository.findPassportById(passport.getId());
    }
}
