# Spring_boot_project_with_DB_operations
It includes concepts of schedulers, logging, DB crud operations, async, caching, jdbc template to execute queries, row mapper to collect resultset, sql parameter map to pass parameters to the query, read sql queries from properties file using ResourceBundle.

    This spring boot application performs the below tasks:
1.	Scheduler
a.	Write a scheduler to log any string at fixed  rate with a random thread sleep
b.	Write a scheduler to log any string at fixed  delay with a random thread sleep
2.	Async
a.	Write a REST Endpoint with http method Get
b.	Have an async method in service bean with thread sleep of 1 min
c.	Invoke the async method from controller and return a string “Async”
3.	DB Crud
a.	Create an employee table with two fields
b.	Use jdbc template to execute queries
c.	User row mapper to collect resultset
d.	User sql parameter map to pass parameters to the query
e.	Read sql queries from properties file using ResourceBundle
4.	Caching
a.	Write a controller to fetch all entries from employee table
b.	Cache the fetch all method at the repository layer
c.	Evict the cache on every 10 mins

The database used is MySQL and a table of employee is created using the query :
create table employee(id int primary key, name varchar(100));
