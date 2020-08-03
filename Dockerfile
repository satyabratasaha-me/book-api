FROM codewitme/java-maven:latest
COPY /src code/src/
COPY /pom.xml code/
WORKDIR /code
RUN mvn package
WORKDIR /code/target

# ENTRYPOINT ["java", "-jar", "librairie-0.0.1-SNAPSHOT.jar"]






