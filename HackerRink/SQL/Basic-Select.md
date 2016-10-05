##Revising the Select Query - 1:
```SQL
select * from City where CountryCode="USA" and Population>100000;
```


##Revising the Select Query - 2:
```SQL
select name from City where CountryCode="USA" and Population>120000;
```


##Select All:
```SQL
select * from City;
```


##Select by ID:
```SQL
select * from City where ID=1661;
```


##Japanese Cities' Attributes:
```SQL
select * from City where CountryCode="JPN";
```


##Japanese Cities' Names:
```SQL
select Name from City where CountryCode="JPN";
```


##Weather Observation Station 1:
```SQL
select City,State from Station;
```


##Weather Observation Station 3:
```SQL
select distinct City from Station where mod(ID,2)=0;
```


##Weather Observation Station 4:
```SQL
select count(City)-count(distinct City) from Station;
```
