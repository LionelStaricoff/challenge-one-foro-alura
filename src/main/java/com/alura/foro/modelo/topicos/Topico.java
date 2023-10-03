package com.alura.foro.modelo.topicos;

import com.alura.foro.modelo.Curso;
import com.alura.foro.modelo.Respuesta;
import com.alura.foro.modelo.Usuario;
import com.alura.foro.modelo.enums.StatusTopico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String mensaje;
	private LocalDateTime fechaCreacion = LocalDateTime.now();
	@Enumerated(EnumType.STRING)
	private StatusTopico status = StatusTopico.NO_RESPONDIDO;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	private Usuario autor;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "curso_id")
	private Curso curso;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "respuesta_id")
	private List<Respuesta> respuestas = new ArrayList<>();


	public Topico(DatosRegistrarTopicos datosRegistrarTopicos) {
		this.titulo = datosRegistrarTopicos.titulo();
		this.mensaje = datosRegistrarTopicos.mensaje();
		this.autor = new Usuario(datosRegistrarTopicos.autor());
		this.curso = new Curso(datosRegistrarTopicos.curso());
	}
}
