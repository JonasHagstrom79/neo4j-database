# Neo4j Person Registration

This project is a simple web application that allows users to register persons into a Neo4j database. The application is built using TypeScript for the frontend and Java with Spring Boot for the backend.

## Features

- Register persons with their name, surname, address, and year of birth.
- Data is stored in a Neo4j database.

## Prerequisites

- Java JDK 1.8 or later
- Maven
- Node.js and npm
- Neo4j Database

## Setup

1. **Clone the repository**

```bash
git clone <repository-url>
```

2. **Start your Neo4j Database**

Ensure your Neo4j database is running and accessible. You may need to update the `DatabaseConnector.java` file with your database URI, username, and password.

3. **Build and run the backend**

Navigate to the project root directory and run:

```bash
mvn spring-boot:run
```

This will start the Spring Boot application.

4. **Install TypeScript and compile**

First, ensure TypeScript is installed globally. If not, install it using npm:

```bash
npm install -g typescript
```

Then, compile the TypeScript file:

```bash
tsc app.ts
```

This will generate an `app.js` file.

5. **Open the web application**

Open the `index.html` file in a web browser to access the web application.

## Usage

Fill in the form with the person's name, surname, address, and year of birth, then click the "Submit" button. If the registration is successful, you will see an alert confirming the person has been registered.

## Technologies

- Frontend: HTML, CSS, TypeScript
- Backend: Java, Spring Boot
- Database: Neo4j

## Contributors

- [Your Name]

Feel free to contribute to this project by submitting a pull request.

## License

This project is licensed under the MIT License - see the LICENSE.md file for details.
