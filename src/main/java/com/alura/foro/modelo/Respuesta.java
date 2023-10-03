package com.alura.foro.modelo;

import com.alura.foro.modelo.topicos.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "respuestas")
@Entity(name = "Respuesta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String mensaje;
	@OneToMany(mappedBy="respuestas")
	private Topico topico;
	private LocalDateTime fechaCreacion = LocalDateTime.now();
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	private Usuario autor;
	private Boolean solucion = false;





}
