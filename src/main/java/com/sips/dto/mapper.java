package com.sips.dto;

import java.util.ArrayList;
import java.util.List;

import com.sips.dto.respuestaDto.BarrioRespuestaDto;

import com.sips.dto.respuestaDto.QuejaRespuestaDto;
import com.sips.entities.BarrioEntity;

import com.sips.entities.QuejaEntity;

public class mapper {

	// Pasar un objeto tipo BarrioEntity a BarrioRespuestaEntity
	public static BarrioRespuestaDto barrioARespuestaDto(BarrioEntity barrioEntity) {
		BarrioRespuestaDto barrioRespuestaDto = new BarrioRespuestaDto();
		
		barrioRespuestaDto.setId(barrioEntity.getId());
		barrioRespuestaDto.setNombre(barrioEntity.getNombre());
	
		return barrioRespuestaDto;		
	}
	
	// Pasar un objeto tipo lista BarrioEntity a una lista tipo BarrioRespuestaEntity
	public static List<BarrioRespuestaDto> barriosAListaBarriosRespuestaDto(List<BarrioEntity> barrios){
		List<BarrioRespuestaDto> barriosDto = new ArrayList<BarrioRespuestaDto>();
		for (BarrioEntity barrio: barrios) {
			barriosDto.add(barrioARespuestaDto(barrio));
		}
		return barriosDto;
	}
	
	// Pasar un objeto tipo QuejaEntity a QuejaRespuestaEntity
	public static QuejaRespuestaDto quejaARespuestaDto(QuejaEntity quejaEntity) {
		QuejaRespuestaDto quejaRespuestaDto = new QuejaRespuestaDto();
		
		quejaRespuestaDto.setId(quejaEntity.getId());
		quejaRespuestaDto.setFechaQueja(quejaEntity.getFechaQueja());
		quejaRespuestaDto.setTipoQueja(quejaEntity.getTipoQueja());
		quejaRespuestaDto.setTipoDocumento(quejaEntity.getTipoDocumento());
		quejaRespuestaDto.setNumIdentificacionQuejoso(quejaEntity.getNumIdentificacionQuejoso());
		quejaRespuestaDto.setNombresQuejoso(quejaEntity.getNombresQuejoso());
		quejaRespuestaDto.setApellidosQuejoso(quejaEntity.getApellidosQuejoso());
		quejaRespuestaDto.setDireccionQuejoso(quejaEntity.getDireccionQuejoso());
		quejaRespuestaDto.setNumIdentificacionInfractor(quejaEntity.getNumIdentificacionInfractor());
		quejaRespuestaDto.setNombresInfractor(quejaEntity.getNombresInfractor());
		quejaRespuestaDto.setApellidosInfractor(quejaEntity.getApellidosInfractor());
		quejaRespuestaDto.setDireccionInfractor(quejaEntity.getDireccionInfractor());
		quejaRespuestaDto.setTipoRecepcion(quejaEntity.getTipoRecepcion());
		quejaRespuestaDto.setBarrioProblema(quejaEntity.getBarrioProblema().getNombre());
		quejaRespuestaDto.setDireccionProblema(quejaEntity.getDireccionProblema());
		quejaRespuestaDto.setFechaAgenda(quejaEntity.getFechaAgenda());
		quejaRespuestaDto.setHoraAgenda(quejaEntity.getHoraAgenda());
		quejaRespuestaDto.setDescripcionQueja(quejaEntity.getDescripcionQueja());
		quejaRespuestaDto.setRadicadoQueja(quejaEntity.getRadicadoQueja());
		quejaRespuestaDto.setId(quejaEntity.getId());
		
		return quejaRespuestaDto;
	}
	
	// Pasar un objeto tipo lista QuejaEntity a una lista tipo QuejaRespuestaDto
	public static List<QuejaRespuestaDto> quejasAListaQuejasRespuestaDto(List<QuejaEntity> quejas){
		List<QuejaRespuestaDto> quejasDto = new ArrayList<QuejaRespuestaDto>();
		for (QuejaEntity queja: quejas) {
			quejasDto.add(quejaARespuestaDto(queja));
		}
		return quejasDto;
	}



	
	
}