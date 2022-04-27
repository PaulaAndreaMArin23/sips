package com.sips.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sips.entities.QuejaEntity;

@Repository
public interface QuejaRepository extends JpaRepository<QuejaEntity, Long>{

}
