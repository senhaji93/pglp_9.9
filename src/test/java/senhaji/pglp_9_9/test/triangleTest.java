package senhaji.pglp_9_9.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import senhaji.pglp_9_9.shape.Point;
import senhaji.pglp_9_9.shape.Triangle;

public class triangleTest {
	@Test
    public void testConstructor() {
        Triangle t = new Triangle("triangle", new Point(3,3), new Point(5,1), new Point(5,3));
        assertEquals(t.getNameshape(), "triangle");
        assertTrue(t.getPoint(0).toString().equals("Point [ getX()=3, getY()=3]"));
        assertTrue(t.getPoint(1).toString().equals("Point [ getX()=5, getY()=1]"));
        assertTrue(t.getPoint(2).toString().equals("Point [ getX()=5, getY()=3]"));
    }
   
    @Test
    public void testMove() {
    	  Triangle t = new Triangle("triangle", new Point(3,3), new Point(5,1), new Point(5,3));
        t.movepoint(3, 3);
        assertTrue(t.getPoint(0).toString().equals("Point [ getX()=6, getY()=6]"));
        assertTrue(t.getPoint(1).toString().equals("Point [ getX()=8, getY()=4]"));
        assertTrue(t.getPoint(2).toString().equals("Point [ getX()=8, getY()=6]"));
    }
}
