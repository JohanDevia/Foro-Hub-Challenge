package com.forohub.aluraforo.usuario;


public record DtoListadoUsuario(
				String nombre,
				String email
) {
	public DtoListadoUsuario(Usuario usuario){
		this(usuario.getNombre(), usuario.getEmail());
	}
}
