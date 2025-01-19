package com.forohub.aluraforo.controller;

import com.forohub.aluraforo.perfil.Perfil;
import com.forohub.aluraforo.perfil.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

	@Autowired
	private PerfilRepository perfilRepository;

	@GetMapping("/{nombre}")
	public Perfil obtenerPerfil(@PathVariable String nombre){
		return perfilRepository.findByNombre(nombre)
						.orElseThrow(()-> new RuntimeException("perfil no encontrado"));
	}
}
