create table usuarios(
    id bigint not null auto_increment,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    contrasena VARCHAR(255) NOT NULL,
    perfiles VARCHAR(100),

    primary key(id)
)