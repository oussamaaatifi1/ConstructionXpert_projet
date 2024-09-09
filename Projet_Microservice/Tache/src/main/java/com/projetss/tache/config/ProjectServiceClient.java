package com.projetss.tache.config;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProjectServiceClient {

    private final RestTemplate restTemplate;

    public ProjectServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean isProjectExist(Long projetId) {
        try {
            String url = "http://localhost:8081/projects/" + projetId;
            restTemplate.getForObject(url, Void.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}