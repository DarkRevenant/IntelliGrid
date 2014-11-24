package org.sdsu.intelligrid.graphics;

import java.util.Random;

public class ChartData {

    // x is the hour number, 0, 1, 2, 3
    public static Point getDataFromReceiver(int x)
    {

        return new Point(x, generateRandomData());
    }

    private static int generateRandomData()
    {
        Random random = new Random();
        return random.nextInt(40);
    }
}

