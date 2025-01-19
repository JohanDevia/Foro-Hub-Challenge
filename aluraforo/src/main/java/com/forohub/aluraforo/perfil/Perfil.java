package com.forohub.aluraforo.perfil;

import com.forohub.aluraforo.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Table(name = "perfiles")
@Entity(name = "perfil")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Perfil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String nombre;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;


public Perfil() {}

	public Perfil(Usuario usuario) {
		this.nombre = usuario.getNombre();
		this.usuario = usuario;
	}

}
