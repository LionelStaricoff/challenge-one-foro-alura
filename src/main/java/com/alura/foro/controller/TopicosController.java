package com.alura.foro.controller;

import com.alura.foro.modelo.topicos.DatosRegistrarTopicos;
import com.alura.foro.modelo.topicos.Topico;
import com.alura.foro.modelo.topicos.TopicoRepositori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicoRepositori topicoRepositori;
    @PostMapping
    public void registrarTopico(@RequestBody DatosRegistrarTopicos DatosRegistrarTopicos){

          topicoRepositori.save(new Topico(DatosRegistrarTopicos));

    }
}
