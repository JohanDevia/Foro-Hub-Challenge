package com.forohub.aluraforo.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosUsuario(

				@NotBlank
				String nombre,

				@NotBlank
								@Email
				String email,

				@NotBlank
				String contrasena,

				String perfiles
) {
}
