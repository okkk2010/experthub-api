package com.experthub.experthub_api.expertise.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.experthub.experthub_api.expertise.entiry.ExpertiseEntity;

@Repository
public interface ExpertiseRepository extends JpaRepository<ExpertiseEntity, Long> {
    
    List<ExpertiseEntity> findAll();
    
    Optional<ExpertiseEntity> findByCode(Integer code);
    Optional<ExpertiseEntity> findByExpertise(String expertise);
} 