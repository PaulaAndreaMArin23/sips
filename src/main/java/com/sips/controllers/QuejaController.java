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

import com.sips.dto.respuestaDto.QuejaRespuestaDto;
import com.sips.dto.solicitudDto.QuejaSolicitudDto;
import com.sips.services.QuejaService;

@RestController
@RequestMapping("/quejas")
public class QuejaController {
	
	@Autowired
	private QuejaService quejaService;

	@GetMapping
	public ResponseEntity<List<QuejaRespuestaDto>> mostrarQuejas(){
		return ResponseEntity.ok(quejaService.mostrarQuejas());
	}
	
	@GetMapping("/{quejaId}")
	public ResponseEntity<QuejaRespuestaDto> obtenerQuejaPorId(@PathVariable("quejaId") Long quejaId){
		return ResponseEntity.ok(quejaService.obtenerQuejaPorId(quejaId));
	}
	
	@PostMapping
	public ResponseEntity<QuejaRespuestaDto> guardarQueja(@RequestBody QuejaSolicitudDto quejaSolicitudDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(quejaService.crearQueja(quejaSolicitudDto));
	}
	
	@PutMapping("/{quejaId}")
	public ResponseEntity<QuejaRespuestaDto> actualizarQueja(@PathVariable("quejaId") Long quejaId,
			@RequestBody QuejaSolicitudDto quejaSolicitudDto) {
		return ResponseEntity.status(HttpStatus.OK).body(quejaService.actualizarQueja(quejaId, quejaSolicitudDto));
	}

	@DeleteMapping("/{quejaId}")
	public ResponseEntity<Void> eliminarQueja(@PathVariable("quejaId") Long quejaId) {
		quejaService.eliminarQueja(quejaId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
