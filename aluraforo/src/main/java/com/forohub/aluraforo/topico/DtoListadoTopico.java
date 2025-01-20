package com.forohub.aluraforo.topico;

import java.time.LocalDateTime;

public record DtoListadoTopico(
				String titulo,
				String mensaje,
				LocalDateTime fechaCreacion,
				String status,
				String autor,
				String curso
){
    public DtoListadoTopico(Topico topico) {
			this(
							topico.getTitulo(),
							topico.getMensaje(),
							topico.getFechaCreacion(),
							topico.getStatus(),
							topico.getAutor().getNombre(),  // Obtener solo el nombre del autor
							topico.getCurso().getNombre()   // Obtener solo el nombre del curso
			);
		}

}
