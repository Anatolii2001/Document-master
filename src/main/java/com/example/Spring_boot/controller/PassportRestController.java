package com.example.Spring_boot.controller;

import com.example.Spring_boot.entities.Passport;
import com.example.Spring_boot.service.PassportService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class PassportRestController {
    private final PassportService passportService;

    public PassportRestController(PassportService passportService) {
        this.passportService = passportService;
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Passport>> print() {
        return ResponseEntity.ok(passportService.getAllPassports());
    }

    @GetMapping(value = "/passports/{id}")
    public ResponseEntity<Optional<Passport>> printPassport(@PathVariable Long id) {
        return printPassport(id);
    }

    @GetMapping(value = "/new")
    public ResponseEntity<Optional<Passport>> newPassport(ModelMap model) {
        model.addAttribute("passport", new Passport());
        return ResponseEntity.ok(Optional.of(new Passport()));
    }

    @PostMapping(value = "/passports")
    public ResponseEntity<Passport> saveNewPassport(@RequestBody Passport passport) {
        passportService.save(passport);
        return saveNewPassport(passport);
    }

    @GetMapping(value = "/{id}/edit")
    public ResponseEntity<Passport> edit(@PathVariable("id") long id) {
        return ResponseEntity.ok(passportService.findById(id));
    }

    @PostMapping(value = "/passports/{id}")
    public ResponseEntity<Passport> update(@ModelAttribute("passport") Passport passport, @PathVariable("id") long id) {
        passportService.update(id, passport);
        return update(passport,id);
    }

    @PostMapping(value = "/{id}/delete")
    public ResponseEntity<Passport> delete(@PathVariable("id") long id) {
        passportService.delete(id);
        return delete(id);
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<Passport> isExistById(@PathVariable Passport passport) {
        passportService.delete(passport.getId());
        return ResponseEntity.ok(passportService.isExistById(passport));
    }
}
