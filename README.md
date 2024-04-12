
## Giphy-app


## Versiones:

Back:

- java 17 openjdk
- spring 3.2.4

Front:
- node 20.11.0
- npm 10.2.4
- angular o ng  15.2.6

## Uso:

Back: 
- En carpeta de back
- no necesita configurar .env
- No inlcuido tests
- Correr con mvn o mvnw usando `mvn spring-boot:run` o construirse con `mvn clean install -DskipTests` y `mvn package -DskipTests` y ejecutar con `java -jar ./taget/demo-project.jar`
- Existe imagen dockerizada y compose para correr en docker local, cambiar nombres si es necesario el build es "java-app" al construirse que es la que se esta en dockercompose.yml
- Copia el .jar al contenedor y lo ejecuta. Con red en my-network para escucha entre contenedores
- Llave privada propia sera removida en 2 dias
- Endpoints: GET: */api/gifs?gifname=palceholder&giflimit=placeholder&gofoffset=placeholder* para buscar gifs y GET,POST,PUT: */api/favorites* para agregar, ver y quitar favoritos

Front: 
- En capreta de front/app
- Ejecutar con `ng serve`para practicidad o `ng build`y correr con algun servidor
- Usando bootstrap de css
- Dos paginas una de fetch y otra de visualización y eliminación

