package com.projetss.tache.repository;


import com.projetss.tache.model.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TacheRepository extends JpaRepository<Tache, Long> {
    List<Tache> findByProjetId(Long projetId);
}
