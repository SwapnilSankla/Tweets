The repository contains basic Spring boot application written in Kotlin which runs application and mongodb as containers.

- Build script: Include docker plugin, dependency and tasks to enable docker task with gradle. 
- Build command: `gradle clean build docker`
- Basic docker commands:
    - `docker images`: Lists all images
    - `docker pull <image name>`: Pulls the image from the hub registry
    - `docker push <image name>`: Pushes the image to the hub registry
    - `docker ps`: Lists all running containers
    - `docker rmi <image name>`: remove image
    - `docker logs <container name>`: shows logs of the container process
    - `docker exec -it <container name> sh`: start shell inside container
- Running multiple containers together: `docker-compose`
    - Use docker-compose.yaml to specify the containers which we want to run together
- Basic docker-compose commands:
    - Start: `docker-compose up`
    - stop: `docker-compose down`
    - All other docker commands are also supported.
- Mongo:
    - How to connect to running mongo container from application?
        - Specify spring.data.mongodb.uri as follow
            `spring.data.mongodb.uri: mongodb://<mongo container name>:<mongo container port>/<mongo db name>`
        - Example: `spring.data.mongodb.uri:mongodb://mongo:27017/tweets`
    - `EnableMongoAuditing` annotation to let mongo repository add auditing parameters to collection. Auditing params like
        - Id
        - Version
        - LastModifiedDate
        - CreatedDate
    - Mongo CLI commands:
        - `mongo`: Starts mongo CLI
        - `show dbs`: Shows all available databases.
        - `use <db name>`: Starts using a database.
        - `show collections`: Shows all collections inside a database.
        - `db.<collection name>.find().pretty()`: Returns all the documents inside a collection.
        - `db.<collection name>.find(<criteria>).pretty()`: Returns all the documents inside a collection matching given criteria.
    - Mongo admin:
        - Web client for Mongo
        - By default it runs on `port 1234`
        - Image name: `mrvautin/adminmongo`
        - To connect mongo admin to the local mongo instance specify `HOST=0.0.0.0`
        - To run mongo admin as container: 
        
            `docker run -d -p 1234:1234 --name=adminmongo -e HOST=0.0.0.0 mrvautin/adminmongo`
        - To run mongo admin with docker compose: 
        
            ```image: mrvautin/adminmongo
             container_name: adminmongo
             mem_limit: 500m
             links: ['mongo-service:mongo'] # link pointing to <service name>: <container name>
             environment:
                CONN_NAME: 'localConnection'
                DB_HOST: 'mongo'
                HOST: 0.0.0.0
             ports:
                - "1234:1234"    
        