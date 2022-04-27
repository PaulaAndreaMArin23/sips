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

import com.sips.dto.respuestaDto.TipoMultaRespuestaDto;
import com.sips.dto.solicitudDto.TipoMultaSolicitudDto;
import com.sips.services.TipoMultaService;

@RestController
@RequestMapping("/tipomulta")
public class TipoMultaController {
	
	@Autowired
	private TipoMultaService tipomultaService;
	
	@GetMapping
	public ResponseEntity<List<TipoMultaRespuestaDto>> mostrarTipoMulta(){
		return ResponseEntity.ok(tipomultaService.mostrarTipoMulta());
	}
	
	@GetMapping("/{multaId}")
	public ResponseEntity<TipoMultaRespuestaDto> obtenerTipoMultaPorId(@PathVariable("tipomultaId") Long tipomultaId){
		return ResponseEntity.ok(tipomultaService.obtenerTipoMultaPorId(tipomultaId));
	}
	
	@PostMapping
	public ResponseEntity<Object> guardarMulta(@RequestBody TipoMultaSolicitudDto tipomultaSolicitudDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(tipomultaService.crearTipoMulta(tipomultaSolicitudDto));
	}
	
	@PutMapping("/{multaId}")
	public ResponseEntity<TipoMultaRespuestaDto> actualizarMulta(@PathVariable("tipomultaId") Long tipomultaId,
			@RequestBody TipoMultaSolicitudDto tipomultaSolicitudDto) {
		return ResponseEntity.status(HttpStatus.OK).body(tipomultaService.actualizarTipoMulta(tipomultaId, tipomultaSolicitudDto));
	}

	@DeleteMapping("/{multaId}")
	public ResponseEntity<Void> eliminarQueja(@PathVariable("multaId") Long tipomultaId) {
		tipomultaService.eliminarTipoMulta(tipomultaId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}

