
* Este es un breve README que describe cómo compilar y ejecutar a través de Docker, mostrando todos los comandos utilizados durante este laboratorio-

1- Crear  una red:
$ docker network create my-network

2- Crear un volumen:
$ docker volume create mydata

3- Levantar la base de datos indicando la red anterior creada a partir de un contenedor llamado mysqlcar: 
$ docker run --name mysqlcar -e MYSQL_ROOT_PASSWORD=root -p 3307:3306 --network my-network mysql:8.0.0

4- Crear la imagen del backend:
$ docker build -t cardb:0.0.1 .

5- Ejecutar este backend desde la misma red (my-network) en la que esta conectada nuestra base de datos (mysql:8.0.0): 
$ docker run --name carddocker -p 8080:8080 --network my-network cardb:0.0.1

6- Crear el archivo dist desde el frontend con el comando: 
$ npm run build

7- Crear la imagen del frontend : 
$ docker build -t carvue:0.0.1 .

8- Lanzar el contenedor en la misma red (my-network) que hemos conectado el Backend: 
$ docker run --name carvuedocker -p 8081:80 --network my-network carvue:0.0.1
