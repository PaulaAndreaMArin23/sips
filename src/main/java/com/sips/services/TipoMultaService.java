package com.sips.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sips.dto.respuestaDto.TipoMultaRespuestaDto;
import com.sips.dto.solicitudDto.TipoMultaSolicitudDto;

@Service
public interface TipoMultaService {
	public List<TipoMultaRespuestaDto> mostrarTipoMulta();
	public TipoMultaRespuestaDto obtenerTipoMultaPorId(Long tipomultaId);
	public Object crearTipoMulta(TipoMultaSolicitudDto tipomultaSolicitudDto);
	public TipoMultaRespuestaDto actualizarTipoMulta(Long tipomultaId, TipoMultaSolicitudDto tipomultaSolicitudDto);
	public void eliminarTipoMulta(Long TipomultaId);
	
	

}