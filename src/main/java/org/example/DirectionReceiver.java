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
