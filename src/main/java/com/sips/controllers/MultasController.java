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

import com.sips.dto.respuestaDto.MultasRespuestaDto;
import com.sips.dto.solicitudDto.MultasSolicitudDto;
import com.sips.services.MultasService;

@RestController
@RequestMapping("/multas")
public class MultasController {
	
	@Autowired
	private MultasService multasService;
	
	@GetMapping
	public ResponseEntity<List<MultasRespuestaDto>> mostrarMultas(){
		return ResponseEntity.ok(multasService.mostrarMultas());
	}
	
	@GetMapping("/{multaId}")
	public ResponseEntity<MultasRespuestaDto> obtenerMultasPorId(@PathVariable("multasId") Long multasId){
		return ResponseEntity.ok(multasService.obtenerMultasPorId(multasId));
	}
	
	@PostMapping
	public ResponseEntity<Object> guardarMulta(@RequestBody MultasSolicitudDto multaSolicitudDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(multasService.crearMultas(multaSolicitudDto));
	}
	
	@PutMapping("/{multaId}")
	public ResponseEntity<MultasRespuestaDto> actualizarMulta(@PathVariable("multaId") Long multaId,
			@RequestBody MultasSolicitudDto multaSolicitudDto) {
		return ResponseEntity.status(HttpStatus.OK).body(multasService.actualizarMultas(multaId, multaSolicitudDto));
	}

	@DeleteMapping("/{multaId}")
	public ResponseEntity<Void> eliminarQueja(@PathVariable("multaId") Long multaId) {
		multasService.eliminarMultas(multaId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}

