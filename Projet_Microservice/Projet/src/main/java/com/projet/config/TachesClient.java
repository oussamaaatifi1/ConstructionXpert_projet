package com.projet.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "project-service", url = "http://localhost:8081")
public interface TachesClient {

    @GetMapping("/projects/{projetId}")
    void isProjectExist(@PathVariable("projetId") Long projetId);
}
