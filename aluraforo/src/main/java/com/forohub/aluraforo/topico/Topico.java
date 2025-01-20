package com.forohub.aluraforo.topico;

import com.forohub.aluraforo.curso.Curso;
import com.forohub.aluraforo.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "topico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String titulo;

	@NotBlank
	private  String mensaje;

	private LocalDateTime fechaCreacion;

	private String status;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "autor_id", nullable = false)
	private Usuario autor;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "curso_id", nullable = false)
	private Curso curso;

	@PrePersist
	public void asignarFechaCreacion(){
		this.fechaCreacion = LocalDateTime.now();
	}

	public Topico(){}

	public Topico(DatosTopico datosTopico) {
		this.titulo = datosTopico.titulo();
		this.mensaje = datosTopico.mensaje();
		this.fechaCreacion = datosTopico.fechaCreacion();
		this.status = datosTopico.status();
	}
	public void setAutor(Usuario autor) {
		this.autor = autor;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public String getStatus() {
		return status;
	}

	public Usuario getAutor() {
		return autor;
	}

	public Curso getCurso() {
		return curso;
	}
}
