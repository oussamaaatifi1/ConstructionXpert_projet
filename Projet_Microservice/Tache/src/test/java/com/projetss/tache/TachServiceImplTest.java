package com.projetss.tache;


import com.projetss.tache.dto.TacheDto;
import com.projetss.tache.mapper.TacheMapper;
import com.projetss.tache.model.Tache;
import com.projetss.tache.service.impl.TachServiceImpl;
import com.projetss.tache.repository.TacheRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TachServiceImplTest {

    @Mock
    private TacheRepository tacheRepository;

    @Mock
    private TacheMapper tacheMapper;

    @InjectMocks
    private TachServiceImpl tachService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateTask() {
        // Arrange
        TacheDto tacheDto = new TacheDto();
        Tache tache = new Tache();
        when(tacheMapper.toEntity(tacheDto)).thenReturn(tache);
        when(tacheRepository.save(tache)).thenReturn(tache);
        when(tacheMapper.toDTO(tache)).thenReturn(tacheDto);

        // Act
        TacheDto result = tachService.createTask(tacheDto);

        // Assert
        assertNotNull(result);
        verify(tacheRepository, times(1)).save(tache);
    }

    @Test
    void testUpdateTask() {
        // Arrange
        Long tacheId = 1L;
        TacheDto tacheDto = new TacheDto();
        Tache tache = new Tache();
        when(tacheRepository.existsById(tacheId)).thenReturn(true);
        when(tacheMapper.toEntity(tacheDto)).thenReturn(tache);
        when(tacheRepository.save(tache)).thenReturn(tache);
        when(tacheMapper.toDTO(tache)).thenReturn(tacheDto);

        // Act
        TacheDto result = tachService.updateTask(tacheId, tacheDto);

        // Assert
        assertNotNull(result);
        verify(tacheRepository, times(1)).existsById(tacheId);
        verify(tacheRepository, times(1)).save(tache);
    }

    @Test
    void testDeleteTask() {
        // Arrange
        Long tacheId = 1L;
        when(tacheRepository.existsById(tacheId)).thenReturn(true);

        // Act
        tachService.deleteTask(tacheId);

        // Assert
        verify(tacheRepository, times(1)).deleteById(tacheId);
    }

    @Test
    void testGetTaskById() {
        // Arrange
        Long tacheId = 1L;
        Tache tache = new Tache();
        TacheDto tacheDto = new TacheDto();
        when(tacheRepository.findById(tacheId)).thenReturn(Optional.of(tache));
        when(tacheMapper.toDTO(tache)).thenReturn(tacheDto);

        // Act
        TacheDto result = tachService.getTaskById(tacheId);

        // Assert
        assertNotNull(result);
        verify(tacheRepository, times(1)).findById(tacheId);
    }

    @Test
    void testGetAllTasks() {
        // Arrange
        Tache tache1 = new Tache();
        Tache tache2 = new Tache();
        List<Tache> taches = Arrays.asList(tache1, tache2);
        TacheDto tacheDto1 = new TacheDto();
        TacheDto tacheDto2 = new TacheDto();
        when(tacheRepository.findAll()).thenReturn(taches);
        when(tacheMapper.toDTO(tache1)).thenReturn(tacheDto1);
        when(tacheMapper.toDTO(tache2)).thenReturn(tacheDto2);

        // Act
        List<TacheDto> result = tachService.getAllTasks();

        // Assert
        assertEquals(2, result.size());
        verify(tacheRepository, times(1)).findAll();
    }

    @Test
    void testGetTasksByProjectId() {
        // Arrange
        Long projectId = 1L;
        Tache tache1 = new Tache();
        Tache tache2 = new Tache();
        List<Tache> taches = Arrays.asList(tache1, tache2);
        TacheDto tacheDto1 = new TacheDto();
        TacheDto tacheDto2 = new TacheDto();
        when(tacheRepository.findByProjetId(projectId)).thenReturn(taches);
        when(tacheMapper.toDTO(tache1)).thenReturn(tacheDto1);
        when(tacheMapper.toDTO(tache2)).thenReturn(tacheDto2);

        // Act
        List<TacheDto> result = tachService.getTasksByProjectId(projectId);

        // Assert
        assertEquals(2, result.size());
        verify(tacheRepository, times(1)).findByProjetId(projectId);
    }
}