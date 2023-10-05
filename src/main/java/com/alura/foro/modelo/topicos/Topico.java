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

	@Column(name = "titulo")
	private String titulo;

	@Column(name = "mensaje")
	private String mensaje;

	@Column(name = "fecha_creacion")
	private LocalDateTime fechaCreacion = LocalDateTime.now();

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private StatusTopico status = StatusTopico.NO_RESPONDIDO;


	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_id", referencedColumnName = "id")
	private Usuario autor;


	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "curso_id", referencedColumnName = "id")
	private Curso curso;


	@OneToMany(mappedBy = "topico", cascade = CascadeType.ALL)
	private List<Respuesta> respuestas = new ArrayList<>();


	public Topico(DatosRegistrarTopicos datosRegistrarTopicos) {
		this.titulo = datosRegistrarTopicos.titulo();
		this.mensaje = datosRegistrarTopicos.mensaje();
		this.autor = new Usuario(datosRegistrarTopicos.autor());
		this.curso = new Curso(datosRegistrarTopicos.curso());
	}
}
