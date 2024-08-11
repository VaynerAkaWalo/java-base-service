FROM eclipse-temurin:21-alpine

WORKDIR /buildDirectory
COPY . .
ARG GITHUB_TOKEN
ENV GITHUB_TOKEN $GITHUB_TOKEN

RUN ./gradlew bootJar

FROM eclipse-temurin:21-jre-alpine
RUN mkdir "/etc/app"
WORKDIR /etc/app

ARG SHORT_SHA
ENV SHORT_SHA=${SHORT_SHA}

COPY --from=0 /buildDirectory/build/application.jar .

ENTRYPOINT ["java", "-jar", "application.jar"]
