package com.projetss.tache.service;

import com.projetss.tache.dto.TacheDto;
import com.projetss.tache.model.Tache;

import java.util.List;

public interface TachService {
    public TacheDto createTask(TacheDto tacheDto);
    public TacheDto updateTask(Long id, TacheDto tacheDto);
    public void deleteTask(Long id);
    public TacheDto getTaskById(Long id);
    public List<TacheDto> getAllTasks();
    public List<TacheDto> getTasksByProjectId(Long projectId);
}
