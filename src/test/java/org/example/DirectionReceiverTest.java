package org.example;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

class DirectionReceiverTest {

    @Test
    void shouldReturnCorrectCheckedDirection() {
        String str0 =  "NNNO";
        final char[] expect = { 'N', 'N', 'N', 'O' };
        char[] expectedResult = DirectionReceiver.directionCheck(str0);

        Assert.assertEquals (expectedResult, expect);
        Assert.assertNotNull(expectedResult);


    }
    @Test
    void shouldReturnIllegalArgumentExceptionWhenDirectionIsNull() {

        Assert.assertThrows(IllegalArgumentException.class,
                () -> {
                    String str1 = "";
                    DirectionReceiver.directionCheck(str1);
                });
    }

    @Test
    void shouldReturnIllegalArgumentExceptionWhenDirectionIsLong() {


        Assert.assertThrows (IllegalArgumentException.class,
                () -> {
                    String str2 = "N".repeat(1001);
                    DirectionReceiver.directionCheck(str2);
                });

    }
}
