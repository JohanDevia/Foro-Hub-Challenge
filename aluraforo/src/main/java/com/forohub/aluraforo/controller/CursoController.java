package com.forohub.aluraforo.controller;

import com.forohub.aluraforo.curso.Curso;
import com.forohub.aluraforo.curso.CursoRepository;
import com.forohub.aluraforo.curso.DatosCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cursos")
public class CursoController {

	@Autowired
	private CursoRepository cursoRepository;

	@PostMapping
	public  void registrarCurso(DatosCurso datosCurso) {
		Curso curso = new Curso(datosCurso);
		cursoRepository.save(curso);
	}
}
