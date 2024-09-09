package com.projetss.tache.service.impl;

import com.projetss.tache.model.Tache;
import com.projetss.tache.repository.TacheRepository;
import com.projetss.tache.service.TachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TachServiceImpl implements TachService {

    @Autowired
    private TacheRepository tacheRepository;

    @Override
    public Tache createTask(Tache tache) {
        return tacheRepository.save(tache);
    }

    @Override
    public List<Tache> getAllProjects() {
        return tacheRepository.findAll();
    }

}
