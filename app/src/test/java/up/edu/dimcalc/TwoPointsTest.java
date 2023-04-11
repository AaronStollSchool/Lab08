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

    @Test
    public void randomValue() {
    }

    @Test
    public void setOrigin() {
    }

    @Test
    public void copy() {
    }

    @Test
    public void distance() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 3, 3);
        testPoints.setPoint(1,6,-1);
        double distance = testPoints.distance();
        assertEquals(5, distance, 0.001);

        testPoints.setPoint(0, 2, 4);
        testPoints.setPoint(1,6,10);
        distance = testPoints.distance();
        assertEquals(7.21110255093, distance, 0.01);
    }

    @Test
    public void slope() {
    }
}