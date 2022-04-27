package com.sips.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sips.dto.respuestaDto.QuejaRespuestaDto;
import com.sips.dto.solicitudDto.QuejaSolicitudDto;

@Service
public interface QuejaService {

	public List<QuejaRespuestaDto> mostrarQuejas();
	public QuejaRespuestaDto obtenerQuejaPorId(Long quejaId);
	public QuejaRespuestaDto crearQueja(QuejaSolicitudDto quejaSolicitudDto);
	public QuejaRespuestaDto actualizarQueja(Long quejaId, QuejaSolicitudDto quejaSolicitudDto);
	public void eliminarQueja(Long quejaId);
	
}
