package com.sips.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sips.dto.respuestaDto.TipoMultaRespuestaDto;
import com.sips.entities.TipoMultaEntity;




@Repository
public interface TipoMultaRepository  extends JpaRepository<TipoMultaEntity, Long> {

	TipoMultaEntity save(TipoMultaRespuestaDto tipomulta);

}
