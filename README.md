# KotlinWeatherDataUI2

An app which is clone of another app KotlinWeatherData. It has well built code confirming to Clean architecture with multi modules. 

LocalDBLib library module is added for interacting with SQLite DB via Room Lib. 
Dagger2 is user for injecting database where it is required. 

Repository now support 2 datasources
1. Network datasource
2. LocalDB datasource

Workmanager is added to do the One time db population request in background. 



