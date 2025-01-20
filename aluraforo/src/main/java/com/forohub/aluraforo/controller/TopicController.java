package com.forohub.aluraforo.controller;

import com.forohub.aluraforo.curso.Curso;
import com.forohub.aluraforo.curso.CursoRepository;
import com.forohub.aluraforo.topico.DatosTopico;
import com.forohub.aluraforo.topico.DtoListadoTopico;
import com.forohub.aluraforo.topico.Topico;
import com.forohub.aluraforo.topico.TopicoRepository;
import com.forohub.aluraforo.usuario.Usuario;
import com.forohub.aluraforo.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/topicos")
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
	public void RegistrarTopico(@RequestBody @Valid DatosTopico datosTopico){
		Curso curso = cursoRepository.findByNombre(datosTopico.curso())
						.orElseThrow(()-> new RuntimeException("Curso no encontrado" + datosTopico.autor()));

		Usuario autor = usuarioRepository.findByNombre(datosTopico.autor())
						.orElseThrow(() -> new RuntimeException("Usuario no encontrado: " + datosTopico.autor()));


		Topico topico = new Topico(datosTopico);
		topico.setCurso(curso);
		topico.setAutor(autor);

		topicoRepository.save(topico);
	}
	@GetMapping
	public List<DtoListadoTopico> listadoTopicos() {
		List<Topico> topicos = topicoRepository.findAll();
		return topicos.stream()
						.map(DtoListadoTopico::new)  // Convertir Topico a DtoListadoTopico
						.collect(Collectors.toList());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Topico> obtenerTopicoPorId(@PathVariable Long id) {
		Optional<Topico> topico = topicoRepository.findById(id);
		if (topico.isPresent()) {
			return ResponseEntity.ok(topico.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
							.body(null);
		}
	}
	@PutMapping("/{id}")
	public ResponseEntity<Topico> actualizarTopico(@PathVariable Long id, @RequestBody DatosTopico datosTopico) {

		Optional<Topico> topicoExistente = topicoRepository.findById(id);
		if (!topicoExistente.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

		Curso curso = cursoRepository.findByNombre(datosTopico.curso())
						.orElseThrow(() -> new RuntimeException("Curso no encontrado: " + datosTopico.curso()));

		Usuario autor = usuarioRepository.findByNombre(datosTopico.autor())
						.orElseThrow(() -> new RuntimeException("Usuario no encontrado: " + datosTopico.autor()));

		Topico topico = topicoExistente.get();

		topico.setTitulo(datosTopico.titulo());
		topico.setMensaje(datosTopico.mensaje());
		topico.setStatus(datosTopico.status());
		topico.setCurso(curso);
		topico.setAutor(autor);

		topicoRepository.save(topico);

		return ResponseEntity.ok(topico);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {
		Optional<Topico> topicoExistente = topicoRepository.findById(id);

		if (!topicoExistente.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		topicoRepository.deleteById(id);

		return ResponseEntity.noContent().build();
	}

}
