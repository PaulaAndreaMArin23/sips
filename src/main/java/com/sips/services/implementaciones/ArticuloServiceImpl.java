package com.sips.services.implementaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sips.dto.mapperA;
import com.sips.dto.respuestaDto.ArticuloRespuestaDto;
import com.sips.dto.solicitudDto.ArticuloSolicitudDto;
import com.sips.entities.ArticuloEntity;
import com.sips.exceptions.RecursoNoEncontradoException;
import com.sips.repositories.ArticuloRepository;
import com.sips.services.ArticuloService;

@Service
public class ArticuloServiceImpl implements ArticuloService{
	
	@Autowired
	private ArticuloRepository articuloRepository;

	@Override
	public List<ArticuloRespuestaDto> mostrarArticulos() {
		List<ArticuloEntity> articulos = articuloRepository.findAll();
		return mapperA.articuloAListaArticuloRespuestaDto(articulos);
	}

	@Override
	public ArticuloRespuestaDto obtenerArticuloPorId(Long articuloId) {
		ArticuloEntity articulo = articuloRepository.findById(articuloId)
				.orElseThrow(() -> new RecursoNoEncontradoException(articuloId, "Articulo"));
		return mapperA.articuloARespuestaDto(articulo);
	}

	@Override
	public ArticuloRespuestaDto crearArticulo(ArticuloSolicitudDto articuloSolicitudDto) {
		ArticuloEntity articulo = new ArticuloEntity();	
		
		articulo.setCod_articulo(articuloSolicitudDto.getCod_articulo());
		articulo.setDescrpicion(articuloSolicitudDto.getDescripcion());
		
		return mapperA.articuloARespuestaDto(articuloRepository.save(articulo));
	}

	public ArticuloRespuestaDto actualizarArticulo(Long articuloId, ArticuloSolicitudDto articuloSolicitudDto) {
		ArticuloEntity articulo = articuloRepository.findById(articuloId)
				.orElseThrow(() -> new RecursoNoEncontradoException(articuloId, "Articulo"));
		return mapperA.articuloARespuestaDto(articuloRepository.save(articulo));
	}

	@Override
	public void eliminarArticulo(Long articuloId) {
		ArticuloEntity articulo = articuloRepository.findById(articuloId)
				.orElseThrow(() -> new RecursoNoEncontradoException(articuloId, "Articulo"));
		articulo.setDeleted(true);
		articuloRepository.save(articulo);		
	}
}