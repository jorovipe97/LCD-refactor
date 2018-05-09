# LCD-refactor
Refactorizando un vizualizador LCD (ascii art) escrito en java.

# ¿Qué cambio?
La clase **ImpresorLCD** originalmente se estaba encargando de varias funcionalidades como procesar los comandos, crear los displays, posicionarlos y asignarle valores, ahora, con las modificaciones esta clase únicamente se encarga de procesar los comandos y delega a la clase **DigitoLCD** la funcionalidad de crear un display y asignarle valores, logrando de esta manera una mayor reusabilidad y modularidad del código fuente.

Cabe decir que esta clase fue desarrollada a partir de la idea de un Display LCD de 7 segmentos que se consigue en tiendas de electrónica, por tanto, se codifico el número a 7 segment para su visualización en el display.

También se re-implemento el método estático **ImpresorLCD.isInteger()** mediante expresiones regulares debido a que en la versión original se estaban usando excepciones para determinar el flujo del programa siendo esta una mala practica de programación.

Además, usando **JUnit 4** se realizaron pruebas unitarias a la clase **DigitoLCD** e **ImpresorLCD** con el fin de facilitar el proceso de pruebas automáticas.


## Fe de errata
Pido disculpas por los errores de ortografía que puedas encontrar en los comentarios del código fuente.
