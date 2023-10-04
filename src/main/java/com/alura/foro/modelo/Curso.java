package com.alura.foro.modelo;

import com.alura.foro.modelo.enums.CategoriasCursos;
import com.alura.foro.modelo.topicos.RegistrarCurso;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "cursos")
@Entity(name = "Curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "categoria")
	@Enumerated(EnumType.STRING)
	private CategoriasCursos categoria;


	public Curso(RegistrarCurso curso) {
		this.nombre = curso.nombre();
		this.categoria = curso.categoria();
	}
}
