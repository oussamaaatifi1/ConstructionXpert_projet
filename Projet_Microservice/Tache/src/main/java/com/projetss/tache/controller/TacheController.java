package com.projetss.tache.controller;

import com.projetss.tache.dto.TacheDto;
import com.projetss.tache.model.Tache;
import com.projetss.tache.service.impl.TachServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taches")
public class TacheController {

    @Autowired
    private TachServiceImpl taskService;

    @PostMapping
    public ResponseEntity<TacheDto> createTask(@RequestBody TacheDto tachedto) {
        TacheDto createdTask = taskService.createTask(tachedto);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TacheDto> getTaskById(@PathVariable Long id) {
        TacheDto taskDTO = taskService.getTaskById(id);
        return new ResponseEntity<>(taskDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TacheDto>> getAllTasks() {
        List<TacheDto> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TacheDto> updateTask(@PathVariable Long id, @RequestBody TacheDto tachedto) {
        TacheDto updatedTask = taskService.updateTask(id, tachedto);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<TacheDto>> getTasksByProjectId(@PathVariable Long projectId) {
        List<TacheDto> tasks = taskService.getTasksByProjectId(projectId);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
}
