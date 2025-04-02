# Docker

* Show docker installation in [devcontainer.json](/.devcontainer/devcontainer.json)
* Show docker command in terminal
* Show Docker extension
* Start a dockerfile
* FROM... Look up base image - [dockerhub](https://hub.docker.com/)
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

# Azure

* [Create container registry](https://portal.azure.com/#browse/Microsoft.ContainerRegistry%2Fregistries)
* Follow instructions to tag & upload
   * `az login`
   * `az acr login --name <reg name>`
   * `cd example && mvn package`
   * `docker build -t <reg name>.azurecr.io/samples/playerserver .`
   * `docker push <reg name>.azurecr.io/samples/playerserver`
   * See it on the web: Azure Portal, registry, services -> repositories
   * Enable admin on container registry (registry -> Settings -> Access Keys)
   * Try to deploy container app - fails. Dig through error messages. ARM64 vs AMD64
   * `docker build --platform linux/amd64 -t <reg name>.azurecr.io/samples/playerserver .`
   * `docker push <reg name>.azurecr.io/samples/playerserver`
   * Create a new registry (note old registry )