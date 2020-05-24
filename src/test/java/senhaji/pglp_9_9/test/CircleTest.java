package senhaji.pglp_9_9.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import senhaji.pglp_9_9.shape.Cercle;
import senhaji.pglp_9_9.shape.Point;

public class CircleTest {

    @Test
    public void testConstructor() throws Exception {
        Cercle c= new Cercle("c", new Point(3,3), 5);
        assertEquals(c.getNameshape(), "c");
        assertTrue(c.getRayon() == 5);
    }
    
    @Test
    public void testmove() throws Exception {
        Cercle c = new Cercle("c", new Point(3,3), 5);
        c.movepoint(3, 3);
        assertTrue(c.getCentre().toString().equals("Point [ getX()=6, getY()=6]"));
    }
    
}
