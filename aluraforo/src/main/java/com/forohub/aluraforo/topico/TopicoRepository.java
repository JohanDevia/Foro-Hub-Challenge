package com.forohub.aluraforo.topico;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
	Optional<Topico> findByTitulo(String titulo);
}
