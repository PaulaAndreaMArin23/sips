package com.sips.services.implementaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sips.dto.mapperTM;
import com.sips.dto.respuestaDto.TipoMultaRespuestaDto;

import com.sips.dto.solicitudDto.TipoMultaSolicitudDto;
import com.sips.entities.TipoMultaEntity;
import com.sips.exceptions.RecursoNoEncontradoException;
import com.sips.repositories.TipoMultaRepository;
import com.sips.services.TipoMultaService;

@Service
public class TipoMultaServiceImpl implements TipoMultaService{
	
	@Autowired
	private TipoMultaRepository tipomultaRepository;

	@Override
	public List<TipoMultaRespuestaDto> mostrarTipoMulta() {
		List<TipoMultaEntity> tipomulta = tipomultaRepository.findAll();
		return mapperTM.tipomultaAListaMultasRespuestaDto(tipomulta);
	}

	@Override
	public TipoMultaRespuestaDto obtenerTipoMultaPorId(Long tipomultaId) {
		TipoMultaEntity tipomulta = tipomultaRepository.findById(tipomultaId)
				.orElseThrow(() -> new RecursoNoEncontradoException(tipomultaId, "Tipo Multas"));
		return mapperTM.tipomultaARespuestaDto(tipomulta);
	}

	@Override
	public TipoMultaRespuestaDto crearTipoMulta(TipoMultaSolicitudDto tipomultaSolicitudDto) {
		TipoMultaEntity tipomulta = new TipoMultaEntity();	
		
		tipomulta.setDescripcion(tipomultaSolicitudDto.getDescripcion());
		
		return mapperTM.tipomultaARespuestaDto(tipomultaRepository.save(tipomulta));
	}

	@Override
	public TipoMultaRespuestaDto actualizarTipoMulta(Long tipomultaId, TipoMultaSolicitudDto tipomultaSolicitudDto) {
		TipoMultaEntity tipomulta = tipomultaRepository.findById(tipomultaId)
				.orElseThrow(() -> new RecursoNoEncontradoException(tipomultaId, "Tipo Multa"));
		return mapperTM.tipomultaARespuestaDto(tipomultaRepository.save (tipomulta));
	}

	@Override
	public void eliminarTipoMulta(Long tipomultaId) {
		TipoMultaEntity tipomulta = tipomultaRepository.findById(tipomultaId)
				.orElseThrow(() -> new RecursoNoEncontradoException(tipomultaId, "Tipo Multas"));
		tipomulta.setDeleted(true);
		tipomultaRepository.save(tipomulta);		
	}


	
}
