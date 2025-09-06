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
}
