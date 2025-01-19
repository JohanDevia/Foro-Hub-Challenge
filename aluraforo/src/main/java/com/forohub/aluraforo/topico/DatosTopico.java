package com.forohub.aluraforo.topico;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record DatosTopico(

				@NotBlank
				String titulo,
				@NotBlank
				String mensaje,

				LocalDateTime fechaCreacion,

				String status,
				@NotBlank
				String autor,
				@NotBlank
				String curso,

				String respuestas
) {

}
