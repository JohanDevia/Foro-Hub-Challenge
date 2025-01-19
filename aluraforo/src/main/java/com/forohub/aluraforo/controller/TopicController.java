package com.forohub.aluraforo.controller;


import com.forohub.aluraforo.curso.Curso;
import com.forohub.aluraforo.curso.CursoRepository;
import com.forohub.aluraforo.topico.DatosTopico;
import com.forohub.aluraforo.topico.Topico;
import com.forohub.aluraforo.topico.TopicoRepository;
import com.forohub.aluraforo.usuario.Usuario;
import com.forohub.aluraforo.usuario.UsuarioRepository;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class TopicController {

	@Autowired
	private TopicoRepository topicoRepository;

	@Autowired
	private CursoRepository cursoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@PostMapping
	public void RegistrarTopico(DatosTopico datosTopico){
		Curso curso = cursoRepository.findByNombre(datosTopico.curso())
						.orElseThrow(()-> new RuntimeException("Curso no encontrado" + datosTopico.autor()));

		Usuario autor = usuarioRepository.findByNombre(datosTopico.autor())
						.orElseThrow(() -> new RuntimeException("Usuario no encontrado: " + datosTopico.autor()));


		Topico topico = new Topico(datosTopico);
		topico.setCurso(curso);
		topico.setAutor(autor);

		topicoRepository.save(topico);
	}

}
