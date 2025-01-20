package com.forohub.aluraforo.curso;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Table(name = "cursos")
@Entity(name = "curso")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "El nombre no debe estar vacío")
	private String nombre; // nombre del curso no del ususario

	@NotBlank(message = "La categoría no debe estar vacía")
	private String categoria;
	public Curso() {}

	public Curso(DatosCurso datosCurso) {
		this.nombre = datosCurso.nombre();
		this.categoria = datosCurso.categoria();
	}
	public String getNombre() {
		return nombre;
	}
	public String getCategoria() {
		return categoria;
	}
}
