
create table usuarios(

    usuario_id int not null auto_increment,
    nombre varchar(100) not null,
   email varchar(100) not null,
   contrasenia varchar(100) not null

    primary key(usuario_id)


);