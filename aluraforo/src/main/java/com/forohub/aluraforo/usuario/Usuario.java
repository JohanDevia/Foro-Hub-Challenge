package com.forohub.aluraforo.usuario;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "usuarios")
@Entity(name = "usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String email;
	private String contrasena;
	private String perfiles;

	public Usuario(DatosUsuario datosUsuario) {
		this.nombre = datosUsuario.nombre();
		this.email = datosUsuario.email();
		this.contrasena = datosUsuario.contrasena();
		this.perfiles = datosUsuario.perfiles();
	}

	public String getNombre() {
		return nombre;
	}

}
