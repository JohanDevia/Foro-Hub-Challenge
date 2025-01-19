package com.forohub.aluraforo.curso;

import jakarta.validation.constraints.NotBlank;

public record DatosCurso(

				@NotBlank
				String nombre,


				String categoria
) {

}
