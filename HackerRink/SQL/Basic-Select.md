### Revising the Select Query - 1:
```SQL
select * from City where CountryCode="USA" and Population>100000;
```


### Revising the Select Query - 2:
```SQL
select name from City where CountryCode="USA" and Population>120000;
```


### Select All:
```SQL
select * from City;
```


### Select by ID:
```SQL
select * from City where ID=1661;
```


### Japanese Cities' Attributes:
```SQL
select * from City where CountryCode="JPN";
```


### Japanese Cities' Names:
```SQL
select Name from City where CountryCode="JPN";
```


### Weather Observation Station 1:
```SQL
select City,State from Station;
```


### Weather Observation Station 3:
```SQL
select distinct City from Station where mod(ID,2)=0;
```


### Weather Observation Station 4:
```SQL
select count(City)-count(distinct City) from Station;
```


### Weather Observation Station 5
```SQL
(select City,length(City) from Station order by length(City) asc,City asc limit 1) 
union 
(select City,length(City) from Station order by length(City) desc,City asc limit 1);
```


### Weather Observation Station 6
```SQL
select distinct City from Station where City regexp '^[aeiou]';
```


### Weather Observation Station 7
```SQL
select distinct City from Station where City regexp '[aeiou]$';
```


### Weather Observation Station 8
```SQL
select distinct City from Station where City regexp '^[aeiou].*[aeiou]$';
```


### Weather Observation Station 9
```SQL
select distinct City from Station where City regexp '^[^aeiou]';
```


### Weather Observation Station 10
```SQL
select distinct City from Station where City regexp '[^aeiou]$';
```


### Weather Observation Station 11
```SQL
select distinct City from Station where City regexp '^[^aeiou]' or City regexp '[^aeiou]$';
```


### Weather Observation Station 12
```SQL
select distinct City from Station where City rlike '^[^aeiou].*[^aeiou]$';
```
