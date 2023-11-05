# Todo Application

This is a simple Todo application built with ChatGPT. It allows users to manage their todo items.

## Features

- Create a new todo item
- Update an existing todo item
- Delete a todo item
- List all todo items

## Prerequisites

- Java 8 or higher
- Gradle
- SonarQube (optional)

## Running the Application

1. Clone the repository:

```bash
git clone https://github.com/eshonkulov-asliddin/todo-app-with-gpt.git
```

2. Navigate into the project directory:

```bash
cd todo-app-with-gpt
```

3. Run the application:

```bash
./gradlew bootRun
```

The application will be accessible at `http://localhost:8080`.

## Running Tests

You can run the tests with the following command:

```bash
./gradlew test
```

## Generating JaCoCo Report

You can generate a JaCoCo report with the following command:

```bash
./gradlew jacocoTestReport
```

The report will be generated in the `build/reports/jacoco/test` directory.

## Running SonarQube Analysis

Before running the SonarQube analysis, make sure you have SonarQube running and you have set the `SONAR_HOST_URL` and `SONAR_TOKEN` environment variables.

You can run the SonarQube analysis with the following command:

```bash
./gradlew jacocoTestReport sonarqube
```

The analysis results will be available on your SonarQube server.
