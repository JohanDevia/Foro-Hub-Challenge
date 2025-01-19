package com.forohub.aluraforo.controller;

import com.forohub.aluraforo.respuesta.DatosRespuesta;
import com.forohub.aluraforo.respuesta.Respuesta;
import com.forohub.aluraforo.respuesta.RespuestaRepository;
import com.forohub.aluraforo.topico.Topico;
import com.forohub.aluraforo.topico.TopicoRepository;
import com.forohub.aluraforo.usuario.Usuario;
import com.forohub.aluraforo.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

	@Autowired
	private RespuestaRepository respuestaRepository;

	@Autowired
	private TopicoRepository topicoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	public void registrarRespuesta(DatosRespuesta datosRespuesta) {

		Topico topico = topicoRepository.findByTitulo(datosRespuesta.topico())
						.orElseThrow(() -> new RuntimeException("Tópico no encontrado: " + datosRespuesta.topico()));

		Usuario autor = usuarioRepository.findByNombre(datosRespuesta.autor())
						.orElseThrow(() -> new RuntimeException("Usuario no encontrado: " + datosRespuesta.autor()));

		Respuesta respuesta = new Respuesta(datosRespuesta, topico, autor);

		respuestaRepository.save(respuesta);
	}

}
