package com.forohub.aluraforo.curso;

public record DtoListadoCurso(
				String nombre,
        String categoria)
{
	public DtoListadoCurso(Curso curso){
		this(curso.getNombre(), curso.getCategoria());
	}
}
