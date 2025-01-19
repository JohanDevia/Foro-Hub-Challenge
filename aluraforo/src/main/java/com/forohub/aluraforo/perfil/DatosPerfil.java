package com.forohub.aluraforo.perfil;

import com.forohub.aluraforo.usuario.DatosUsuario;
import jakarta.validation.constraints.NotBlank;

public record DatosPerfil(

				@NotBlank
				String nombre
) {
	public DatosPerfil(DatosUsuario usuario){
		this(usuario.nombre());
	}


}
