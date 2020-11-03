create database medic CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
use medic;
create table paciente (
	cod_pac varchar(10) primary key,
	nombres varchar(200) not null,
	apellidos varchar(200) not null,
	tipoDoc char(1) not null,
	numDoc varchar(200) not null,
	ubigeo int,
	direccion varchar(500),
	sexo char(1),
	foto varchar(1000),
	fechaNaci date not null,
	email varchar(500) not null,
	password varchar(100) not null
);

create table medico (
	cod_med varchar(10) primary key,
	nombres varchar(200) not null,
	apellidos varchar(200) not null,
	tipoDoc char(1) not null,
	numDoc varchar(200) not null,
	estado char(1) not null,
	ubigeo int,
	direccion varchar(500),
	sexo char(1),
	foto varchar(1000),
	fechaNaci date,
);

create table especialidad (
	cod_esp varchar(10) primary key,
	nombre varchar(100) not null,
	descripcion varchar(1000),
	image varchar(500) not null
);

create table especialidad_medico (
	cod_mir varchar(10) primary key,
	cod_med varchar(10) not null,
	cod_esp varchar(10) not null,

	foreign key (cod_med) references medico(cod_med),
	foreign key (cod_esp) references especialidad(cod_esp)
);

create table sala(
	cod_sal varchar(10) primary key,
	piso int not null,
	numero int not null
);

create table cita (
	cod_cit varchar(10) primary key,
	cod_pac varchar(10) not null,
	cod_med varchar(10) not null,
	cod_sal varchar(10) not null,
	estado char(1) not null,
	fecha date not null,
	hora time not null,
	
	foreign key (cod_pac) references paciente(cod_pac),
	foreign key (cod_med) references medico(cod_med),
	foreign key (cod_sal) references sala(cod_sal)
);



