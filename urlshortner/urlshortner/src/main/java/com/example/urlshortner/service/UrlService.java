package com.example.urlshortner.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.urlshortner.entity.UrlMapping;

public interface UrlService {

    public UrlMapping createShortUrl(String longUrl);

    public String redirect(String shortCode);

    public UrlMapping getStats(String shortCode);

    public Page<UrlMapping> getAll(Pageable pageable);

    public void delete(String shortCode);
}