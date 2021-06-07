FROM maven:3.5-jdk-8
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
WORKDIR /usr/src/app
EXPOSE 8362
RUN mvn clean install -DskipTests
CMD java -jar  target/scrapper-0.0.1-SNAPSHOT.jar