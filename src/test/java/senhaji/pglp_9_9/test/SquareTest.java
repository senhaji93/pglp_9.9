package senhaji.pglp_9_9.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;



import org.junit.Test;
import senhaji.pglp_9_9.shape.Point;
import senhaji.pglp_9_9.shape.Square;

public class SquareTest {
	 @Test
	    public void testConstructor() throws Exception {
	        Square s = new Square("square", new Point(1,1), 10);
	        assertEquals(s.getNameshape(), "square");
	        assertTrue(s.getlength() == 10);
	    }
	 @Test
	    public void testmove() throws Exception {
		 Square s = new Square("square", new Point(3,3), 10);
	        s.movepoint(3, 3);
	        assertTrue(s.getP().toString().equals("Point [ getX()=6, getY()=6]"));
	     
	    }
}
