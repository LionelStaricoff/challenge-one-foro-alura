CREATE DATABASE IF NOT EXISTS api_alura
 DEFAULT CHARACTER SET UTF8 COLLATE UTF8_SPANISH_CI;


USE api_alura;


CREATE TABLE IF NOT EXISTS usuarios(

    id int not null auto_increment,
    nombre varchar(100) not null,
   email varchar(100) not null,
   contrasenia varchar(100) not null,

    primary key(id)


);

CREATE TABLE IF NOT EXISTS cursos(

    id int not null auto_increment,
    nombre varchar(100) not null,
    categoria varchar(100) not null,

    primary key(id)

);

CREATE TABLE IF NOT EXISTS respuestas(

    id int not null auto_increment,
    mensaje varchar(250) not null,
    solucion bit not null,

    primary key(id)

);

CREATE TABLE IF NOT EXISTS topicos(

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

SELECT * FROM topicos;
SELECT * FROM cursos ;
SELECT * FROM respuestas;
SELECT * FROM usuarios ;


/*consultando datos: */
SELECT t.titulo,t.mensaje,t.fecha_creacion,t.`status`,u.nombre,u.email,u.contrasenia,c.nombre,c.categoria FROM topicos t
INNER JOIN usuarios u ON u.id = t.usuario_id
INNER JOIN cursos c ON t.curso_id = c.id WHERE t.id = 7;