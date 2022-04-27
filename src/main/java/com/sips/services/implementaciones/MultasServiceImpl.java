package com.sips.services.implementaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sips.dto.mapperM;

import com.sips.dto.respuestaDto.MultasRespuestaDto;
import com.sips.dto.solicitudDto.MultasSolicitudDto;
import com.sips.entities.MultasEntity;
import com.sips.exceptions.RecursoNoEncontradoException;
import com.sips.repositories.MultasRepository;
import com.sips.services.MultasService;

@Service
public class MultasServiceImpl implements MultasService{
	
	@Autowired
	private MultasRepository multasRepository;

	@Override
	public List<MultasRespuestaDto> mostrarMultas() {
		List<MultasEntity> multas = multasRepository.findAll();
		return mapperM.multasAListaMultasRespuestaDto(multas);
	}

	@Override
	public MultasRespuestaDto obtenerMultasPorId(Long multasId) {
		MultasEntity multas = multasRepository.findById(multasId)
				.orElseThrow(() -> new RecursoNoEncontradoException(multasId, "Multas"));
		return mapperM.multasARespuestaDto(multas);
	}

	@Override
	public MultasRespuestaDto crearMultas(MultasSolicitudDto multasSolicitudDto) {
		MultasEntity multas = new MultasEntity();	
		
		multas.setDescripcion(multasSolicitudDto.getDescripcion());
		
		return mapperM.multasARespuestaDto(multasRepository.save(multas));
	}

	@Override
	public MultasRespuestaDto actualizarMultas(Long multasId, MultasSolicitudDto multasSolicitudDto) {
		MultasEntity multas = multasRepository.findById(multasId)
				.orElseThrow(() -> new RecursoNoEncontradoException(multasId, "Multas"));
		return mapperM.multasARespuestaDto(multasRepository.save (multas));
	}

	@Override
	public void eliminarMultas(Long multasId) {
		MultasEntity multas = multasRepository.findById(multasId)
				.orElseThrow(() -> new RecursoNoEncontradoException(multasId, "Multas"));
		multas.setDeleted(true);
		multasRepository.save(multas);		
	}

}
