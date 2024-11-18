
# Technologies
- Spring Boot 2.7.0
- React 18.2.0
- MySql 8.0

# Run locally
## Backend

    Requirement - JDK 17 and maven 3.8.6 should be installed
    ```
    cd ShopNest-API
    mvn clean install
    java -jar target/twitter-clone-0.0.1-SNAPSHOT.jar
    ```

## frontend
    Requirements - Latest node and npm install. Angular cli 14
    ```
    > cd frontend
    > npm install
    > npm start
    ```
    Open in browser http://localhots:3000

# Docker   
## Frontend

    ```
    > cd frontend
    > ng build --configuration production --aot
    > docker build -t frontend .
    > docker run -p 8080:80 --name webapp -d frontend
    ```
    Access web application using url: http://localhost:8080/

## Backend
    ```
    > cd backend
    
    ```
    Access web application using url: 

To log in to phpMyAdmin from the `php-my-admin` service defined in your 

docker-compose.yml

, follow these steps:


## Access phpMyAdmin:
   Open a web browser and go to `http://localhost:8081`.

**Login Credentials**:
   Use the following credentials to log in:
   - *Server*: `mysqldb` 
   - *Username*: `shopnest_usr`
   - *Password*: `ShopNest_pwd` 

## Swager url
http://localhost:8080/swagger-ui.html