package com.projet.service.impl;


import com.projet.model.Projet;
import com.projet.repository.ProjetRepository;
import com.projet.service.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProjetServiceImpl implements ProjetService {

    @Autowired
    private ProjetRepository projectRepository;
    @Override
    public List<Projet> getAllProjects() {
        return projectRepository.findAll();
    }
    @Override
    public Optional<Projet> getProjectById(Long id) {
        return projectRepository.findById(id);
    }
    @Override
    public Projet createProject(Projet project) {
        return projectRepository.save(project);
    }
    @Override
    public Projet updateProject(Long id, Projet projectDetails) {
        Projet project = projectRepository.findById(id).orElseThrow();
        project.setName(projectDetails.getName());
        project.setDescription(projectDetails.getDescription());
        project.setStartDate(projectDetails.getStartDate());
        project.setEndDate(projectDetails.getEndDate());
        project.setBudget(projectDetails.getBudget());
        return projectRepository.save(project);
    }
    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
