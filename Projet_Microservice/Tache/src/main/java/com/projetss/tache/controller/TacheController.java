package com.projetss.tache.controller;

import com.projetss.tache.model.Tache;
import com.projetss.tache.service.impl.TachServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taches")
public class TacheController {

    @Autowired
    private TachServiceImpl tachService;

    @PostMapping
    public Tache createTask(@RequestBody Tache tache) {
        return tachService.createTask(tache);
    }

    @GetMapping
    public List<Tache> getAllProjects() {
        return tachService.getAllProjects();
    }
}
