package com.experthub.experthub_api.expert.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.experthub.experthub_api.expert.entity.Expert;


@Repository
public interface ExpertRepository extends JpaRepository<Expert, Long> {
    Optional<Expert> findById(Long id);

    List<Expert> findAll();
}
