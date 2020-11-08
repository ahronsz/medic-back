create database medic CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
use medic;
create table paciente (
	cod_pac varchar(10) primary key,
	nombres varchar(200) not null,
	apellidos varchar(200) not null,
	tipo_doc char(1) not null,
	num_doc varchar(200) not null,
	ubigeo int,
	direccion varchar(500),
	sexo char(1),
	foto varchar(1000),
	fecha_naci date not null,
	email varchar(500) not null,
	password varchar(100) not null
);

create table medico (
	cod_med varchar(10) primary key,
	nombres varchar(200) not null,
	apellidos varchar(200) not null,
	tipo_doc char(1) not null,
	num_doc varchar(200) not null,
	estado char(1) not null,
	ubigeo int,
	direccion varchar(500),
	sexo char(1),
	foto varchar(1000),
	fecha_naci date
);

create table especialidad (
	cod_esp varchar(10) primary key,
	nombre varchar(100) not null,
	descripcion varchar(1000),
	image varchar(500) not null
);
create table hora(
	cod_hor varchar(10) primary key,
	start_hora varchar(5) not null,
	end_hora varchar(5) not null
 );

create table especialidad_medico (
	cod_mir varchar(10) primary key,
	cod_med varchar(10) not null,
	cod_esp varchar(10) not null,
	cod_hor varchar(10) not null,
	estado char(1) not null,

	foreign key (cod_med) references medico(cod_med),
	foreign key (cod_esp) references especialidad(cod_esp),
	foreign key (cod_hor) references hora(cod_hor)
);

create table sala(
	cod_sal varchar(10) primary key,
	piso int not null,
	numero int not null
);

create table cita (
	cod_cit varchar(10) primary key,
	cod_pac varchar(10) not null,
	cod_mir varchar(10) not null,
	cod_sal varchar(10) not null,
	estado char(1) not null,
	fecha date not null,
	hora varchar(5) not null,
	
	foreign key (cod_pac) references paciente(cod_pac),
	foreign key (cod_mir) references especialidad_medico(cod_mir),
	foreign key (cod_sal) references sala(cod_sal)
);

delimiter //
	CREATE PROCEDURE get_code_cit ()
		BEGIN
			IF (SELECT COUNT((select cod_cit from cita limit 1))) THEN
				set @last_cit := (SELECT cod_cit FROM cita ORDER BY CONVERT(SUBSTRING_INDEX(cod_cit, "_", -1), UNSIGNED) DESC LIMIT 1);
				set @last_cit_only_number := (SELECT SUBSTRING_INDEX(@last_cit, "_", -1));
				SELECT CONCAT('cit_', @last_cit_only_number + 1) AS 'cod_cit';
				set @last_cit = null;
				set @last_cit_only_number = null;
			ELSE
				SELECT 'cit_1';
			END IF;
       END//   
delimiter ;

delimiter //
	CREATE PROCEDURE get_code_pac ()
		BEGIN
			IF (SELECT COUNT((select cod_pac from paciente limit 1))) THEN
				set @last_pac := (SELECT cod_pac FROM paciente ORDER BY CONVERT(SUBSTRING_INDEX(cod_pac, "_", -1), UNSIGNED) DESC LIMIT 1);
				set @last_pac_only_number := (SELECT SUBSTRING_INDEX(@last_pac, "_", -1));
				SELECT CONCAT('pac_', @last_pac_only_number + 1) AS 'cod_pac';
				set @last_pac = null;
				set @last_pac_only_number = null;
			ELSE
				SELECT 'pac_1';
			END IF;

       END//   
delimiter ;



