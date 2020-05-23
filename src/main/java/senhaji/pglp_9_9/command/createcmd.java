
package senhaji.pglp_9_9.command;

import senhaji.pglp_9_9.dao.daoabstract ;
import senhaji.pglp_9_9.dao.daobddfactory;
import senhaji.pglp_9_9.shape.Square;
import senhaji.pglp_9_9.shape.Cercle;
import senhaji.pglp_9_9.shape.Shape;
import senhaji.pglp_9_9.shape.Groupofshapes;
import senhaji.pglp_9_9.shape.Rectangle;
import senhaji.pglp_9_9.shape.Triangle;

public class createcmd implements Cmd {
  
    private Shape shape;
  
    public createcmd(final Shape sh) {
    	shape = sh;
    }
   
    public void execute() {
        Shape f;
        daobddfactory factory = new daobddfactory();
        if (shape.getClass() == Cercle.class) {
        	daoabstract <Cercle> dao = factory.getDaoCercle();
            f = dao.create((Cercle) shape);
        } else if (shape.getClass() == Square.class) {
        	daoabstract <Square> dao = factory.getDaoSquare();
            f = dao.create((Square) shape);
        } else if (shape.getClass() == Rectangle.class) {
        	daoabstract <Rectangle> dao = factory.getDaoRectangle();
            f = dao.create((Rectangle) shape);
        } else if (shape.getClass() == Triangle.class) {
        	daoabstract <Triangle> dao = factory.getDaoTriangle();
            f = dao.create((Triangle) shape);
        } else {
        	daoabstract <Groupofshapes> dao = factory.getDaoGroupeForme();
            f = dao.create((Groupofshapes) shape);
        }
        factory.close();
        if (f != null) {
            System.out.println( shape.getnameshape() + " Added.");
        } else {
            System.out.println("problem ...not added "
                    + shape.getnameshape());
        }
    }
}
