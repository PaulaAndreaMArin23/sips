package com.sips.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sips.entities.BarrioEntity;

@Repository
public interface BarrioRepository extends JpaRepository<BarrioEntity, Long> {

}
