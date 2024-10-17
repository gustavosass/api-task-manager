
# Desafio - Claro - Java com Spring Boot

Criação de uma API Rest para gerenciamento de tarefas.


## 🚀 Principais Tecnologias
- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **OpenAPI (Swagger)**
- **PostgreSQL**
- **Railway**


## Variáveis de Ambiente

Para rodar esse projeto, você vai precisar adicionar as seguintes variáveis de ambiente.

- `SPRING_PROFILES_ACTIVE` **'HML' ou 'PROD'**
- `PGHOST`
- `PGPORT`
- `PGDATABASE`
- `PGUSER`
- `PGPASSWORD`

# Diagrama

```mermaid
classDiagram
    class User {
        +int id
        +String name
        +String email
        +String password
        +List~Role~ roles;
         +createUser(user: User): void
        +updateUser(user: User): void
        +deleteUser(userId: int): void
        +getUsers(): List~User~
    }

    class Task {
        +int id
        +String title
        +String description
        +Date dueDate
        +Priority priority
        +Status status
        +Category category
        +List~User~ user
         +createTask(task: Task): void
        +updateTask(task: Task): void
        +deleteTask(taskId: int): void
        +getTasks(): List~Task~
        +markAsCompleted(): void
        +updateStatus(newStatus: Status): void
        +changePriority(newPriority: Priority): void
    }

    class Category {
        +int id
        +String name
        +createCategory(category: Category): void
        +updateCategory(category: Category): void
        +deleteCategory(categoryId: int): void
        +getCategory(): List~Category~
    }

    class Priority {
        <<enumeration>>
        LOW
        NORMAL
        HIGH
        URGENT
    }

    class Status {
        <<enumeration>>
        PENDING
        IN_PROGRESS
        COMPLETED
    }

    class Role {
        <<enumeration>>
        USER
        ADMIN
    }

    User "N" --o "N" Task
    Category "1" --o "N" Task
    Task "1" --> "1" Priority
    Task "1" --> "1" Status
    User "1" --> "N" Role
```
# CI/CD com Railway e Github.
![image](https://github.com/user-attachments/assets/9199d7c4-0035-4208-85ad-5b25dd9f4d78)
![image](https://github.com/user-attachments/assets/b545b22f-fbf6-4744-90d0-0680170f3145)

