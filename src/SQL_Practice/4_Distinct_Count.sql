-- film tablosunda bulunan replacement_cost sütununda bulunan birbirinden farklı değerleri sıralayınız.
select distinct f.replacement_cost
from film f;


-- film tablosunda bulunan replacement_cost sütununda birbirinden farklı kaç tane veri vardır?
select count(distinct f.replacement_cost)
from film f;


-- film tablosunda bulunan film isimlerinde (title) kaç tanesini T karakteri ile başlar ve aynı zamanda rating 'G' ye eşittir?
select count(distinct f.title)
from film f
where f.title like 'T%'
and f.rating = 'G';


-- country tablosunda bulunan ülke isimlerinden (country) kaç tanesi 5 karakterden oluşmaktadır?
select count(*)
from country c
where c.country like '_____';


-- city tablosundaki şehir isimlerinin kaç tanesi 'R' veya r karakteri ile biter?
select count(*)
from city c
where c.city ilike '%r';