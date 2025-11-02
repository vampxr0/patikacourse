/*
1. test veritabanınızda employee isimli sütun bilgileri id(INTEGER), name VARCHAR(50), birthday DATE, email VARCHAR(100) olan bir tablo oluşturalım.
*/

create table employee (
	id INT,
	full_name VARCHAR(50),
	birthday DATE
);

-- Oluşturduğumuz employee tablosuna 'Mockaroo' servisini kullanarak 50 adet veri ekleyelim.
insert into employee (id, full_name, birthday) values (1, 'Shanon Maine', '04/01/2019');
insert into employee (id, full_name, birthday) values (2, 'Cyrillus Chupin', '09/18/2016');
insert into employee (id, full_name, birthday) values (3, 'Corrinne Schultes', '02/13/2012');
insert into employee (id, full_name, birthday) values (4, 'Janka Rupprecht', '08/14/1988');
insert into employee (id, full_name, birthday) values (5, 'Doti Dorward', '05/22/2004');
insert into employee (id, full_name, birthday) values (6, 'Renell Brandenberg', '12/15/1995');
insert into employee (id, full_name, birthday) values (7, 'Damian Grebner', '03/30/2017');
insert into employee (id, full_name, birthday) values (8, 'Manon Hanselmann', '12/03/2017');
insert into employee (id, full_name, birthday) values (9, 'Rudyard Eley', '01/18/1984');
insert into employee (id, full_name, birthday) values (10, 'Faunie Blowers', '02/20/2023');
insert into employee (id, full_name, birthday) values (11, 'Othilie Haysham', '01/18/1985');
insert into employee (id, full_name, birthday) values (12, 'Claiborne Lumbley', '12/03/1986');
insert into employee (id, full_name, birthday) values (13, 'Dew Uttley', '08/02/1998');
insert into employee (id, full_name, birthday) values (14, 'Danie Goggey', '12/26/1987');
insert into employee (id, full_name, birthday) values (15, 'Daisi Skoate', '04/24/2015');
insert into employee (id, full_name, birthday) values (16, 'Jerrome Sivier', '03/22/2022');
insert into employee (id, full_name, birthday) values (17, 'Tris O'' Molan', '12/15/1980');
insert into employee (id, full_name, birthday) values (18, 'Wilona Merrigan', '06/22/2019');
insert into employee (id, full_name, birthday) values (19, 'Barnard Blaxley', '05/15/2000');
insert into employee (id, full_name, birthday) values (20, 'Fionnula Richie', '11/01/2004');
insert into employee (id, full_name, birthday) values (21, 'Ethelin Dodsley', '09/08/2007');
insert into employee (id, full_name, birthday) values (22, 'Gail Phizackarley', '07/11/1998');
insert into employee (id, full_name, birthday) values (23, 'Persis Mayte', '11/15/1990');
insert into employee (id, full_name, birthday) values (24, 'Mickie Borth', '09/08/2013');
insert into employee (id, full_name, birthday) values (25, 'Abraham Mettricke', '08/11/1982');
insert into employee (id, full_name, birthday) values (26, 'Harley Cuerdall', '06/29/1985');
insert into employee (id, full_name, birthday) values (27, 'Laural Gulliman', '12/04/2012');
insert into employee (id, full_name, birthday) values (28, 'Bord Kingscote', '02/21/2023');
insert into employee (id, full_name, birthday) values (29, 'Gabriela Dwerryhouse', '08/07/1993');
insert into employee (id, full_name, birthday) values (30, 'Mabelle MacMorland', '04/28/1982');
insert into employee (id, full_name, birthday) values (31, 'Gaby Myford', '06/29/2000');
insert into employee (id, full_name, birthday) values (32, 'Eula Stote', '02/25/1994');
insert into employee (id, full_name, birthday) values (33, 'Verena Hatchard', '12/21/2012');
insert into employee (id, full_name, birthday) values (34, 'Shaine Jindra', '08/15/1990');
insert into employee (id, full_name, birthday) values (35, 'Roze Giamuzzo', '06/13/2009');
insert into employee (id, full_name, birthday) values (36, 'Jarrod Grieg', '10/27/1989');
insert into employee (id, full_name, birthday) values (37, 'Dottie Lutz', '04/10/1989');
insert into employee (id, full_name, birthday) values (38, 'Fee Heys', '05/29/1999');
insert into employee (id, full_name, birthday) values (39, 'Donnamarie Southouse', '06/03/1992');
insert into employee (id, full_name, birthday) values (40, 'Barde Fausset', '01/04/2021');
insert into employee (id, full_name, birthday) values (41, 'Roy Crookston', '05/24/2017');
insert into employee (id, full_name, birthday) values (42, 'Tracey Oels', '08/24/2023');
insert into employee (id, full_name, birthday) values (43, 'Johna Hazley', '04/12/1988');
insert into employee (id, full_name, birthday) values (44, 'Bancroft Doughtery', '11/01/1999');
insert into employee (id, full_name, birthday) values (45, 'Noble Glowinski', '05/15/2003');
insert into employee (id, full_name, birthday) values (46, 'Forrester Collings', '02/12/2022');
insert into employee (id, full_name, birthday) values (47, 'Arvin Paxton', '10/08/1992');
insert into employee (id, full_name, birthday) values (48, 'Zebadiah Pastor', '10/27/1999');
insert into employee (id, full_name, birthday) values (49, 'Aurelie Mantrip', '09/24/1993');
insert into employee (id, full_name, birthday) values (50, 'Rhett Lavalde', '02/04/2023');

-- Sütunların her birine göre diğer sütunları güncelleyecek 3 adet UPDATE işlemi yapalım.
update employee
set birthday = date('01.01.2025')
where "id" = 50;

update employee
set full_name = 'Enes Ünal'
where id=50;

update employee
set birthday = date('16.06.2001')
where full_name = 'Enes Ünal';

-- Sütunların her birine göre ilgili satırı silecek 3 adet DELETE işlemi yapalım.
delete from employee
where "id"= 1;

delete from employee
where full_name = 'Cyrillus Chupin';

delete from employee
where birthday = '02.20.2023';


select * from employee