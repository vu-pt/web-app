FROM gradle:8.7.0-jdk17-alpine AS buildStage
ENV APP_HOME=/usr/app
WORKDIR $APP_HOME
COPY backend .
RUN gradle clean build

FROM openjdk:17-jdk-slim
ENV ARTIFACT_NAME=backend-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/usr/app

WORKDIR $APP_HOME
COPY --from=buildStage $APP_HOME/build/libs/$ARTIFACT_NAME .

EXPOSE 8089

RUN adduser --system --group spring

USER spring

ENTRYPOINT exec java -jar $ARTIFACT_NAME