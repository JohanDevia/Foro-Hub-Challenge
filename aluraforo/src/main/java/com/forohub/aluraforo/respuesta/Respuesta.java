package com.forohub.aluraforo.respuesta;

import com.forohub.aluraforo.topico.Topico;
import com.forohub.aluraforo.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "respuestas")
@Entity(name = "respuesta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDateTime fechaCreacion;

	@ManyToOne
	@JoinColumn(name = "topico_id", nullable = false)
	private Topico topico;

	@ManyToOne
	@JoinColumn(name = "autor_id", nullable = false)
	private Usuario autor;

	private String mensaje;

	private String solucion;

	public Respuesta(DatosRespuesta datosRespuesta, Topico topico, Usuario autor) {
		this.fechaCreacion = datosRespuesta.fechaCreacion() != null ? datosRespuesta.fechaCreacion() : LocalDateTime.now();
		this.topico = topico;
		this.autor = autor;
		this.mensaje = datosRespuesta.mensaje();
		this.solucion = datosRespuesta.solucion();
	}
}
