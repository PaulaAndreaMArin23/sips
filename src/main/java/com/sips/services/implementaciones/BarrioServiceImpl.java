package com.sips.services.implementaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sips.dto.mapper;
import com.sips.dto.respuestaDto.BarrioRespuestaDto;
import com.sips.dto.solicitudDto.BarrioSolicitudDto;
import com.sips.entities.BarrioEntity;
import com.sips.exceptions.RecursoNoEncontradoException;
import com.sips.repositories.BarrioRepository;
import com.sips.services.BarrioService;

@Service
public class BarrioServiceImpl implements BarrioService{
	
	@Autowired
	private BarrioRepository barrioRepository;

	@Override
	public List<BarrioRespuestaDto> mostrarBarrios() {
		List<BarrioEntity> barrios = barrioRepository.findAll();
		return mapper.barriosAListaBarriosRespuestaDto(barrios);
	}

	@Override
	public BarrioRespuestaDto obtenerBarrioPorId(Long barrioId) {
		BarrioEntity barrio = barrioRepository.findById(barrioId)
				.orElseThrow(() -> new RecursoNoEncontradoException(barrioId, "Barrio"));
		return mapper.barrioARespuestaDto(barrio);
	}

	@Override
	public BarrioRespuestaDto crearBarrio(BarrioSolicitudDto barrioSolicitudDto) {
		BarrioEntity barrio = new BarrioEntity();	
		
		barrio.setNombre(barrioSolicitudDto.getNombre());
		
		return mapper.barrioARespuestaDto(barrioRepository.save(barrio));
	}

	@Override
	public BarrioRespuestaDto actualizarBarrio(Long barrioId, BarrioSolicitudDto barrioSolicitudDto) {
		BarrioEntity barrio = barrioRepository.findById(barrioId)
				.orElseThrow(() -> new RecursoNoEncontradoException(barrioId, "Barrio"));
		return mapper.barrioARespuestaDto(barrioRepository.save(barrio));
	}

	@Override
	public void eliminarBarrio(Long barrioId) {
		BarrioEntity barrio = barrioRepository.findById(barrioId)
				.orElseThrow(() -> new RecursoNoEncontradoException(barrioId, "Barrio"));
		barrio.setDeleted(true);
		barrioRepository.save(barrio);		
	}

}
