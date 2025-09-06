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
