--film tablosunda film uzunluğu length sütununda gösterilmektedir. Uzunluğu ortalama film uzunluğundan fazla kaç tane film vardır?
select count(*)
from film f
where f."length" > (
                    select avg(f."length")
                    from film f
                    );

--film tablosunda en yüksek rental_rate değerine sahip kaç tane film vardır?

select count(*)
from film f
where f.rental_rate = (
                        select max(f.rental_rate)
                        from film f
                        );

--film tablosunda en düşük rental_rate ve en düşün replacement_cost değerlerine sahip filmleri sıralayınız.

select *
from film f
where f.rental_rate = (
                        select min(f1.rental_rate)
                        from film f1
                        )
and
f.replacement_cost = (
                        select min(f2.replacement_cost)
                        from film f2
                        )


-- payment tablosunda en fazla sayıda alışveriş yapan müşterileri(customer) sıralayınız.
select c.first_name, c.last_name, payments_data.payment_count
from customer c
inner join (
        select p.customer_id, count(p.customer_id) payment_count
        from payment p
        group by p.customer_id
        order by count(p.customer_id) desc
        ) payments_data on payments_data.customer_id = c.customer_id
order by payments_data.payment_count desc;