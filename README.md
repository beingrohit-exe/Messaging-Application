# Real Time Chat Application

This is a real-time chat application built using Spring Boot, Websockets, Elasticsearch, Thymeleaf, and StompJs.

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Technologies Used](#technologies-used)
- [Contributing](#contributing)
- [License](#license)

## Features

- Real-time chat functionality
- User authentication and authorization
- Message persistence using Elasticsearch
- Responsive user interface with Thymeleaf
- WebSocket communication with StompJs

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) 8 or later installed
- Maven installed
- Elasticsearch installed and running
- IDE (e.g., IntelliJ, Eclipse) for easier development

## Getting Started

1. Clone the repository:

    ```bash
    git clone https://github.com/your-username/real-time-chat-app.git
    cd real-time-chat-app
    ```

2. Build the project using Maven:

    ```bash
    mvn clean install
    ```

3. Run the application:

    ```bash
    java -jar target/real-time-chat-app.jar
    ```

4. Access the application in your web browser at [http://localhost:8080](http://localhost:8080).

## Usage

- Open the application in your web browser.
- Register or log in.
- Start chatting with other users in real-time.

## Technologies Used

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Websockets](https://developer.mozilla.org/en-US/docs/Web/API/WebSockets_API)
- [Elasticsearch](https://www.elastic.co/)
- [Thymeleaf](https://www.thymeleaf.org/)
- [StompJs](https://stomp-js.github.io/)

## License

This project is licensed under the [APACHE 2 License](LICENSE).
