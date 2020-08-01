CREATE TABLE if not exists proyecto_final.usuarios  (
	id int not null auto_increment, 
	user varchar(200) not null,
	password varchar(30) not null,
	ultima_modificacion DATETIME,
	primary key (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;

insert into usuarios values ('admin','admin');