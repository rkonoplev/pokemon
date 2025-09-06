# POKÉMON HUNTER - JAVA CONSOLE APPLICATION
# Complete Project Information for AI Analysis

## PROJECT OVERVIEW
This is a Java console application that simulates Ash catching Pokémon on an infinite 2D grid.
The goal is to count unique positions visited given a sequence of directional moves.

## PROBLEM STATEMENT
Ash catches Pokémon in an infinite 2D grid. Each house has exactly one Pokémon.
He starts at (0,0) and moves N/S/E/O (North/South/East/West).
If he revisits a house, there's no Pokémon to catch (already caught).
Goal: Count total unique Pokémon caught for a given move sequence.

Example: NSNNO → 4 Pokémon (positions: (0,0), (0,1), (0,2), (-1,2))

## TECHNOLOGY STACK
- Java 21 with Records and Switch Expressions
- Gradle 8 with Wrapper
- JUnit 5 Platform
- Maven support (alternative)

## SOURCE CODE FILES

### 1. Program.java (Main Entry Point)
```java
package org.example;

import java.util.Scanner;

/**
 * Main program to run the Pokémon catching simulation.
 */
public class Program {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input directions using symbols N, S, E, O (for example, NSNNO): ");
        String insertedString = input.nextLine();
        input.close();

        // Validate the path
        char[] wayClean = DirectionReceiver.directionCheck(insertedString);

        // Calculate number of captured Pokémon
        int pokemonSum = HunterMoving.hunterMoving(wayClean);
        System.out.println("Number of Pokémon is: " + pokemonSum);
    }
}
```

### 2. DirectionReceiver.java (Input Validation)
```java
package org.example;

/**
 * Utility class to validate and convert user input into a sequence of directions.
 */
class DirectionReceiver {

    /**
     * Validates and converts the inserted string into a char array of moves.
     * Allowed moves: N (north), S (south), E (east), O (west).
     *
     * @param insertedValue user input
     * @return validated char array of directions
     */
    static char[] directionCheck(String insertedValue) {
        if (insertedValue == null || insertedValue.isEmpty()) {
            throw new IllegalArgumentException("Empty string, please, try again.");
        }
        if (insertedValue.length() > 1000) {
            throw new IllegalArgumentException("String cannot be longer than 1000 characters.");
        }

        char[] checkedTotalWay = insertedValue.toCharArray();
        for (char c : checkedTotalWay) {
            if (c != 'N' && c != 'S' && c != 'E' && c != 'O') {
                throw new IllegalArgumentException("Invalid direction character: " + c);
            }
        }

        return checkedTotalWay;
    }
}
```

### 3. HunterMoving.java (Core Logic)
```java
package org.example;

import java.util.HashSet;
import java.util.Set;

/**
 * Handles hunter movement across the infinite grid.
 */
class HunterMoving {

    /**
     * Position on the grid, immutable (Java record).
     */
    private record Position(int x, int y) {

        Position move(char direction) {
            return switch (direction) {
                case 'N' -> new Position(x, y + 1);
                case 'S' -> new Position(x, y - 1);
                case 'E' -> new Position(x + 1, y);
                case 'O' -> new Position(x - 1, y);
                default -> throw new IllegalArgumentException("Incorrect direction value: " + direction);
            };
        }
    }

    /**
     * Simulates Ash's movement and counts unique visited positions (Pokémon caught).
     *
     * @param insertedWay array of directions
     * @return number of unique Pokémon caught
     */
    static int hunterMoving(char[] insertedWay) {
        Set<Position> visited = new HashSet<>();
        Position location = new Position(0, 0);
        visited.add(location);

        for (char oneSymbol : insertedWay) {
            location = location.move(oneSymbol);
            visited.add(location);
        }

        return visited.size();
    }
}
```

## TEST FILES

### 4. DirectionReceiverTest.java (Input Validation Tests)
```java
package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DirectionReceiverTest {

    @Test
    void shouldReturnCorrectCheckedDirection() {
        String str0 = "NNNO";
        final char[] expect = {'N', 'N', 'N', 'O'};
        char[] result = DirectionReceiver.directionCheck(str0);

        assertArrayEquals(expect, result);
        assertNotNull(result);
    }

    @Test
    void shouldReturnIllegalArgumentExceptionWhenDirectionIsEmpty() {
        assertThrows(IllegalArgumentException.class,
                () -> DirectionReceiver.directionCheck(""));
    }

    @Test
    void shouldReturnIllegalArgumentExceptionWhenDirectionIsTooLong() {
        assertThrows(IllegalArgumentException.class,
                () -> DirectionReceiver.directionCheck("N".repeat(1001)));
    }

    @Test
    void shouldReturnIllegalArgumentExceptionWhenDirectionHasInvalidChar() {
        assertThrows(IllegalArgumentException.class,
                () -> DirectionReceiver.directionCheck("NXS"));
    }

    @Test
    void shouldReturnIllegalArgumentExceptionWhenDirectionIsNull() {
        assertThrows(IllegalArgumentException.class,
                () -> DirectionReceiver.directionCheck(null));
    }

    @Test
    void shouldHandleSingleCharacterInput() {
        char[] result = DirectionReceiver.directionCheck("N");
        assertArrayEquals(new char[]{'N'}, result);
    }

    @Test
    void shouldHandleAllValidDirections() {
        char[] result = DirectionReceiver.directionCheck("NSEO");
        assertArrayEquals(new char[]{'N', 'S', 'E', 'O'}, result);
    }
}
```

### 5. HunterMovingTest.java (Logic Tests)
```java
package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HunterMovingTest {

    @Test
    void hunterShouldMoveInCorrectDirection() {
        char[] insertedWayExample = {'N'};
        int visitedRoomsValue = 2; // initial + one move

        int result = HunterMoving.hunterMoving(insertedWayExample);

        assertEquals(visitedRoomsValue, result);
    }

    @Test
    void shouldReturnIllegalArgumentExceptionWhenDirectionIsWrong() {
        assertThrows(IllegalArgumentException.class,
                () -> HunterMoving.hunterMoving(new char[]{'1'}));
    }

    @Test
    void shouldCountUniquePositionsOnly() {
        char[] insertedWay = {'N', 'S'}; // goes north, then back to start
        int result = HunterMoving.hunterMoving(insertedWay);

        assertEquals(2, result); // start + north
    }

    @Test
    void shouldHandleExampleFromProblemStatement() {
        char[] insertedWay = {'N', 'S', 'N', 'N', 'O'}; // NSNNO
        int result = HunterMoving.hunterMoving(insertedWay);

        assertEquals(4, result); // Expected result from problem statement
    }

    @Test
    void shouldHandleEmptyPath() {
        char[] insertedWay = {};
        int result = HunterMoving.hunterMoving(insertedWay);

        assertEquals(1, result); // Only starting position
    }

    @Test
    void shouldHandleAllDirections() {
        char[] insertedWay = {'N', 'E', 'S', 'O'}; // Square path
        int result = HunterMoving.hunterMoving(insertedWay);

        assertEquals(4, result); // Start + 3 unique positions (returns to start)
    }

    @Test
    void shouldHandleRepeatedVisits() {
        char[] insertedWay = {'E', 'O', 'E', 'O'}; // Back and forth
        int result = HunterMoving.hunterMoving(insertedWay);

        assertEquals(2, result); // Only start and east position
    }
}
```

## CONFIGURATION FILES

### 6. build.gradle (Gradle Configuration)
```gradle
plugins {
    id 'java'
    id 'application'
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    mainClass = 'org.example.Program'
}

repositories {
    mavenCentral()
}

dependencies {
    // JUnit Jupiter API & Engine
    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.10.2'
    testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.10.2'
    testRuntimeOnly 'org.junit.platform:junit-platform-launcher:1.10.2'

    // Optional: assertion utilities
    testImplementation 'org.assertj:assertj-core:3.26.0'
}

tasks.test {
    useJUnitPlatform() // Enable JUnit 5 Platform
}
```

### 7. pom.xml (Maven Configuration)
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>pokemon</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>21</maven.compiler.source>
        <maven.compiler.target>21</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>5.10.2</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-engine</artifactId>
            <version>5.10.2</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.assertj</groupId>
            <artifactId>assertj-core</artifactId>
            <version>3.26.0</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.0.0</version>
            </plugin>
        </plugins>
    </build>
</project>
```

### 8. settings.gradle (Project Settings)
```gradle
rootProject.name = 'pokemon-hunter'
```

## HOW TO USE THIS INFORMATION
This file contains the complete Pokemon Hunter Java project for AI analysis.
You can copy and paste this entire content to any AI platform for:
- Code review and suggestions
- Bug analysis and fixes
- Feature enhancements
- Architecture improvements
- Test coverage analysis
- Performance optimization suggestions

## BUILD AND RUN COMMANDS
```bash
# Build project
./gradlew build

# Run application
./gradlew run

# Run tests
./gradlew test

# Create JAR
./gradlew jar
```

## KEY FEATURES TO ANALYZE
1. Java 21 Records usage in Position class
2. Switch expressions for direction handling
3. HashSet for unique position tracking
4. Input validation with comprehensive error handling
5. JUnit 5 test coverage (14 test cases)
6. Gradle and Maven dual build support

## TEST COVERAGE SUMMARY
- DirectionReceiverTest: 7 tests (null, empty, length, invalid chars, single char, all directions)
- HunterMovingTest: 7 tests (basic movement, invalid direction, unique counting, problem example, empty path, square path, repeated visits)
- Total: 14 comprehensive test cases covering all functionality and edge cases