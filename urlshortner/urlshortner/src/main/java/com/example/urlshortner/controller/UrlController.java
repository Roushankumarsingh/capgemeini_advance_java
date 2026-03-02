package com.example.urlshortner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.urlshortner.entity.UrlMapping;
import com.example.urlshortner.service.UrlService;

import java.net.URI;

@RestController
@RequestMapping("/api")
public class UrlController {

    @Autowired
    private UrlService service;

    @PostMapping("/shorten")
    public ResponseEntity<UrlMapping> shorten(@RequestParam String longUrl) {
        UrlMapping mapping = service.createShortUrl(longUrl);
        return new ResponseEntity<>(mapping, HttpStatus.CREATED);
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirect(@PathVariable String shortCode) {

        String longUrl = service.redirect(shortCode);

        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(longUrl))
                .build();
    }

    @GetMapping("/stats/{shortCode}")
    public ResponseEntity<UrlMapping> stats(@PathVariable String shortCode) {
        return ResponseEntity.ok(service.getStats(shortCode));
    }

    @GetMapping("/all")
    public ResponseEntity<Page<UrlMapping>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return ResponseEntity.ok(service.getAll(PageRequest.of(page, size)));
    }

    @DeleteMapping("/{shortCode}")
    public ResponseEntity<String> delete(@PathVariable String shortCode) {
        service.delete(shortCode);
        return ResponseEntity.ok("Deleted successfully");
    }
}