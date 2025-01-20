package com.forohub.aluraforo.controller;

import com.forohub.aluraforo.perfil.Perfil;
import com.forohub.aluraforo.perfil.PerfilRepository;
import com.forohub.aluraforo.usuario.DatosUsuario;
import com.forohub.aluraforo.usuario.DtoListadoUsuario;
import com.forohub.aluraforo.usuario.Usuario;
import com.forohub.aluraforo.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PerfilRepository perfilRepository;


	@PostMapping
	public void registrarUsuario(@RequestBody @Valid DatosUsuario datosUsuario){
		Usuario usuario = new Usuario(datosUsuario);
		usuarioRepository.save(usuario);

		Perfil perfil = new Perfil(usuario);
		perfilRepository.save(perfil);
	}

	@GetMapping
	public List<DtoListadoUsuario> listarUsuarios() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		return usuarios.stream().map(DtoListadoUsuario::new).collect(Collectors.toList());
	}

}
