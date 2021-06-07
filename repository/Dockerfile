FROM maven:3.5-jdk-8
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
WORKDIR /usr/src/app
RUN mvn clean install -DskipTests
CMD java -jar  target/repository-0.0.1-SNAPSHOT.jar

# Running the the script