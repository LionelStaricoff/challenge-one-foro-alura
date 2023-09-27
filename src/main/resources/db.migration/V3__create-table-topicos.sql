
create table topicos(

    topico_id int not null auto_increment,
    titulo varchar(100) not null unique,
    mensaje varchar(250) not null unique,
    fecha_creacion date not null,
    status varchar(100) not null,
    usuario_id long not null,
    curso_id long not null

    primary key(topico_id)

    constraint fk_topicos_usuario_id foreign key(usuario_id) references usuarios(usuario_id),
    constraint fk_topicos_curso_id foreign key(curso_id) references cursos(curso_id)
);
