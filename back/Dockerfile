FROM openjdk:17-alpine3.14

RUN apk update


WORKDIR /var/www/project

COPY ./target/project-1.jar /var/www/project

EXPOSE 8080

CMD ["java","-jar","./demo-project.jar"]