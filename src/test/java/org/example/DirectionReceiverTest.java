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
