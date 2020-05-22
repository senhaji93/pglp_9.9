
package senhaji.pglp_9_9.dao;

import java.sql.Connection;
import java.sql.SQLException;

import  senhaji.pglp_9_9.dao.Bdd;
import senhaji.pglp_9_9.shape.Square;
import senhaji.pglp_9_9.shape.Cercle;
import senhaji.pglp_9_9.shape.Groupofshapes;
import senhaji.pglp_9_9.shape.Rectangle;
import senhaji.pglp_9_9.shape.Triangle;

public class daobddfactory {
  
    private Connection connect;
    
    public daobddfactory() {
        connect = Bdd.getConnection();
    }
  
    public void close() {
        try {
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   
    public daoabstract  <Cercle> getDaoCercle() {
        return new Daobbdcircle(connect);
    }
   
    public daoabstract <Square> getDaoSquare() {
        return new  daobddsquare(connect);
    }
    
    public daoabstract <Rectangle> getDaoRectangle() {
        return new daobddrect(connect);
    }
   
    public daoabstract <Triangle> getDaoTriangle() {
        return new daobddtriangle(connect);
    }
  
    public daoabstract <Groupofshapes> getDaoGroupeForme() {
        return new daobddgrshape(connect);
    }
}
