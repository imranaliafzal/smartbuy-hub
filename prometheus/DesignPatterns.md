---

## 🧠 Java Design Patterns Cheat Sheet

### 🏗️ **Creational Patterns**

> *These deal with object creation mechanisms, trying to create objects in a manner suitable to the situation.*

| Pattern              | Purpose                                                                                           | Example Use Case                                                      |
| -------------------- | ------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------- |
| **Singleton**        | Ensure a class has only one instance and provide a global point of access.                        | Database connection manager, logging service.                         |
| **Factory Method**   | Define an interface for creating an object, but let subclasses decide which class to instantiate. | Creating shapes (Circle, Rectangle) without specifying exact classes. |
| **Abstract Factory** | Create families of related or dependent objects without specifying their concrete classes.        | GUI themes (DarkThemeFactory, LightThemeFactory).                     |
| **Builder**          | Construct a complex object step-by-step, separating construction and representation.              | Building an immutable `Pizza` or `Person` object.                     |
| **Prototype**        | Clone existing objects instead of creating new ones.                                              | Copying document templates, game characters.                          |

---

### 🧱 **Structural Patterns**

> *These deal with object composition — creating relationships between objects.*

| Pattern       | Purpose                                                                     | Example Use Case                                                              |
| ------------- | --------------------------------------------------------------------------- | ----------------------------------------------------------------------------- |
| **Adapter**   | Convert the interface of a class into another expected interface.           | Legacy code integration (e.g., USB-to-Ethernet adapter).                      |
| **Bridge**    | Decouple abstraction from implementation so the two can vary independently. | Shape (abstraction) and Drawing API (implementation).                         |
| **Composite** | Treat individual objects and compositions uniformly.                        | Hierarchical structures like folders/files, menus.                            |
| **Decorator** | Add responsibilities to objects dynamically.                                | Adding scrollbars to a window, or logging to service calls.                   |
| **Facade**    | Provide a simplified interface to a complex subsystem.                      | Simplified API for a library or system (e.g., `NetflixFacade` for streaming). |
| **Flyweight** | Share objects to reduce memory usage.                                       | Reuse character objects in a text editor.                                     |
| **Proxy**     | Control access to another object.                                           | Remote proxy, security proxy, lazy loading.                                   |

---

### 🔄 **Behavioral Patterns**

> *These handle communication between objects.*

| Pattern                     | Purpose                                                                         | Example Use Case                                     |
| --------------------------- | ------------------------------------------------------------------------------- | ---------------------------------------------------- |
| **Observer**                | Notify multiple objects about state changes.                                    | Event handling in UI, pub-sub systems.               |
| **Strategy**                | Define a family of algorithms, encapsulate each, and make them interchangeable. | Sorting strategies, payment methods.                 |
| **Command**                 | Encapsulate a request as an object.                                             | Undo/redo operations in editors, GUI button actions. |
| **Chain of Responsibility** | Pass requests along a chain of handlers.                                        | Logging, exception handling, middleware pipelines.   |
| **Mediator**                | Reduce communication between objects by centralizing interactions.              | Chat room manager, air traffic control.              |
| **Template Method**         | Define the skeleton of an algorithm and let subclasses fill in the steps.       | Workflow templates, parsing algorithms.              |
| **State**                   | Allow an object to change its behavior when its state changes.                  | Traffic light states, game character modes.          |
| **Iterator**                | Provide a way to access elements sequentially without exposing structure.       | List, Set, custom collections.                       |
| **Visitor**                 | Separate an algorithm from the object structure it operates on.                 | Traversing different UI components or AST nodes.     |
| **Interpreter**             | Define grammar and interpret sentences.                                         | Expression parsers, rule engines (e.g., Drools).     |
| **Memento**                 | Capture and restore an object's state without violating encapsulation.          | Save/restore in games or editors.                    |

---

## ✅ Quick Visual for Pattern Selection

| Goal                                  | Suggested Pattern         |
| ------------------------------------- | ------------------------- |
| Ensure only one instance              | Singleton                 |
| Vary object creation                  | Factory, Abstract Factory |
| Build complex objects                 | Builder                   |
| Extend functionality at runtime       | Decorator                 |
| Simplify subsystem access             | Facade                    |
| Notify objects of changes             | Observer                  |
| Swap algorithms at runtime            | Strategy                  |
| Avoid tight coupling in communication | Mediator                  |

---

---

## 🧠 **Enterprise Application Patterns Cheat Sheet**

### 🧱 1. **Layered Architecture Patterns**

| Pattern                                | Description                                       | Example                      |
| -------------------------------------- | ------------------------------------------------- | ---------------------------- |
| **Presentation Layer**                 | Handles user interaction (UI/API).                | Spring MVC, REST controllers |
| **Business Layer**                     | Encapsulates core business logic.                 | Services with @Service       |
| **Persistence Layer (DAO/Repository)** | Handles data access and storage.                  | Spring Data JPA Repositories |
| **Integration Layer**                  | Interfaces with other systems (queues, services). | Kafka, REST clients          |

---

### 💡 2. **Domain Logic Patterns**

| Pattern                | Description                               | Example                                     |
| ---------------------- | ----------------------------------------- | ------------------------------------------- |
| **Transaction Script** | Logic written in services or controllers. | `orderService.placeOrder()`                 |
| **Domain Model**       | Rich OO model with entities + behavior.   | `Order.addItem()`, `Invoice.calculateTax()` |
| **Service Layer**      | Facade for business logic orchestration.  | `UserService.registerUser()`                |
| **Repository**         | Abstraction for data retrieval.           | `UserRepository.findByEmail()`              |

---

### 🔁 3. **Object-Relational Behavioral Patterns**

| Pattern          | Description                              | Example                       |
| ---------------- | ---------------------------------------- | ----------------------------- |
| **Unit of Work** | Track changes and commit in a batch.     | Hibernate session/transaction |
| **Identity Map** | Avoid duplicate objects in memory.       | JPA EntityManager cache       |
| **Lazy Load**    | Load related data on-demand.             | `@OneToMany(fetch = LAZY)`    |
| **Data Mapper**  | Translate between objects and DB schema. | JPA/Hibernate ORM             |

---

### 📦 4. **Data Access Patterns**

| Pattern                        | Description                                 | Example                       |
| ------------------------------ | ------------------------------------------- | ----------------------------- |
| **DAO (Data Access Object)**   | Encapsulate DB access logic.                | `ProductDAO.getAll()`         |
| **Repository**                 | Collection-like abstraction for aggregates. | Spring Data's `JpaRepository` |
| **DTO (Data Transfer Object)** | Lightweight object for transferring data.   | `UserDTO` for APIs            |

---

### 🚪 5. **Presentation Patterns**

| Pattern                         | Description                               | Example                          |
| ------------------------------- | ----------------------------------------- | -------------------------------- |
| **MVC (Model-View-Controller)** | Separate concerns of UI, logic, and data. | Spring MVC                       |
| **Front Controller**            | Central request handler.                  | `DispatcherServlet`, API Gateway |
| **View Helper**                 | Encapsulate presentation logic.           | Thymeleaf utility methods        |
| **Template View**               | Use templates for consistent layout.      | JSP, Thymeleaf layout dialect    |

---

### 🔗 6. **Integration Patterns**

| Pattern                      | Description                           | Example                                           |
| ---------------------------- | ------------------------------------- | ------------------------------------------------- |
| **Gateway / API Gateway**    | Entry point for APIs.                 | Spring Cloud Gateway, Zuul                        |
| **Adapter**                  | Translate incompatible interfaces.    | Legacy system wrapper                             |
| **Messaging / Event-Driven** | Async communication between services. | Kafka, RabbitMQ                                   |
| **Service Locator**          | Retrieve dependencies.                | ApplicationContext.getBean() (anti-pattern in DI) |

---

### 🔐 7. **Security Patterns**

| Pattern                            | Description                        | Example                       |
| ---------------------------------- | ---------------------------------- | ----------------------------- |
| **Authentication / Authorization** | Identity and permission checks.    | Spring Security with JWT      |
| **Access Control List (ACL)**      | Fine-grained permission control.   | Method-level access control   |
| **Secure Session Management**      | Secure handling of session tokens. | HTTP-only cookies, JWT expiry |

---

### 🧰 8. **Cross-Cutting Patterns**

| Pattern                               | Description                                  | Example                                           |
| ------------------------------------- | -------------------------------------------- | ------------------------------------------------- |
| **Dependency Injection**              | Inject dependencies rather than hard-coding. | Spring’s @Autowired                               |
| **Aspect-Oriented Programming (AOP)** | Modularize cross-cutting concerns.           | Logging, security, transactions                   |
| **Configuration Management**          | Externalize app config.                      | Spring Cloud Config, Kubernetes Secrets           |
| **Resilience Patterns**               | Fault-tolerant behaviors.                    | Circuit Breaker, Retry, Bulkhead via Resilience4j |

---
**Resilience Patterns Cheat Sheet**

These patterns are essential in designing **fault-tolerant, highly available systems**, especially in microservices and cloud-native architectures.

---

## 🔐 **Resilience Patterns Cheat Sheet**

These patterns help systems **survive failures**, **degrade gracefully**, and **recover quickly**.

---

### 🧯 1. **Retry**

* **Purpose**: Automatically retry failed operations (e.g., due to network glitches).
* **Use**: For transient failures (e.g., timeout, 5xx errors).
* **Caution**: Combine with exponential backoff to avoid overloading.
* ✅ Example: `@Retryable` in Spring Retry.

---

### 🔌 2. **Circuit Breaker**

* **Purpose**: Prevent cascading failures by stopping calls to a failing service.
* **States**:

    * **Closed**: Calls pass through.
    * **Open**: Calls fail immediately.
    * **Half-Open**: Trial calls allowed.
* ✅ Tools: Resilience4j, Netflix Hystrix (legacy), Istio.
* ✅ Spring Boot: `@CircuitBreaker(name = "service", fallbackMethod = "fallback")`

---

### 🛠️ 3. **Fallback**

* **Purpose**: Provide alternate behavior when the primary service fails.
* **Examples**:

    * Return cached data
    * Return default response
* ✅ Example: `fallbackMethod` in Resilience4j.

---

### ⏱️ 4. **Timeout**

* **Purpose**: Fail fast when a service is too slow or unresponsive.
* **Use**: Prevents resource exhaustion.
* ✅ Resilience4j: `@TimeLimiter`

---

### 🧩 5. **Bulkhead**

* **Purpose**: Isolate failures by allocating resources in separate pools.
* **Types**:

    * Thread-pool isolation
    * Semaphore isolation
* **Real-world analogy**: Watertight compartments in a ship.
* ✅ Example: Configure separate thread pools for external service calls.

---

### 📉 6. **Rate Limiting**

* **Purpose**: Control how many requests a system accepts over time.
* **Protects from**: Spikes, abuse, DoS attacks.
* ✅ Tools: Resilience4j RateLimiter, API Gateway throttling, Istio rate limiting.

---

### 🧵 7. **Load Shedding**

* **Purpose**: Proactively reject requests when the system is under stress.
* **Variants**:

    * Drop less important requests
    * Use queues or backpressure
* ✅ Often used with circuit breakers or custom logic.

---

### 💾 8. **Caching**

* **Purpose**: Reduce load and latency by storing responses.
* **Types**:

    * In-memory (e.g., Caffeine)
    * Distributed (e.g., Redis)
* ✅ Useful fallback strategy.

---

### 🎯 9. **Fail Fast**

* **Purpose**: Immediately reject operations that are likely to fail.
* **Use**: When the system is in a degraded or overloaded state.
* ✅ Prevents waste of system resources.

---

### 🔄 10. **Idempotency**

* **Purpose**: Ensure that retrying an operation won’t produce side effects.
* **Example**: Safely retrying POST payment without charging twice.
* ✅ Use idempotency keys in APIs.

---

## 📦 Tools That Implement These Patterns

| Tool                               | Patterns Supported                                           |
| ---------------------------------- | ------------------------------------------------------------ |
| **Resilience4j**                   | Retry, CircuitBreaker, TimeLimiter, Bulkhead, RateLimiter    |
| **Spring Cloud Circuit Breaker**   | Wraps Resilience4j or Hystrix                                |
| **Istio / Envoy**                  | Timeout, Retry, Rate Limit, Circuit Breaker (at mesh layer)  |
| **Kubernetes**                     | Liveness/readiness probes, resource quotas (for bulkheading) |
| **Netflix Hystrix** *(deprecated)* | Retry, CB, Fallback, Thread isolation                        |

---

