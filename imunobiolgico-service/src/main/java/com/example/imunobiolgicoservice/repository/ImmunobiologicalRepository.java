package com.example.imunobiolgicoservice.repository;

import com.example.imunobiolgicoservice.entity.Immunobiological;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImmunobiologicalRepository extends JpaRepository<Immunobiological, Long> {
}
