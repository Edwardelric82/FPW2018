/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Sary
 * Created: 14-mag-2018
 */

create table utente (
    id serial primary key,
    nome varchar(100),
    cognome varchar(100),
    email varchar(100) not null,
    password varchar(100) not null,
    urlImg varchar(100)
);

create table notizia(
    id serial primary key,
    titolo varchar(200) not null,
    content varchar(2000), 
    img varchar(100),
    autore bigint unsigned references utente(id) on delete cascade
                                                 on update cascade,
    categoria integer
);

create table commenti(
    id serial primary key,
    id_utente bigint unsigned references utente(id) on delete cascade 
                                                    on update cascade,
    id_notizia bigint unsigned references notizia(id) on delete cascade 
                                                      on update cascade,
    titolo varchar(100) not null, 
    testo varchar(2000),
    data_commento date
);


insert into utente values(default, 'Sara', 'Casti', 'sara@gmail.com', 'sarapsw', '');
insert into utente values(default, 'Paolo', 'Boi', 'boi@gmail.com', 'boi98', 'www.google.it');
insert into utente values(default, 'Carlo', 'Dessi', 'dessi@gmail.com', 'pswdessi', 'www.google.it');


select * from utente;