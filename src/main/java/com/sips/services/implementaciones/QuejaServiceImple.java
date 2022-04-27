package com.sips.services.implementaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sips.dto.mapper;
import com.sips.dto.respuestaDto.QuejaRespuestaDto;
import com.sips.dto.solicitudDto.QuejaSolicitudDto;
import com.sips.entities.BarrioEntity;
import com.sips.entities.QuejaEntity;
import com.sips.exceptions.RecursoNoEncontradoException;
import com.sips.repositories.BarrioRepository;
import com.sips.repositories.QuejaRepository;
import com.sips.services.QuejaService;

@Service
public class QuejaServiceImple implements QuejaService{

	@Autowired
	private QuejaRepository quejaRepository;
	
	@Autowired
	private BarrioRepository barrioRepository;
	
	@Override
	public List<QuejaRespuestaDto> mostrarQuejas() {
		List<QuejaEntity> quejas = quejaRepository.findAll();
		return mapper.quejasAListaQuejasRespuestaDto(quejas);
	}

	@Override
	public QuejaRespuestaDto obtenerQuejaPorId(Long quejaId) {
		QuejaEntity queja = quejaRepository.findById(quejaId)
				.orElseThrow(() -> new RecursoNoEncontradoException(quejaId, "Queja"));
		return mapper.quejaARespuestaDto(quejaRepository.save(queja));
	}

	@Override
	public QuejaRespuestaDto crearQueja(QuejaSolicitudDto quejaSolicitudDto) {
		QuejaEntity queja = new QuejaEntity();
		
		queja.setTipoQueja(quejaSolicitudDto.getTipoQueja());
		queja.setTipoDocumento(quejaSolicitudDto.getTipoDocumento());
		queja.setNumIdentificacionQuejoso(quejaSolicitudDto.getNumIdentificacionQuejoso());
		queja.setNombresQuejoso(quejaSolicitudDto.getNombresQuejoso());
		queja.setApellidosQuejoso(quejaSolicitudDto.getApellidosQuejoso());
		queja.setDireccionQuejoso(quejaSolicitudDto.getDireccionQuejoso());
		queja.setNumIdentificacionInfractor(quejaSolicitudDto.getNumIdentificacionInfractor());
		queja.setNombresInfractor(quejaSolicitudDto.getNombresInfractor());
		queja.setApellidosInfractor(quejaSolicitudDto.getApellidosInfractor());
		queja.setDireccionInfractor(quejaSolicitudDto.getDireccionInfractor());
		queja.setTipoRecepcion(quejaSolicitudDto.getTipoRecepcion());
		
		if (quejaSolicitudDto.getBarrioProblema() == null) {
			throw new IllegalArgumentException("La queja debe tener el barrio donde fue el problema.");
		}		
		BarrioEntity barrio = barrioRepository.findById(quejaSolicitudDto.getBarrioProblema())
				.orElseThrow(() -> new RecursoNoEncontradoException(quejaSolicitudDto.getBarrioProblema(), "Barrio"));
		queja.setBarrioProblema(barrio);
		
		queja.setDireccionProblema(quejaSolicitudDto.getDireccionProblema());
		queja.setFechaAgenda(quejaSolicitudDto.getFechaAgenda());
		queja.setHoraAgenda(quejaSolicitudDto.getHoraAgenda());
		queja.setDescripcionQueja(quejaSolicitudDto.getDescripcionQueja());		
		
		return mapper.quejaARespuestaDto(quejaRepository.save(queja));
	}

	@Override
	public QuejaRespuestaDto actualizarQueja(Long quejaId, QuejaSolicitudDto quejaSolicitudDto) {
		QuejaEntity quejaActual = quejaRepository.findById(quejaId)
				.orElseThrow(() -> new RecursoNoEncontradoException(quejaId, "Queja"));
		
		quejaActual.setTipoQueja(quejaSolicitudDto.getTipoQueja());
		quejaActual.setTipoDocumento(quejaSolicitudDto.getTipoDocumento());
		quejaActual.setNumIdentificacionQuejoso(quejaSolicitudDto.getNumIdentificacionQuejoso());
		quejaActual.setNombresQuejoso(quejaSolicitudDto.getNombresQuejoso());
		quejaActual.setApellidosQuejoso(quejaSolicitudDto.getApellidosQuejoso());
		quejaActual.setDireccionQuejoso(quejaSolicitudDto.getDireccionQuejoso());
		quejaActual.setNumIdentificacionInfractor(quejaSolicitudDto.getNumIdentificacionInfractor());
		quejaActual.setNombresInfractor(quejaSolicitudDto.getNombresInfractor());
		quejaActual.setApellidosInfractor(quejaSolicitudDto.getApellidosInfractor());
		quejaActual.setDireccionInfractor(quejaSolicitudDto.getDireccionInfractor());
		quejaActual.setTipoRecepcion(quejaSolicitudDto.getTipoRecepcion());
		
		if (quejaSolicitudDto.getBarrioProblema() == null) {
			throw new IllegalArgumentException("La queja debe tener el barrio donde fue el problema.");
		}		
		BarrioEntity barrio = barrioRepository.findById(quejaSolicitudDto.getBarrioProblema())
				.orElseThrow(() -> new RecursoNoEncontradoException(quejaSolicitudDto.getBarrioProblema(), "Barrio"));
		quejaActual.setBarrioProblema(barrio);
		
		quejaActual.setDireccionProblema(quejaSolicitudDto.getDireccionProblema());
		quejaActual.setFechaAgenda(quejaSolicitudDto.getFechaAgenda());
		quejaActual.setHoraAgenda(quejaSolicitudDto.getHoraAgenda());
		quejaActual.setDescripcionQueja(quejaSolicitudDto.getDescripcionQueja());
		
		return mapper.quejaARespuestaDto(quejaRepository.save(quejaActual));
	}

	@Override
	public void eliminarQueja(Long quejaId) {
		QuejaEntity quejaEntity = quejaRepository.findById(quejaId)
				.orElseThrow(() -> new RecursoNoEncontradoException(quejaId, "Queja"));
		quejaEntity.setDeleted(true);
		quejaRepository.save(quejaEntity);		
	}

}
