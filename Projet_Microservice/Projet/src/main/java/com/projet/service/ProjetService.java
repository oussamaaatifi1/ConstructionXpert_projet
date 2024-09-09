package com.projet.service;

import com.projet.model.Projet;

import java.util.List;
import java.util.Optional;

public interface ProjetService {

    public List<Projet> getAllProjects();
    public Optional<Projet> getProjectById(Long id);
    public Projet createProject(Projet project);
    public Projet updateProject(Long id, Projet projectDetails);
    public void deleteProject(Long id);
}
