/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  sary
 * Created: May 8, 2018
 */

create table libro(
    id serial primary key,
    titolo varchar(100) not null,
    autore varchar(100),
    casa_editrice varchar(100)
);


create table biblioteca(
    id serial primary key,
    nome varchar(100) not null,
    indirizzo varchar(200)
);

create table iscritto(
    id serial primary key,
    nome varchar(100),
    cognome varchar(100),
    email varchar(100) not null,
    residenza varchar(200),
    n_ammonizioni integer,
    n_prestiti integer
);

create table bibliotecario(
    id serial primary key,
    nome varchar(100),
    cognome varchar(100),
    email varchar(100) not null,
    residenza varchar(200),
    id_biblioteca bigint unsigned references biblioteca(id) on update cascade 
                                                            on delete set null
);


create table iscrizione(
    id_biblioteca bigint unsigned references biblioteca(id) on update cascade 
                                                            on delete set null,
    id_iscritto bigint unsigned references iscritto(id) on update cascade 
                                                            on delete set null,
    
    data_iscrizione date,
    primary key(id_biblioteca, id_iscritto)
);

create table registro(
    id_libro bigint unsigned references libro(id) on update cascade 
                                                            on delete set null,
    id_iscritto bigint unsigned references iscritto(id) on update cascade 
                                                            on delete set null,
    data_inizio date,                                                            
    data_fine date,
    primary key(id_libro, id_iscritto, data_inizio)
);


insert into libro values (default, 'Bellissimo libro', 'Sara', 'Mondadori');

insert into iscritto values(default, 'Sara', 'Casti', 'sara@gmail.com', 
'via Ospedale 72', 0, 0);

select * from iscrizione;

insert into biblioteca values (default, 'BibliotecaNuova', 'via Roma 18');

insert into iscrizione values(1,1,'2018-05-08');

select biblioteca.nome, iscritto.nome, iscrizione.data_iscrizione
from biblioteca, iscrizione, iscritto
where biblioteca.id=iscrizione.id_biblioteca and 
      iscritto.id=iscrizione.id_iscritto;

