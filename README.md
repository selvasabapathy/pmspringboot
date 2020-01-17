# pmspringboot

0. Source @ GitHub

1. MySQL Docker Image

2. Jenkins Docker Image

3. Build executable jar
    mvn -B -DskipTests clean package

4. Build docker image
    docker build -t selvasabapathy/pm-service .
    
    Next, run the built docker image
    docker run --network selva-docker-network --name selva-pm-service -p 8080:8080 selvasabapathy/pm-service
