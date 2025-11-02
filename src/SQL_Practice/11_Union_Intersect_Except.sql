-- actor ve customer tablolarında bulunan first_name sütunları için tüm verileri sıralayalım.

select a.first_name
from actor a
union
select c.first_name
from customer c;

-- actor ve customer tablolarında bulunan first_name sütunları için kesişen verileri sıralayalım.
select a.first_name
from actor a
intersect
select c.first_name
from customer c;

-- actor ve customer tablolarında bulunan first_name sütunları için ilk tabloda bulunan ancak ikinci tabloda bulunmayan verileri sıralayalım.

select a.first_name
from actor a
except
select c.first_name
from customer c;

-- İlk 3 sorguyu tekrar eden veriler için de yapalım.

select a.first_name
from actor a
union all
select c.first_name
from customer c;


select a.first_name
from actor a
intersect all
select c.first_name
from customer c;


select a.first_name
from actor a
except all
select c.first_name
from customer c;