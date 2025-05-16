package com.cvapi.repository;

import com.cvapi.model.CV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //composant pour integrer avec la BDD
public interface CVRepository extends JpaRepository<CV, Long> {
    //herite depuis JpaRepository
}
