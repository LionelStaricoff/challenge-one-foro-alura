
create table topicos(

    id int not null auto_increment,
    titulo varchar(100) not null unique,
    mensaje varchar(250) not null unique,
    fecha_creacion date not null,
    status varchar(100) not null,
    usuario_id int not null,
    curso_id int not null,
    respuesta_id int not null,

    primary key(id),

    constraint fk_topicos_usuario_id foreign key(usuario_id) references usuarios(id),
    constraint fk_topicos_curso_id foreign key(curso_id) references cursos(id),
    constraint fk_topicos_respuesta_id foreign key(respuesta_id) references respuestas(id)


);