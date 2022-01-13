#### RESPUESTAS ####

=====================================================================================================================================================================================
#### Ejercicio 1 ####

El desarrollo se ve reflejado en la implementacion del codigo.
Asimismo se agrega en la carpeta "extras" una coleccion de imsomnia para probar dichas urls
Desde localhost:8080/api/swagger-ui.html se encuentran documentados todos los request de la solucion y permite su prueba desde la page.

=====================================================================================================================================================================================
#### Ejercicio 2 ####

Como se comento anteriomente se evidencian dichos requerimientos por la pantalla de swagger donde ahora tambien existen estos metodos:
![imagen](https://user-images.githubusercontent.com/37519105/149248731-dd7c34f9-dac0-4ea2-a0d7-f4c50f52039a.png)


=====================================================================================================================================================================================
#### Bonus (funcionalidad no requerida) ####

- Escribir pruebas unitarias (Junit) de los distintos componentes. --> Se agrega un conjunto de test para clases de utils, repositorios y otros.

- Desplegar la aplicación en algún servidor público y especificar la forma de acceder (incluir info en el archivo "RESPUESTAS.md"). --> Se encuentra desplegado en https://rosde-evaluation.herokuapp.com/api/swagger-ui.html

- Reemplazar la base de datos configurada en memoria (H2) por una a elección de entre las siguientes: PostgreSQL o MySQL. --> Desconozco una forma de hostear una BD mediante un servidor gratuito por dicho motivo descarte este punto.
	De hacerlo, la solución deberá incluir:
		- Información sobre la BD utilizada.
		- Script de creación e inicialización de datos.
		- Modificación correspondiente en la configuración del datasource.
		- Cualquier otra información que considere necesaria.

- Incluir funcionalidad de registración y autenticación de usuario. --> no se implemento

- Incluir funcionalidad de autorización de acceso a las funcionalidades desarrolladas. --> no se implemento
		
- Implementar funcionalidad básica de navegación entre las funcionalidades y la landing page ("Volver", "Inicio" o similar), para evitar la necesidad de navegar manualmente por url. --> solo existio una unica pantalla.

- Implementar la funcionalidad del ejercicio 2 en el frontend (aplican las mismas consideraciones que para el ejercicio 1). --> considero que swagger es suficiente para lo que se pide, caso contrario armaría un modulo diferente (nuxt + vue) para visualizar lo que pida el requerimiento
