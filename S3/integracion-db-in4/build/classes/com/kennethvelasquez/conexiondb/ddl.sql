drop database if exists gestor_usuarios_in4am;
create database gestor_usuarios_in4am;
use gestor_usuarios_in4am;

create table Usuario(
	nombres varchar(70) not null,
    apellidos varchar(70) not null,
    nombre_usuario varchar(50) not null,
    clave varchar(20) not null,
    rol varchar(25) not null,
    id_usuario varchar(70) not null,
    primary key (id_usuario)
);

delimiter $$
	create procedure sp_create_usuario(in nombres_p varchar(70),
									   in apellidos_P varchar(70),
                                       in nombre_usuario_p varchar(50),
                                       in clave_p varchar(20),
                                       in rol_p varchar(25))
    begin
		insert into Usuario(id_usuario, nombres, apellidos, nombre_usuario, clave, rol)
			values(uuid(), nombres_p, apellidos_p, nombre_usuario_p, clave_p, rol_p );
    end$$
delimiter ;

delimiter $$
	create procedure sp_read_usuarios()
    begin
		select * from Usuario;
    end$$
delimiter ;


create table Registro_Resultados(
	id_registro_resultados int auto_increment,
    primary key (id_registro_resultados),
    resultado decimal(10,2),
    usuario varchar(25) not null
);

delimiter $$
	create procedure sp_create_registro_resultado(in resultado_p decimal(10,2),
												  in usuario_p varchar(25) )
	begin
		insert into Registro_Resultados(resultado, usuario)
			values(resultado_p, usuario_p);
    end$$
delimiter ;








