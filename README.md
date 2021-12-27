# circumference

A Java Spring Boot (Backend) + Vaadin (Frontend) based web application to calculate / generate N-th digit of Pi using [Bailey-Borwein-Plouffe Formula](https://en.wikipedia.org/wiki/Bailey%E2%80%93Borwein%E2%80%93Plouffe_formula) and circumference of sun. The calculation result was tested / compared against https://www.browserling.com/tools/pi-digits.

### API / URL Information
- **Web Application** -> http://localhost:8080/ui/
- **HTTP GET API** -> http://localhost:8080/api/v1/pi
- **HTTP API Documentation** -> http://localhost:8080/swagger-ui

### Steps to Run Application
- Install [Java 11 or later]( https://adoptopenjdk.net/releases.html )
- Set JAVA_HOME once Java is installed. Instructions can be found https://www.baeldung.com/java-home-on-windows-7-8-10-mac-os-x-linux
- Install [NodeJS]( https://nodejs.org/en/ )
- Run the following command to start the application

  **For Windows**
  ```
  ./mvnw.cmd spring-boot:run 
  ```

  **For Linux/MacOS**
  ```
  ./mvnw spring-boot:run 
  ```

### Limitations
- Server is now only calculating Pi with the N-th digit configured before starting up (default is 1000 digits with 999 decimal precisions).
- Frontend and Backend is running on same server.

### Future Work Areas
- Web Application to accept N-th digit to calculate Pi similar to https://www.browserling.com/tools/pi-digits.
- Separating Frontend and Backend as two separate projects for a better flexibility to develop frontend.
- Dockerized the project so the end user does not need to setup and build the project manually.