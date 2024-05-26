FROM openjdk:11
EXPOSE 8000
MAINTAINER "SUNDHAR"
COPY target/employee.jar usr/app/
WORKDIR usr/app/
ENTRYPOINT ["java", "-jar", "employee.jar"]