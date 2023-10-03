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
	private String nombre;
	private String email;
	private String contrasena;


	public Usuario(DatosAutor autor) {
		this.nombre = autor.nombre();
		this.email = autor.email();
		this.contrasena = autor.contrasenia();
	}
}
