package com.sips.dto.solicitudDto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class QuejaSolicitudDto {
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime fechaQueja;
	private String tipoQueja;
	private String tipoDocumento;
	private String numIdentificacionQuejoso;
	private String nombresQuejoso;
	private String apellidosQuejoso;
	private String direccionQuejoso;
	private String numIdentificacionInfractor;
	private String nombresInfractor;
	private String apellidosInfractor;
	private String direccionInfractor;
	private String tipoRecepcion;
	private Long barrioProblema;
	private String direccionProblema;
	private LocalDate fechaAgenda;
	private LocalDateTime horaAgenda;
	private String descripcionQueja;
	private String radicadoQueja;
}
