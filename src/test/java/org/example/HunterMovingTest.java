package org.example;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class HunterMovingTest {

    @Test
    void hunterShouldToMoveInCorrectDirection() {

        char[] insertedWayExample = {'N'};
        int visitedRoomsValue = 2;

        int visitedRoomsOneOrMoreTimesExample = HunterMoving.hunterMoving(insertedWayExample);

        assertEquals (visitedRoomsOneOrMoreTimesExample, visitedRoomsValue);
    }
    @Test
    void shouldReturnIllegalArgumentExceptionWhenDirectionIsWrong() {

        assertThrows(IllegalArgumentException.class,
                () -> {
                    char[] insertedWayExample = {'1'};
                    HunterMoving.hunterMoving(insertedWayExample);
                });
    }

}