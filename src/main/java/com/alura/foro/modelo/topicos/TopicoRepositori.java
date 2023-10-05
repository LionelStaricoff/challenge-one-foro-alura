package com.alura.foro.modelo.topicos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface TopicoRepositori extends JpaRepository<Topico,Long> {
}
