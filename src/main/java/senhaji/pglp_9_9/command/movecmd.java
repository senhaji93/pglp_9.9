
package senhaji.pglp_9_9.command;

import senhaji.pglp_9_9.dao.daoabstract ;
import senhaji.pglp_9_9.dao.daobddfactory;
import senhaji.pglp_9_9.shape.Square;
import senhaji.pglp_9_9.shape.Cercle;
import senhaji.pglp_9_9.shape.Shape;
import senhaji.pglp_9_9.shape.Groupofshapes;
import senhaji.pglp_9_9.shape.Point;
import senhaji.pglp_9_9.shape.Rectangle;
import senhaji.pglp_9_9.shape.Triangle;

public class movecmd  implements Cmd {
   
    private Shape shape;
   
    private Point vecteur;
   
    public movecmd (final Shape sh, final Point move) {
        this.vecteur = move;
        shape = sh;
    }
   
    public void execute() {
        shape.movepoint(vecteur.getX(), vecteur.getY());
        daobddfactory factory = new daobddfactory();
        if (shape.getClass() == Cercle.class) {
        	daoabstract <Cercle> dao = factory.getDaoCercle();
            dao.update((Cercle) shape);
        } else if (shape.getClass() == Square.class) {
        	daoabstract <Square> dao = factory.getDaoSquare();
            dao.update((Square) shape);
        } else if (shape.getClass() == Rectangle.class) {
        	daoabstract <Rectangle> dao = factory.getDaoRectangle();
            dao.update((Rectangle) shape);
        } else if (shape.getClass() == Triangle.class) {
        	daoabstract <Triangle> dao = factory.getDaoTriangle();
            dao.update((Triangle) shape);
        } else {
        	daoabstract <Groupofshapes> dao = factory.getDaoGroupeForme();
            dao.update((Groupofshapes) shape);
        }
        factory.close();
    }
}
