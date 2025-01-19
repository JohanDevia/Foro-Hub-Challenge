package com.forohub.aluraforo.curso;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "cursos")
@Entity(name = "curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String nombre; // nombre del curso no del ususario

	@NotBlank
	private String categoria;

	public Curso(DatosCurso datosCurso) {
		this.nombre = datosCurso.nombre();
		this.categoria = datosCurso.categoria();
	}
}
