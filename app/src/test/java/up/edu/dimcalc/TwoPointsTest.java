package up.edu.dimcalc;

import static org.junit.Assert.*;

import android.graphics.Point;

import org.junit.Test;

public class TwoPointsTest {

    /** when created, getPoint() should show both points at the origin */
    @Test
    public void getPoint() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(0, p1.x);
        assertEquals(0, p1.y);
        assertEquals(0, p2.x);
        assertEquals(0, p2.y);
    }

    /** verify that arbitrary values are properly stored via setPoint() */
    @Test
    public void setPoint() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 5, -3);
        testPoints.setPoint(1, -3, 5);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(5, p1.x);
        assertEquals(-3, p1.y);
        assertEquals(-3, p2.x);
        assertEquals(5, p2.y);
    }

    /**  */
    @Test
    public void randomValue() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        testPoints.randomValue(0);
        testPoints.randomValue(1);

        int p1AX = testPoints.getPoint(0).x;
        int p1AY = testPoints.getPoint(0).y;
        int p2AX = testPoints.getPoint(1).x;
        int p2AY = testPoints.getPoint(1).y;

        testPoints.randomValue(0);
        testPoints.randomValue(1);

        int p1BX = testPoints.getPoint(0).x;
        int p1BY = testPoints.getPoint(0).y;
        int p2BX = testPoints.getPoint(1).x;
        int p2BY = testPoints.getPoint(1).y;

        assertNotEquals(p1AX, p1BX);
        assertNotEquals(p1AY, p1BY);
        assertNotEquals(p2AX, p2BX);
        assertNotEquals(p2AY, p2BY);
    }

    /**  */
    @Test
    public void setOrigin() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0,5,10);
        testPoints.setPoint(1,3,2);

        testPoints.setOrigin(0);
        testPoints.setOrigin(1);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);

        assertEquals(0, p1.x);
        assertEquals(0, p1.y);
        assertEquals(0, p2.x);
        assertEquals(0, p2.y);

    }

    @Test
    public void copy() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, -4, 6);
        testPoints.setPoint(1, 3, 4);

        testPoints.copy(0,1);

        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);

        assertEquals(-4, p1.x);
        assertEquals(6, p1.y);
        assertEquals(-4, p2.x);
        assertEquals(6, p2.y);

        testPoints.setPoint(1, 3, 4);
        p2 = testPoints.getPoint(1);

        assertEquals(-4, p1.x);
        assertEquals(6, p1.y);
        assertEquals(3, p2.x);
        assertEquals(4, p2.y);
    }

    @Test
    public void distance() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 3, 3);
        testPoints.setPoint(1,6,-1);
        double distance = testPoints.distance();
        assertEquals(5, distance, 0.001);

        testPoints.setPoint(0, -2, -4);
        testPoints.setPoint(1,-6,-10);
        distance = testPoints.distance();
        assertEquals(7.21110255093, distance, 0.01);
    }

    @Test
    public void slope() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 1,2);
        testPoints.setPoint(1, 9,2);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        double slope = (double)(p2.y-p1.y)/(p2.x-p1.x);
        double testSlope = testPoints.slope();
        assertEquals(slope, testSlope, 0.0);
    }
}