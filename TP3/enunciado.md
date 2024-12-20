Nuestra consultora, San Andrés Robotics y su exitosos desarrollos llamó la atención del equipo de exploración 
remota de Marte en la NASA y tenemos que desarrollar el sistema que controle el nuevo Explorer.
Para eso, se asume que la superficie de Marte es un plano y que se usan puntos para posicionar al Explorer 
en dicho plano, más un punto cardinal que indica hacia donde apunta.
Debido a que Marte está muy lejos, siempre se le envían al Explorer un conjunto de comandos empaquetados 
en un String, donde cada caractér es un comando.
Tener en cuenta que la comunicación puede tener problemas y pueden llegar comandos erróneos en cuyo caso 
se espera que no se sigan procesando los comandos restantes.
Además:
- El Explorer siempre empieza en un punto inicial (x,y) y apuntando a un
punto cardinal (N,S,E,O)
- El rover recibe una secuencia de caracteres que representan comandos sobre
como moverse
- Los comandos pueden ser:
- f = mover hacia adelante un punto (forward)
- b = mover hacia atrás un punto (backwards)
- l = rotar 90 grados a la izquierda
- r = rotar 90 grados a la derecha
- O = abrir la escotilla superior
- o = abrir la escotilla inferior
- c = cerrar las escotillas
- a = aspirar aire por la escotilla superior
- i = recoger una muestra del terreno.

Nos toca desarrollar el sistema de posicionamiento del Explorer, para eso se nos pide la capacidad de procesar 
cada comando y mantener actualizada la actitud del rover en un sistema cartesiano. 
La Nasa es muy exigente en sus estándares de desarrollo y nos pide por contrato un desarrollo usando la técnica 
de TDD, con una completa cobertura con casos de test. Se ve que entienden del tema! 
Les preocupa mucho el código repetido, el uso de Ifs, los malos nombres y las responsabilidades entre objetos mal repartidas (*).

Algunas características del rover que tenemos que controlar son que no puede aspirar si la escotilla superior está cerrada, 
cavar si la inferior está cerrada, abrir una segunda escotilla si la otra ya está abierta o cerrar si no hay alguna abierta.
En estos casos esperan que se presente una falla descriptiva del problema.

(*) comentaron algo como que incluye todo lo visto y corregido hasta ahora, porque se va a evaluar también ¯\_(ツ)_/¯
