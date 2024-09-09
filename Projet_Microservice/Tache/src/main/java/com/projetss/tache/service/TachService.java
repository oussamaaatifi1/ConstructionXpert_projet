package com.projetss.tache.service;

import com.projetss.tache.model.Tache;

import java.util.List;

public interface TachService {
    public Tache createTask(Tache tache);

    public List<Tache> getAllProjects();
}
