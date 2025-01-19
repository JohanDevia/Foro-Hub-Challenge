package com.forohub.aluraforo.topico;

import com.forohub.aluraforo.curso.Curso;
import com.forohub.aluraforo.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "topico")
@Getter
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

	@ManyToOne
	@JoinColumn(name = "autor_id", nullable = false)
	private Usuario autor;

	@ManyToOne
	@JoinColumn(name = "curso_id", nullable = false)
	private Curso curso;


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
}
