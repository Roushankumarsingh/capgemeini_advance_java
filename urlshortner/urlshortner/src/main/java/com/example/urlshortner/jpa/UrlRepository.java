package com.example.urlshortner.jpa;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.urlshortner.entity.UrlMapping;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<UrlMapping, Long> {

    Optional<UrlMapping> findByShortCode(String shortCode);

    Optional<UrlMapping> findByLongUrl(String longUrl);

    void deleteByShortCode(String shortCode);
}