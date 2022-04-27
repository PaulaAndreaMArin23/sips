package com.sips.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sips.dto.respuestaDto.MultasRespuestaDto;
import com.sips.dto.solicitudDto.MultasSolicitudDto;

@Service
public interface MultasService {
	public List<MultasRespuestaDto> mostrarMultas();
	public MultasRespuestaDto obtenerMultasPorId(Long multasId);
	public Object crearMultas(MultasSolicitudDto multaSolicitudDto);
	public MultasRespuestaDto actualizarMultas(Long multaId, MultasSolicitudDto multaSolicitudDto);
	public void eliminarMultas(Long multasId);
	

}
