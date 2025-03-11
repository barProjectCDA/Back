# Dockerfile "multistage build" en 2 étapes :
# 1. la compilation du projet dans un conteneur "maven"
# 2. le déploiement du projet dans un conteneur "eclipse temurin"

# Etape 1 : compilation du projet
FROM maven:3.9.3-eclipse-temurin-17-alpine AS builder
# paramétrage du dossier de travail
WORKDIR /opt/cactus-api
# copie uniquement du pom.xml dans le conteneur
COPY pom.xml .
# copie du code source
COPY ./src ./src
# compilation du projet (sans les tests) et création d'un .jar
RUN mvn clean install -DskipTests

# Etape 2 : conteneur en production
# utilisation d'une image recommandée pour sa légèreté
FROM eclipse-temurin:17-jre-alpine
EXPOSE 8081/tcp
WORKDIR /opt/cactus-api
COPY --from=builder /opt/cactus-api/target/cactus-api-0.0.1-SNAPSHOT.jar cactus-api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/opt/cactus-api/cactus-api-0.0.1-SNAPSHOT.jar"]
