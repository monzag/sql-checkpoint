SELECT name FROM customers where gender="Female";

SELECT SUM(net_value + net_value*tax_rate/100) FROM sales;

SELECT * FROM customers WHERE birthyear < 1999;

SELECT * FROM customers ORDER BY surname;

SELECT product_name FROM sales WHERE product_name LIKE "%a%";

SELECT * FROM sales WHERE net_value > 500;

SELECT COUNT(id) FROM customers;

SELECT COUNT(id) FROM sales;

SELECT SUM(net_value + net_value*tax_rate/100) FROM sales WHERE customer_id=7;

SELECT customers.name, (sales.net_value + sales.net_value*sales.tax_rate/100)
FROM customers INNER JOIN sales ON customers.id = sales.customer_id;


