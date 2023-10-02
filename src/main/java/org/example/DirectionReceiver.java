package org.example;

import java.util.Scanner;

class DirectionReceiver {
    static char[] directionCheck(String insertedValue){

        char[] checkedTotalWay = insertedValue.toCharArray();
        if (insertedValue.isEmpty()){
            throw new IllegalArgumentException("Empty string, please, try again.");
        } else
        if (insertedValue.length() > 1000 ){
            throw new IllegalArgumentException("String can not mere than 1000 characters.");
        }
        return checkedTotalWay;
    }
}
