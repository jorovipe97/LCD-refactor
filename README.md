# LCD-refactor
Refactorizando un vizualizador LCD (ascii art) escrito en java.

# ¿Qué cambió?
La clase **ImpresorLCD** originalmente se estaba encargando de varias funcionalidades como procesar los comandos, crear los displays, posicionarlos y asignarle valores, ahora, con las modificaciones esta clase únicamente se encarga de procesar los comandos y delega a la clase **DigitoLCD** la funcionalidad de crear un display y asignarle valores, logrando de esta manera una mayor reusabilidad y modularidad del código fuente.

Cabe decir que esta clase fue desarrollada a partir de la idea de un Display LCD de 7 segmentos que se consigue en tiendas de electrónica, por tanto, se codifico el número a 7 segment para su visualización en el display.

También se re-implemento el método estático **ImpresorLCD.isInteger()** mediante expresiones regulares debido a que en la versión original se estaban usando excepciones para determinar el flujo del programa siendo esta una mala practica de programación.

Además, usando **JUnit 4** se realizaron pruebas unitarias a la clase **DigitoLCD** e **ImpresorLCD** con el fin de facilitar el proceso de pruebas automáticas.

# ¿Quien es Jose Villalobos?
Estudiante de ingeniera en diseño de entretenimiento digital con destreza en distintos lenguajes de programación y motores de videojuegos como Unity, C#, OpenCV, Python, JS/CSS/HTML, C y ShaderLab/CG además cuenta con habilidades en distintos programas de diseño como Photoshop, After Effects, Adobe Premier y Blender así como conocimientos en el área de la Inteligencia Artificial.

Posee experiencia en el desarrollo, comercialización y soporte de productos de software gracias a proyectos emprendidos personalmente.   Es capaz de combinar lo mejor del mundo del diseño y de la ingeniería de software gracias a su formación en principios de diseño, elaboración de narrativas, psicología cognitiva y diseño de interfaces. Adicionalmente posee buenas habilidades técnicas para el desarrollo de soluciones que requieran la integración de hardware. Habilidades que aplica constantemente en su quehacer diario para la creación de contenidos digitales de alto impacto para realidad aumentada y realidad virtual, así como montajes físicos interactivos y soluciones de internet de las cosas (IoT). 
 

## Fe de errata
Pido disculpas por los errores de ortografía que puedas encontrar en los comentarios del código fuente.
