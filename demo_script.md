1. Show docker installation in [devcontainer.json](/.devcontainer/devcontainer.json)
2. Show docker command in terminal
3. Show Docker extension
4. Start a dockerfile
5. FROM... Look up base image - [dockerhub](https://hub.docker.com/)
  * FROM amazoncoretto:23 ?
  * Hard to find a good/up to date answer by googling - e.g. freecodecamp link says to use an older version of node, and alpine
  * Copilot will always give weird out of date versions
* Set WORKDIR, explain workdir vs local dir. Highlight that Dockerfile here is inside server dir
* COPY ./target/server-0.0.1-SNAPSHOT.jar /app
* EXPOSE 8080
* CMD ["java", "-jar", "spring-0.0.1-SNAPSHOT.jar"]
* Build: `docker build -t testimage .`
* `docker image ls`
* Run app: `docker run -p 8080:8080 --name testcontainer testimage`
* `docker container ls`
* `docker container ls -a`
* Clean up old container: `docker container rm testcontainer`
* Run app: `docker run --rm -p 8080:8080 --name testcontainer testimage`
* `docker container ls -a`
* Test app by sending a request to it from another terminal:
  * `curl -X POST -H "Content-Type: application/json" -d '{"maxes": [500, 10]}' http://localhost:8080/generate`
* Show port mapping: `docker run --rm -p 3000:8080 --name testcontainer testimage`
  * `curl -X POST -H "Content-Type: application/json" -d '{"maxes": [500, 10]}' http://localhost:3000/generate`
* Modify Dockerfile to mess up a copy command / break it
* Show how to debug: `docker run --rm -it -p 8080:8080/tcp testimage /bin/bash`