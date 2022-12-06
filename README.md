1. Öppna terminalen och kör följade kommando:
   docker run --name socialmediadb -p 3306:3306 -e MYSQL_ROOT_PASSWORD=grupp3 -d mysql
2. kör sedan följande kommando:
   docker exec -it socialmediadb bash
3. vid det här steget bör du vara inne i bashen. kör sedan följande kommando:
   mysql -uroot -pgrupp3
4. Nu bör du vara inne i mysql om allt gått rätt, kör sedan följande kommando:
   create database socialmediadb;
5. Nu bör du ha en lokal instans av databasen skapad för att kunna köra applikationen :)
