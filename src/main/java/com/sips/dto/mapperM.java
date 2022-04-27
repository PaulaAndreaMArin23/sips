package com.sips.dto;

import java.util.ArrayList;
import java.util.List;

import com.sips.dto.respuestaDto.MultasRespuestaDto;
import com.sips.dto.respuestaDto.QuejaRespuestaDto;

import com.sips.entities.MultasEntity;
import com.sips.entities.QuejaEntity;


public class mapperM {

	// Pasar un objeto tipo MultasEntity a MultasRespuestaEntity
	public static MultasRespuestaDto MultasRespuestaDto (MultasEntity multasEntity) {
		
		
		MultasRespuestaDto multasRespuestaDto = new MultasRespuestaDto();
		multasRespuestaDto.setId(multasEntity.getId());
		multasRespuestaDto.setDescripcion(multasEntity.getDescripcion());
	
		return multasRespuestaDto;		
	}
	
	// Pasar un objeto tipo lista MultasEntity a una lista tipo MultasRespuestaEntity
	public static List<MultasRespuestaDto> multasAListaMultasRespuestaDto(List<MultasEntity> multas){
		List<MultasRespuestaDto> multasDto = new ArrayList<MultasRespuestaDto>();
		for (MultasEntity multa: multas) {
			multasDto.add(multasARespuestaDto(multa));
		}
		return multasDto;
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
	
	public static MultasRespuestaDto multasARespuestaDto(MultasEntity multa) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}