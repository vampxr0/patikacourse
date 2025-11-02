-- film tablosunda bulunan rental_rate sütunundaki değerlerin ortalaması nedir?
select avg(f.rental_rate)
from film f ;


-- film tablosunda bulunan filmlerden kaç tanesi 'C' karakteri ile başlar?
select count(*)
from film f
where f.title like 'C%';


-- film tablosunda bulunan filmlerden rental_rate değeri 0.99 a eşit olan en uzun (length) film kaç dakikadır?
select max(f."length")
from film f
where f.rental_rate = 0.99;

--- film tablosunda bulunan filmlerin uzunluğu 150 dakikadan büyük olanlarına ait kaç farklı replacement_cost değeri vardır?
select distinct f.replacement_cost
from film f
where f."length">150;