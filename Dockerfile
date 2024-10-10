# Etapa de build
FROM openjdk:21-jdk-slim AS build
LABEL authors="PATRICK-ANJOS"

# Instalar o Maven
RUN apt-get update && \
    apt-get install -y maven

# Definir o diretório de trabalho
WORKDIR /app

# Copiar o pom.xml e baixar as dependências do Maven
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiar o restante do código-fonte
COPY src ./src

# Compilar o projeto
RUN mvn clean install -DskipTests

# Etapa de runtime
FROM openjdk:21-jdk-slim

#Definir o diretório de trabalho
WORKDIR /app

COPY --from=build /app/target/challenge-itau-0.0.1-SNAPSHOT.jar transaction.jar

ENV SPRING_DATASOURCE_URL=from_compose
ENV SPRING_DATASOURCE_USERNAME=from_compose
ENV SPRING_DATASOURCE_PASSWORD=from_compose

ENTRYPOINT [ "java", "-jar", "transaction.jar" ]