package com.example.vacinaservice.repository;

import com.example.vacinaservice.entity.VaccineRegistry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineRepository
        extends JpaRepository<VaccineRegistry, Long> {
}
