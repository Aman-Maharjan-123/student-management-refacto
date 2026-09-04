# Student Management — Refactored

Refactor of the original `StudentManagement.doEverything(data, choice)` method
into a modular, single-responsibility design for CSE300 Applied Skills.

## Structure

- `Student.java` — domain model (replaces raw `String[]` data)
- `GradeCalculator.java` — average/grade logic, named grade-boundary constants
- `StudentRepository.java` — file persistence (try-with-resources, checked exceptions)
- `StudentRepositoryException.java` — domain-specific exception type
- `StudentService.java` — orchestrates repository + calculator (replaces `doEverything`)
- `StudentManagementApp.java` — demo entry point

## Run

```
cd src
javac *.java
java StudentManagementApp
```

## Original code

The original, unmodified source is kept in `/original` for comparison.
