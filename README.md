# Valtech Reservation TestDrive

### Guia de Uso

Esta aplicacion nos permitirá el manejo de asignaciones de nuestro prototipo de auto para poder ser testeado.


##Puntos importantes:
La aplicacion tiene instalado el modulo Swagger para poder realizar pruebas de manera sencilla. 
Para acceder a dicho modulo lo hacemos de la siguiente manera.

http://localhost:8080/swagger-ui.html#/

*Base de Datos H2: Para acceder a modulo de la DB lo haremos con la siguiente URL

http://localhost:8080/h2


Se crearon 4 Endppoints para poder manejar las reservas, en el modulo Swagger se explica en detalle su uso.

Detalles importantes.
*Las fechas son en formato "dd/MM/yyyy".
*Las Fecha y horas son en formato "dd/MM/yyy HH:mm".

Se utilizó para el manejo de errores un controller Advice donde se customizan los mensajes de acuerdo al tipo de error.


