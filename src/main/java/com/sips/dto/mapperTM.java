package com.sips.dto;

import java.util.ArrayList;
import java.util.List;

import com.sips.dto.respuestaDto.TipoMultaRespuestaDto;

import com.sips.entities.TipoMultaEntity;


public class mapperTM {

	// Pasar un objeto tipo MultasEntity a MultasRespuestaEntity
	public static TipoMultaRespuestaDto TipoMultaRespuestaDto (TipoMultaEntity tipomultaEntity) {
		
		
		TipoMultaRespuestaDto tipomultaRespuestaDto = new TipoMultaRespuestaDto();
		tipomultaRespuestaDto.setId(tipomultaEntity.getId());
		tipomultaRespuestaDto.setDescripcion(tipomultaEntity.getDescripcion());
	
		return tipomultaRespuestaDto;		
	}
	
	// Pasar un objeto tipo lista MultasEntity a una lista tipo MultasRespuestaEntity
	public static List<TipoMultaRespuestaDto> tipomultaAListaMultasRespuestaDto(List<TipoMultaEntity> tipomulta){
		List<TipoMultaRespuestaDto> tipomultaDto = new ArrayList<TipoMultaRespuestaDto>();
		for (TipoMultaEntity Tipomulta: tipomulta) {
			tipomultaDto.add(tipomultaARespuestaDto(Tipomulta));
		}
		return tipomultaDto;
	}
	
	public static TipoMultaRespuestaDto tipomultaARespuestaDto(TipoMultaEntity tipomulta) {
		// TODO Auto-generated method stub
		return null;
	}
}