# Order API

This project is a backend solution designed to manage orders, with a strong focus on building a scalable, resilient, and event-driven architecture using modern development practices.

-----

## 🛠️ Technologies and Tools

  * **Programming Language:** Java
  * **Framework:** Spring Boot
  * **Database:** MongoDB
  * **Message Broker:** RabbitMQ
  * **Containerization:** Docker & Docker Compose
  * **Version Control:** Git & GitHub
  * **Dependency Manager:** Maven
  * **Logging:** SLF4J

-----

## ⚙️ Key Architectural Components

To ensure the API's scalability and resilience, these core components were carefully integrated:

### MongoDB

Used as the **NoSQL database** for the application. MongoDB's flexible, document-based structure is ideal for storing order data, which can have complex and varied schemas. This choice allows for easy evolution of the data model without requiring rigid migrations, providing **high performance** for read and write operations.

### RabbitMQ

Implemented as a **message broker** to establish an **event-driven architecture**. When a new order is created, an event is published to a queue, allowing other services (or the same service asynchronously) to process it. This **decouples** system components, improves fault tolerance, and ensures that the application remains responsive even under high load.

### Docker & Docker Compose

Utilized for **containerizing** the entire application environment. Docker ensures that the API runs in an isolated and consistent environment, from development to production. With Docker Compose, the application, the MongoDB database, and the RabbitMQ message broker are all orchestrated with a single command, significantly simplifying the **setup and deployment process**.

-----

## 🚀 How to Run the Project

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/edudsfonec/order.git](https://github.com/edudsfonec/order.git)
    ```
2.  **Navigate to the project directory:**
    ```bash
    cd order
    ```
3.  **Build and run the application with Docker Compose:**
    This command will build the Java application and start all the necessary containers.
    ```bash
    docker-compose up -d --build
    ```

The API will be available at `http://localhost:8080` (or your configured port).
