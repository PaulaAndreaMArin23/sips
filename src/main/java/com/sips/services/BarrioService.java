package com.sips.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sips.dto.respuestaDto.BarrioRespuestaDto;
import com.sips.dto.solicitudDto.BarrioSolicitudDto;

@Service
public interface BarrioService {

	public List<BarrioRespuestaDto> mostrarBarrios();
	public BarrioRespuestaDto obtenerBarrioPorId(Long id);
	public BarrioRespuestaDto crearBarrio(BarrioSolicitudDto barrioSolicitudDto);
	public BarrioRespuestaDto actualizarBarrio(Long barrioId, BarrioSolicitudDto barrioSolicitudDto);
	public void eliminarBarrio(Long barrioId);
	
}
