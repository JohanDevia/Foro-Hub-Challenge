package com.forohub.aluraforo.respuesta;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record DatosRespuesta(

				@NotBlank
				String topico,

				@NotBlank
				String mensaje,

				LocalDateTime fechaCreacion,

				@NotBlank
				String autor,

				@NotBlank
				String solucion
) {

}
