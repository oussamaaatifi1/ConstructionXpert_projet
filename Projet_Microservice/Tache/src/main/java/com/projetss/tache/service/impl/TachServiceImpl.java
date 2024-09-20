package com.projetss.tache.service.impl;

import com.projetss.tache.dto.TacheDto;
import com.projetss.tache.mapper.TacheMapper;
import com.projetss.tache.model.Tache;
import com.projetss.tache.repository.TacheRepository;
import com.projetss.tache.service.TachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TachServiceImpl implements TachService {

    @Autowired
    private TacheRepository taskRepository;

    private final TacheMapper taskMapper = TacheMapper.INSTANCE;

    public TacheDto createTask(TacheDto tacheDto) {
        Tache task = TacheMapper.INSTANCE.toEntity(tacheDto);
        Tache savedTask = taskRepository.save(task);
        return TacheMapper.INSTANCE.toDTO(savedTask);
    }

    public TacheDto updateTask(Long id, TacheDto tacheDto) {
        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Task not found");
        }
        Tache task = TacheMapper.INSTANCE.toEntity(tacheDto);
        task.setId(id);
        Tache updatedTask = taskRepository.save(task);
        return TacheMapper.INSTANCE.toDTO(updatedTask);
    }

    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Task not found");
        }
        taskRepository.deleteById(id);
    }

    public TacheDto getTaskById(Long id) {
        Optional<Tache> task = taskRepository.findById(id);
        if (task.isEmpty()) {
            throw new RuntimeException("Task not found");
        }
        return TacheMapper.INSTANCE.toDTO(task.get());
    }

    public List<TacheDto> getAllTasks() {
        List<Tache> tasks = taskRepository.findAll();
        return tasks.stream()
                .map(TacheMapper.INSTANCE::toDTO)
                .toList();
    }

    @Override
    public List<TacheDto> getTasksByProjectId(Long projectId) {
        List<Tache> tasks = taskRepository.findByProjetId(projectId);
        return tasks.stream()
                .map(taskMapper::toDTO)
                .collect(Collectors.toList());
    }

}
