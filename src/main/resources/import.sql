insert into role(nom) values('admin');
insert into role(nom) values('user');

insert into country(nom) values('france');
insert into country(nom) values('allemange');

insert into user(username, nom, prenom, id_country, id_role) values('sylvain.mars', 'mars', 'sylvain', 1, 1);

commit;