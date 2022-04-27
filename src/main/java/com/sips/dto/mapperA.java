package com.sips.dto;

import java.util.ArrayList;
import java.util.List;

import com.sips.dto.respuestaDto.ArticuloRespuestaDto;

import com.sips.dto.respuestaDto.QuejaRespuestaDto;
import com.sips.entities.ArticuloEntity;

import com.sips.entities.QuejaEntity;

public class mapperA {

	// Pasar un objeto tipo BarrioEntity a BarrioRespuestaEntity
	public static ArticuloRespuestaDto articuloARespuestaDto(ArticuloEntity articuloEntity) {
		ArticuloRespuestaDto articuloRespuestaDto = new ArticuloRespuestaDto();
		
		articuloRespuestaDto.setId(articuloEntity.getId());
		articuloRespuestaDto.setDescripcion(articuloEntity.getDescrpicion());
		articuloRespuestaDto.setCod_articulo(articuloEntity.getCod_articulo());
	
		return articuloRespuestaDto;		
	}
	
	// Pasar un objeto tipo lista BarrioEntity a una lista tipo BarrioRespuestaEntity
	public static List<ArticuloRespuestaDto> articuloAListaArticuloRespuestaDto(List<ArticuloEntity> articulo){
		List<ArticuloRespuestaDto> articuloDto = new ArrayList<ArticuloRespuestaDto>();
		for (ArticuloEntity articulo1: articulo) {
			articuloDto.add(articuloARespuestaDto(articulo1));
		}
		return articuloDto;
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
