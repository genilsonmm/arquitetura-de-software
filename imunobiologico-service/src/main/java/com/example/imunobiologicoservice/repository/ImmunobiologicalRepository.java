package com.example.imunobiologicoservice.repository;

import com.example.imunobiologicoservice.entity.Immunobiological;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImmunobiologicalRepository
        extends JpaRepository<Immunobiological, Long> {
}
