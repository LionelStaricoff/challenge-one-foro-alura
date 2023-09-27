
create table topicos_respuestas(

    id int not null auto_increment,
    respuesta_id int not null,

    primary key(id),

    constraint fk_topicos_respuestas_id foreign key(respuesta_id) references respuestas(id)

);
