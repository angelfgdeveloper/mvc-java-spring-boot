# Despliegue y ejecucion desde terminal (deploy)

1. Ir a la ruta del proyecto

### Ejecutar para hacer el despliegue => probablemente no se podra.
2. ```./mvnw.cmd package```


## Window
1. Abrir variables de entorno
2. Creamos una variable en el sistema JAVA_HOME => C://java.11.0/bin
3. Reiniciar el terminal
4. Ir a la ruta del proyecto: ```./mvnw.cmd package```
5. Descarga maven - Dura cierto tiempo (Build Success)
6. ```java -jar .\target\spring-boot-web-0.0.1-SNAPSHOT.jar``` (Una vez que haya compilado)
7. Permitir a Java
8. probar en navegador http://localhost:8081