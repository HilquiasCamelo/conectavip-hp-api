# Usar uma imagem base do OpenJDK
FROM openjdk:21-jdk-slim

# Configurar diretório de trabalho dentro do contêiner
WORKDIR /app

# Copiar o arquivo JAR da aplicação para o contêiner
COPY target/conectavip-hp-0.0.1-SNAPSHOT.jar /app/app.jar

# Expor a porta padrão do Spring Boot
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
