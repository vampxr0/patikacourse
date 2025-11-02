--city tablosu ile country tablosunda bulunan şehir (city) ve ülke (country) isimlerini birlikte görebileceğimiz INNER JOIN sorgusunu yazınız.

select city.city city_name, country.country country_name from city
inner join country on city.country_id= country.country_id


--customer tablosu ile payment tablosunda bulunan payment_id ile customer tablosundaki first_name ve last_name isimlerini birlikte görebileceğimiz INNER JOIN sorgusunu yazınız.

select p.payment_id, c.first_name, c.last_name
from customer c
inner join payment p on c.customer_id = p.customer_id;

--customer tablosu ile rental tablosunda bulunan rental_id ile customer tablosundaki first_name ve last_name isimlerini birlikte görebileceğimiz INNER JOIN sorgusunu yazınız.

select r.rental_id,c.first_name, c.last_name
from customer c
inner join rental r on r.customer_id = c.customer_id;