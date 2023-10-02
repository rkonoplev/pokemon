package org.example;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
class HunterMoving {

    static int hunterMoving(char[] insertedWay){
        // Initial position of hunter
        int visitedRooms = 1;
        int x = 0;
        int y = 0;
        int xn;
        int yn;
        Point location = new Point(x, y);
        // Array for visited rooms
        List<Point> listOfRooms = new ArrayList<>();
        // Write the position of hunter (same that room) to array
        listOfRooms.add(new Point(0,0));
        for (char oneSymbol : insertedWay) {
                switch (oneSymbol) {
                    case 'N' -> {
                        xn = location.getLocation().x;
                        yn = location.getLocation().y;
                        location.move(xn, yn + 1);
                    }
                    case 'S' -> {
                        xn = location.getLocation().x;
                        yn = location.getLocation().y;
                        location.move(xn, yn - 1);
                    }
                    case 'E' -> {
                        xn = location.getLocation().x;
                        yn = location.getLocation().y;
                        location.move(xn + 1, yn);
                    }
                    case 'O' -> {
                        xn = location.getLocation().x;
                        yn = location.getLocation().y;
                        location.move(xn - 1, yn);
                    }
                    default ->
                            throw new IllegalArgumentException("Incorrect direction value");
                }

                if (!listOfRooms.contains(location)) {
                    xn = location.getLocation().x;
                    yn = location.getLocation().y;
                    listOfRooms.add(new Point(xn, yn));
                    ++visitedRooms;
                }
        }
        return visitedRooms;
    }
}