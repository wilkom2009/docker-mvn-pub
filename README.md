# Docker-mvn-pub
A simple Spring Boot App to highlight how to dockerize it using Maven plugin and push it to [Docker Hub](https://hub.docker.com/).

# Steps
1. Clone this repository or create a new [Spring Boot App](https://start.spring.io/)
2. If you have no Docker ID in [Docker Hub](https://hub.docker.com/), create one
3. Open the `pom.xml` file and in the plugins section, add the following pluging:
```JS
   <plugin>
		<groupId>com.spotify</groupId>
		<artifactId>dockerfile-maven-plugin</artifactId>
		<version>1.4.3</version>
		<executions>
			<execution>
				<id>default</id>
				<goals>
					<goal>build</goal>
					<goal>push</goal>
				</goals>
			</execution>
		</executions>
		<configuration>
			<repository>wilkom2009/docker-mvn-pub</repository>
			<tag>${project.version}</tag>
		</configuration>
	</plugin>
   ```
4. In the `<configuration>...</configuration>` section, change `wilkom2009` to your Docker ID and `docker-mvn-pub` to the project Artifact Id
5. Create a `Dockerfile` in the project root and put below code:
```JS
 FROM openjdk:8
 ARG JAR_FILE=target/*.jar
 COPY ${JAR_FILE} app.jar
 ENTRYPOINT ["java","-jar","/app.jar"]
```
PS : Here we use [Open JDK 8](https://openjdk.java.net/install/)

6. Run Maven clean and package commands then push dokerfile :
```sh
  mvn clean package dockerfile:push
```