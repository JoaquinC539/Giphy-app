# FROM openjdk:17-alpine3.14

# RUN apk update

# WORKDIR /var/www/project



# COPY ./target/project-1.jar /var/www/project

# EXPOSE 8080

# CMD ["java","-jar","./demo-project.jar"]

FROM ubuntu:latest AS build-app

WORKDIR /APP

RUN apt-get update

RUN apt-get install -y openjdk-17-jdk

COPY . ./

RUN chmod +x mvnw

RUN ./mvnw install package

FROM openjdk:17-alpine3.14

WORKDIR /APP

EXPOSE 8080

COPY --from=build-app /APP/target/sekopjc-project.jar .

CMD [ "java", "-jar", "sekopjc-project.jar" ]

