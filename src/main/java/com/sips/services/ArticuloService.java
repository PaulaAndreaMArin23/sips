package com.sips.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sips.dto.respuestaDto.ArticuloRespuestaDto;
import com.sips.dto.solicitudDto.ArticuloSolicitudDto;

@Service
public interface ArticuloService {

	public List<ArticuloRespuestaDto> mostrarArticulos();
	public ArticuloRespuestaDto obtenerArticuloPorId(Long id);
	public ArticuloRespuestaDto crearArticulo(ArticuloSolicitudDto articuloSolicitudDto);
	public ArticuloRespuestaDto actualizarArticulo(Long articuloId, ArticuloSolicitudDto articuloSolicitudDto);
	public void eliminarArticulo(Long articuloId);
	
	
	
}
