package com.sips.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sips.dto.respuestaDto.ArticuloRespuestaDto;
import com.sips.dto.solicitudDto.ArticuloSolicitudDto;
import com.sips.services.ArticuloService;

@RestController
@RequestMapping("/Articulo")
public class ArticuloController {
	
	@Autowired
	private ArticuloService articuloService;
	
	@GetMapping
	public ResponseEntity<List<ArticuloRespuestaDto>> mostrarArticulos(){
		return ResponseEntity.ok(articuloService.mostrarArticulos());
	}
	
	@GetMapping("/{articuloId}")
	public ResponseEntity<ArticuloRespuestaDto> obtenerArticuloPorId(@PathVariable("articuloId") Long articuloId){
		return ResponseEntity.ok(articuloService.obtenerArticuloPorId(articuloId));
	}
	
	@PostMapping
	public ResponseEntity<ArticuloRespuestaDto> guardarArticulo(@RequestBody ArticuloSolicitudDto articuloSolicitudDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(articuloService.crearArticulo(articuloSolicitudDto));
	}
	
	@PutMapping("/{articuloId}")
	public ResponseEntity<ArticuloRespuestaDto> actualizarArticulo(@PathVariable("articuloId") Long articuloId,
			@RequestBody ArticuloSolicitudDto articuloSolicitudDto) {
		return ResponseEntity.status(HttpStatus.OK).body(articuloService.actualizarArticulo(articuloId, articuloSolicitudDto));
	}

	@DeleteMapping("/{articuloId}")
	public ResponseEntity<Void> eliminarQueja(@PathVariable("articuloId") Long articuloId) {
		articuloService.eliminarArticulo(articuloId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}