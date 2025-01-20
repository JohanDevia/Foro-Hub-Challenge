package com.forohub.aluraforo.controller;

import com.forohub.aluraforo.curso.Curso;
import com.forohub.aluraforo.curso.CursoRepository;
import com.forohub.aluraforo.curso.DatosCurso;
import com.forohub.aluraforo.curso.DtoListadoCurso;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cursos")
public class CursoController {

	@Autowired
	private CursoRepository cursoRepository;

	@PostMapping
	public  void registrarCurso(@RequestBody @Valid DatosCurso datosCurso) {
		Curso curso = new Curso(datosCurso);
		cursoRepository.save(curso);
	}
	@GetMapping
	public List<DtoListadoCurso> dtoListadoCursos() {
		List<Curso> cursos = cursoRepository.findAll();
		return cursos.stream().map(DtoListadoCurso::new).collect(Collectors.toList());
	}
}
