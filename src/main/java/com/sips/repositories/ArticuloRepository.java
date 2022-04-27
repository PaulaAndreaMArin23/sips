package com.sips.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sips.entities.ArticuloEntity;

@Repository
public interface ArticuloRepository extends JpaRepository<ArticuloEntity, Long> {

}

