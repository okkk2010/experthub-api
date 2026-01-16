package com.experthub.experthub_api.expert.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.experthub.experthub_api.expert.entity.ExpertEntity;
import java.util.Optional;
import java.util.List;


@Repository
public interface ExpertRepository extends JpaRepository<ExpertEntity, Long> {

    
    Optional<ExpertEntity> findById(Long id);

    List<ExpertEntity> findAll();
}
