# Используем легковесный образ OpenJDK 17 от Eclipse Temurin
FROM eclipse-temurin:17-jdk-focal

# Метаданные для отслеживания
LABEL maintainer="undab@landmarkly.com"

# Устанавливаем рабочую директорию в контейнере
WORKDIR /app

# Копируем JAR-файл из целевой папки проекта в контейнер
COPY target/*.jar app.jar

# Открываем порт 8080 (по умолчанию для Spring Boot)
EXPOSE 8080

# Запускаем приложение при старте контейнера
ENTRYPOINT ["java", "-jar", "/app.jar"]