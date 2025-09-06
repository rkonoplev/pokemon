# Pokémon Hunter – Java Console App

## 📝 Problem Statement

Ash is catching Pokémon in a world that consists of an infinite two-dimensional grid of houses.  
In each house there is exactly one Pokémon.  

Ash starts by catching the Pokémon that is in the house where he starts.  
Then, he moves to the house immediately to the north, south, east or west of where he is and catches the Pokémon there, and so on.  

⚠️ If he passes by a house he has already been to (and therefore already caught the Pokémon), there is no Pokémon to catch anymore!  

👉 **The goal:** starting with a world full of Pokémon (one in each house), how many Pokémon does Ash catch for a given sequence of moves?

---

## 💡 Example

**Input:**
```
NSNNO
```

**Output:**
```
Number of Pokémon is: 4
```

**Explanation:** Ash starts at (0,0), moves North to (0,1), South back to (0,0), North to (0,1) again, North to (0,2), then West to (-1,2). Unique positions visited: (0,0), (0,1), (0,2), (-1,2) = 4 Pokémon caught.

---

## 🧭 Input Format

**Valid Directions:**
- `N` - North (move up: y + 1)
- `S` - South (move down: y - 1)  
- `E` - East (move right: x + 1)
- `O` - West (move left: x - 1) *[Oeste in Portuguese]*

**Input Rules:**
- Non-empty string
- Maximum 1000 characters
- Only contains N, S, E, O characters
- Case-sensitive (uppercase only)

---

## ⚙️ Technology Stack

- Java 21 with Records and Switch Expressions
- Gradle 8 (via Wrapper, no local installation needed)  
- JUnit 5 Platform with comprehensive test coverage
- Maven support (alternative build system)  

---

## 📂 Project Structure

| Directory/File                              | Description                        |
|---------------------------------------------|------------------------------------|  
| `pokemon/`                                  | Root directory of the project      |
| `├── build.gradle`                          | Gradle build configuration         |
| `├── settings.gradle`                       | Gradle project settings            |
| `├── pom.xml`                               | Maven build configuration (alternative) |
| `├── gradlew`                               | Gradle wrapper (Linux/Mac)         |
| `├── gradlew.bat`                           | Gradle wrapper (Windows)           |
| `├── gradle/wrapper/`                       | Wrapper bootstrap files            |
| `├── .gitignore`                            | Git ignore file                    |
| `├── README.md`                             | Project documentation              |
| `├── LICENSE`                               | MIT License file                   |
| `├── .gradle/`                              | Gradle cache (ignored in Git)      |
| `├── build/`                                | Build output (ignored in Git)      |
| `├── target/`                               | Maven build output (ignored in Git) |
| `├── src/main/java/org/example/`            | Application source code            |
| `│   ├── Program.java`                      | Main entry point class            |
| `│   ├── DirectionReceiver.java`            | Input validation utility           |
| `│   └── HunterMoving.java`                 | Pokemon catching logic             |
| `├── src/main/resources/`                   | Application resources              |
| `├── src/test/java/org/example/`            | Unit tests                         |
| `│   ├── DirectionReceiverTest.java`        | Tests for input validation         |
| `│   └── HunterMovingTest.java`             | Tests for movement logic           |

---

## ▶️ How to Run

### 1. Build the project
```bash
./gradlew build
```

### 2. Run the program
```bash
./gradlew run
```

### 3. Run the tests
```bash
./gradlew test
```

### 4. Build an executable JAR
```bash
./gradlew jar
```
The JAR file will be created at:
```bash
build/libs/pokemon-hunter.jar
```

### 5. Run the JAR directly
```bash
java -jar build/libs/pokemon-hunter.jar
```

---

## 🧪 Test Coverage

### DirectionReceiverTest (7 tests)
- Valid input parsing and conversion
- Null input validation
- Empty string validation  
- Input length validation (>1000 characters)
- Invalid character detection
- Single character input handling
- All valid directions (N, S, E, O)

### HunterMovingTest (7 tests)
- Basic movement validation
- Invalid direction handling
- Unique position counting
- Problem statement example (NSNNO → 4)
- Empty path edge case
- Complex movement patterns
- Repeated visit scenarios

**Total: 14 comprehensive test cases** covering all functionality and edge cases.

---

## 🧩 Solution Description

- **DirectionReceiver**: validates input (non-empty, ≤1000 characters, only N, S, E, O). Handles null inputs and invalid characters.
- **HunterMoving**: simulates Ash's path on an infinite 2D grid using an immutable record `Position(int x, int y)` and a `HashSet` to track visited positions. Counts unique houses visited.
- **Program**: entry point – reads input, calls the logic, prints the number of Pokémon caught.
- **Comprehensive JUnit tests**: 14 test cases covering input validation, edge cases, movement logic, and the exact problem example (NSNNO → 4).

---

## 📜 License
MIT License – See  [LICENSE](LICENSE) git for details.