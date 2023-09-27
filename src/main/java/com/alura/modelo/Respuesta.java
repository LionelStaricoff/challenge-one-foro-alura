package com.alura.modelo;

import jakarta.persistence.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.time.LocalDateTime;

public class Respuesta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String mensaje;
	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name="topicos_respuestas",
			joinColumns = @JoinColumn(name="respuesta_id"),
			inverseJoinColumns = @JoinColumn(name="topico_id")
	)
	private Topico topico;
	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name="topicos_respuestas",
			joinColumns = @JoinColumn(name="respuesta_id"),
			inverseJoinColumns = @JoinColumn(name="topico_id")
	)
	private LocalDateTime fechaCreacion = LocalDateTime.now();
	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name="topicos_respuestas",
			joinColumns = @JoinColumn(name="respuesta_id"),
			inverseJoinColumns = @JoinColumn(name="usuario_id")
	)
	private Usuario autor;
	private Boolean solucion = false;


}
