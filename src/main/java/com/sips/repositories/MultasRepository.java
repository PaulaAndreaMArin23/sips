package com.sips.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sips.entities.MultasEntity;




@Repository
public interface MultasRepository  extends JpaRepository<MultasEntity, Long> {

}
