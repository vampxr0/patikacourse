-- film tablosundan 'K' karakteri ile başlayan en uzun ve replacenet_cost u en düşük 4 filmi sıralayınız.
(select f.title, f."length", f.replacement_cost
from film f
where f.title like 'K%'
order by f."length" desc
limit 4)
union
(select f.title, f."length", f.replacement_cost
from film f
where f.title like 'K%'
order by f.replacement_cost asc
limit 4);

-- film tablosunda içerisinden en fazla sayıda film bulunduran rating kategorisi hangisidir?

select f.rating
from film f
group by f.rating
order by count(f.rating) desc
limit 1;

-- cutomer tablosunda en çok alışveriş yapan müşterinin adı nedir?

select c.first_name || ' ' || c.last_name customer_name
from customer c
where c.customer_id = (
                        select p.customer_id
                        from payment p
                        group by p.customer_id
                        order by count(p.customer_id) desc
                        limit 1
                        );

-- category tablosundan kategori isimlerini ve kategori başına düşen film sayılarını sıralayınız.

select c."name", count(c.category_id)
from film_category fc
inner join category c on c.category_id = fc.category_id
group by c.category_id,c."name"
order by count(c.category_id) desc ;


-- film tablosunda isminde en az 4 adet 'e' veya 'E' karakteri bulunan kç tane film vardır?
select count(*)
from film f
where f.title ilike '%e%';