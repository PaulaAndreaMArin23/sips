package com.sips.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode(of = {
		"fechaQueja",
		"tipoQueja",
		"tipoDocumento",
		"numIdentificacionQuejoso",
		"nombresQuejoso",
		"apellidosQuejoso",
		"direccionQuejoso",
		"numIdentificacionInfractor",
		"nombresInfractor",
		"apellidosInfractor",
		"direccionInfractor",
		"tipoRecepcion",
		"barrioProblema",
		"direccionProblema",
		"fechaAgenda",
		"horaAgenda",
		"descripcionQueja",
		"radicadoQueja"		
})
@Table(name= "quejas")
public class QuejaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@CreationTimestamp
	@Column(name= "fecha_queja")
	private LocalDateTime fechaQueja;
	
	@Column(name= "tipo_queja", length=20)
	private String tipoQueja;
	
	@Column(name= "tipo_documento", length=30)
	private String tipoDocumento;
	
	@Column(name= "num_identificacion_quejoso", length=20)
	private String numIdentificacionQuejoso;
	
	@Column(name= "nombres_quejoso", length=50)
	private String nombresQuejoso;
	
	@Column(name= "apellidos_quejoso", length=50)
	private String apellidosQuejoso;
	
	@Column(name= "direccion_quejoso", length=50)
	private String direccionQuejoso;
	
	@Column(name= "num_identificacion_infractor", length=20)
	private String numIdentificacionInfractor;
	
	@Column(name= "nombres_infractor", nullable = false, length=50)
	private String nombresInfractor;
	
	@Column(name= "apellidos_infractor", length=50)
	private String apellidosInfractor;
	
	@Column(name= "direccion_infractor", length=50)
	private String direccionInfractor;
	
	@Column(name= "tipo_recepcion", length=50)
	private String tipoRecepcion;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "barrio_id")
	private BarrioEntity barrioProblema;
	
	@Column(name= "direccion_problema", length=50)
	private String direccionProblema;
	
	@Column(name= "fecha_agenda")
	private LocalDate fechaAgenda;
	
	@Column(name= "hora_agenda")
	private LocalDateTime horaAgenda;
	
	@Column(name= "descripcion_queja", nullable = false, length=1000)
	private String descripcionQueja;
	
	@Column(name= "radicado_queja")
	private String radicadoQueja;
	
	@CreationTimestamp
	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	@Builder.Default
	private Boolean deleted = Boolean.FALSE;

	public QuejaEntity(LocalDateTime fechaQueja, String tipoQueja, String tipoDocumento,
			String numIdentificacionQuejoso, String nombresQuejoso, String apellidosQuejoso, String direccionQuejoso,
			String numIdentificacionInfractor, String nombresInfractor, String apellidosInfractor,
			String direccionInfractor, String tipoRecepcion, BarrioEntity barrioProblema, String direccionProblema,
			LocalDate fechaAgenda, LocalDateTime horaAgenda, String descripcionQueja, String radicadoQueja, LocalDateTime createdAt, LocalDateTime updatedAt, Boolean deleted) {
		super();
		this.fechaQueja = fechaQueja;
		this.tipoQueja = tipoQueja;
		this.tipoDocumento = tipoDocumento;
		this.numIdentificacionQuejoso = numIdentificacionQuejoso;
		this.nombresQuejoso = nombresQuejoso;
		this.apellidosQuejoso = apellidosQuejoso;
		this.direccionQuejoso = direccionQuejoso;
		this.numIdentificacionInfractor = numIdentificacionInfractor;
		this.nombresInfractor = nombresInfractor;
		this.apellidosInfractor = apellidosInfractor;
		this.direccionInfractor = direccionInfractor;
		this.tipoRecepcion = tipoRecepcion;
		this.barrioProblema = barrioProblema;
		this.direccionProblema = direccionProblema;
		this.fechaAgenda = fechaAgenda;
		this.horaAgenda = horaAgenda;
		this.descripcionQueja = descripcionQueja;
		this.radicadoQueja = radicadoQueja;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deleted = deleted;
	}

}
