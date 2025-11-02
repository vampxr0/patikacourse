-- film tablosunda bulunan filmleri rating değerlerine göre gruplayınız.
select count(f.rating), f.rating
from film f
group by f.rating;


-- film tablosunda bulunan filmleri replacement_cost sütununa göre grupladığımızda film sayısı 50 den fazla olan replacement_cost değerini ve karşılık gelen film sayısını sıralayınız.
select count(f.replacement_cost),f.replacement_cost
from film f
group by f.replacement_cost
having count(f.replacement_cost)>50;


-- customer tablosunda bulunan store_id değerlerine karşılık gelen müşteri sayılarını nelerdir?
select count(c.store_id), c.store_id
from customer c
group by c.store_id;


-- city tablosunda bulunan şehir verilerini country_id sütununa göre gruplandırdıktan sonra en fazla şehir sayısı barındıran country_id bilgisini ve şehir sayısını paylaşınız.
select count(c.country_id),c.country_id
from city c
group by c.country_id
order by count(c.country_id) desc
limit 1;