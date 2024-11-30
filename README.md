# conato02 (Píldoras Informáticas)

Ejemplo de uso de dos clases: Coche y CocheMain (Luego refactorizado/renombrado como VehiculoMain para que Furgoneta pueda heredarlo)
En CocheMain creamos instancia y llamamos a los métodos desde el main.

La clase Coche contiene el constructor, setters & getters, así como métodos de negocio (?).

Creación clase EmpleadoMain. Vamos a romper la modularidad de la POO metiendo varias clases en un solo archivo java, por ver cómo es, pues nos encontraremos programas así.
Campo Id (contador con autoincremento de nuevos objetos de la clase Empleado)

Cómo crear instancias y cómo crear un arreglo de instancias de la clase Empleado.
Ciclos for y forEach
Sobrecarga de constructores.
Clase Date. Gregorian Calendar.

Clase Furgoneta. Herencia. 

***** No es el mejor ejemplo de herencia Furgoneta entends Coche, pero nos sirve.
***** Generalmente, una subclase encaja en el paradigma ¿"Es un..." de la clase padre?
Furgoneta no es un coche. Hubiera sido más acertado crear una clase padre Vehículo.
Vehículo del que descienden al mismo nivel: Furgoneta, Coche, Camión, Moto

Clase Jefe extends Clase Empleado 
¿Es un Jefe siempre un Empleado? Sí, luego Jefe hereda de Empleado
¿Es un Empleado siempre un Jefe? No.

Empleado / Jefatura. Polimorfismo y Enlace Dinámico.
super()
