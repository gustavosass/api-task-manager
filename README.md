# api-task-manager

```mermaid
classDiagram
    class User {
        +int id
        +String name
        +String email
        +String password
        +createTask(task: Task): void
        +updateTask(task: Task): void
        +deleteTask(taskId: int): void
        +getTasks(): List~Task~
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
        +markAsCompleted(): void
        +updateStatus(newStatus: Status): void
        +changePriority(newPriority: Priority): void
    }

    class Category {
        +int id
        +String name
        +List~Task~ tasks
        +addTask(task: Task): void
        +removeTask(task: Task): void
        +getTasks(): List~Task~
    }

    class Priority {
        <<enumeration>>
        LOW
        MEDIUM
        HIGH
    }

    class Status {
        <<enumeration>>
        PENDING
        IN_PROGRESS
        COMPLETED
    }

    User "N" --o "N" Task
    Category "1" --o "N" Task
    Task "1" --> "1" Priority
    Task "1" --> "1" Status
```
