package com.alura.foro.modelo;

import com.alura.foro.modelo.topicos.DatosAutor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "email")
	private String email;
	@Column(name = "contrasenia")
	private String contrasenia;


	public Usuario(DatosAutor autor) {
		this.nombre = autor.nombre();
		this.email = autor.email();
		this.contrasenia = autor.contrasenia();
	}
}
