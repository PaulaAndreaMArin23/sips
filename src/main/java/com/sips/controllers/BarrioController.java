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

import com.sips.dto.respuestaDto.BarrioRespuestaDto;
import com.sips.dto.solicitudDto.BarrioSolicitudDto;
import com.sips.services.BarrioService;

@RestController
@RequestMapping("/barrios")
public class BarrioController {
	
	@Autowired
	private BarrioService barrioService;
	
	@GetMapping
	public ResponseEntity<List<BarrioRespuestaDto>> mostrarBarrios(){
		return ResponseEntity.ok(barrioService.mostrarBarrios());
	}
	
	@GetMapping("/{barrioId}")
	public ResponseEntity<BarrioRespuestaDto> obtenerBarrioPorId(@PathVariable("barrioId") Long barrioId){
		return ResponseEntity.ok(barrioService.obtenerBarrioPorId(barrioId));
	}
	
	@PostMapping
	public ResponseEntity<BarrioRespuestaDto> guardarBarrio(@RequestBody BarrioSolicitudDto barrioSolicitudDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(barrioService.crearBarrio(barrioSolicitudDto));
	}
	
	@PutMapping("/{barrioId}")
	public ResponseEntity<BarrioRespuestaDto> actualizarBarrio(@PathVariable("barrioId") Long barrioId,
			@RequestBody BarrioSolicitudDto barrioSolicitudDto) {
		return ResponseEntity.status(HttpStatus.OK).body(barrioService.actualizarBarrio(barrioId, barrioSolicitudDto));
	}

	@DeleteMapping("/{barrioId}")
	public ResponseEntity<Void> eliminarQueja(@PathVariable("barrioId") Long barrioId) {
		barrioService.eliminarBarrio(barrioId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
