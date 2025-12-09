# Etapa 1: construir el JAR con Maven
FROM maven:3.9.9-eclipse-temurin-21 AS build

# Carpeta de trabajo dentro de la imagen
WORKDIR /app

# Copiamos solo el pom primero (para aprovechar cache)
COPY pom.xml .

# Copiamos el código fuente
COPY src ./src

# Compilamos el proyecto (sin tests para ir más rápido)
RUN mvn -B -DskipTests clean package

# Etapa 2: imagen final solo con el JAR
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copiamos el JAR generado desde la etapa de build
# OJO: este nombre debe coincidir con el que genera Maven en target/
COPY --from=build /app/target/EcoUv-0.0.1-SNAPSHOT.jar app.jar

# Render usa la variable PORT, Spring la leerá desde application.properties
ENV PORT=8080

EXPOSE 8080

# Comando de arranque
ENTRYPOINT ["java","-jar","app.jar"]
