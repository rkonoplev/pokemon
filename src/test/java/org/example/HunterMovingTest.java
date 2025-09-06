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
