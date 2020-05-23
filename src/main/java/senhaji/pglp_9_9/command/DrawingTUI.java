package senhaji.pglp_9_9.command;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import  senhaji.pglp_9_9.dao.Bdd;
import senhaji.pglp_9_9.dao.daoabstract ;
import senhaji.pglp_9_9.dao.daobddfactory;
import senhaji.pglp_9_9.shape.Square;
import senhaji.pglp_9_9.shape.Cercle;
import senhaji.pglp_9_9.shape.Shape;
import senhaji.pglp_9_9.shape.Groupofshapes;
import senhaji.pglp_9_9.shape.Point;
import senhaji.pglp_9_9.shape.Rectangle;
import senhaji.pglp_9_9.shape.Triangle;

public class DrawingTUI {

    public Cmd nextCommand(final String cmd) {
        if (cmd.contains("=")) {
            Shape f = this.create(cmd);
            if (f != null) {
                return new createcmd(f);
            }
        } else if (cmd.contains("move")) {
            return this.move(cmd);
        } else if (!cmd.equalsIgnoreCase("exit")) {
            System.err.println("not exist cmd");
        }
        return null;
    }
  
    private boolean existingroup(final Shape f) {
        Connection connect = Bdd.getConnection();
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "SELECT * "
                    + "FROM Composition WHERE idComposant = ?");
            prepare.setString(1, f.getnameshape());
            ResultSet result = prepare.executeQuery();
            boolean b = result.next();
            connect.close();
            return b;
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connect.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            return false;
        }
    }
  
    public void show() {
    	daobddfactory factory = new daobddfactory();
        daoabstract <Cercle> daoCe = factory.getDaoCercle();
        daoabstract <Square> daoCa = factory.getDaoSquare();
        daoabstract <Rectangle> daoR = factory.getDaoRectangle();
        daoabstract <Triangle> daoT = factory.getDaoTriangle();
        daoabstract <Groupofshapes> daoG = factory.getDaoGroupeForme();
        ArrayList<Shape> Shapes = new ArrayList<Shape>();
        Shapes.addAll(daoCe.findAll());
        Shapes.addAll(daoCa.findAll());
        Shapes.addAll(daoR.findAll());
        Shapes.addAll(daoT.findAll());
        Shapes.addAll(daoG.findAll());
        for (Shape f : Shapes) {
            if (!this.existingroup(f)) {
                f.affiche();
            }
        }
        factory.close();
    }
   
    private Shape createCercle(
            final String IDShape, final String[] temp2) {
        String[] temp= temp2[1].split("Cercle");
        temp[1] = temp[1].substring(1, temp[1].length() - 1);
            temp = temp[1].split(",");
                Point p;
                int rayon;
                try {
                    p = new Point(temp[0] + "," + temp[1]);
                    rayon = Integer.parseInt(temp[2]);
                    return new Cercle(IDShape, p, rayon);
                } catch (Exception e) {
                    System.err.println("err de creation");    
        }
        return null;
    }
  
    private Shape createSquare(
            final String IDShape, final String[] temp2) {
      
        String[] temp = temp2[1].split("Square");
        
            temp[1] = temp[1].substring(1, temp[1].length() - 1);
            temp = temp[1].split(",");
          
                Point p;
                int length;
                try {
                    p = new Point(temp[0] + "," + temp[1]);
                    length = Integer.parseInt(temp[2]);
                    return new Square(IDShape, p, length);
                } catch (Exception e) {
                    System.err.println("err de creation");         
        }
        return null;
    }
   
    private Shape createRectangle(
            final String IDShape, final String[] temp2) {
      
        String[] temp = temp2[1].split("Rectangle");
       
        temp[1] = temp[1].substring(1, temp[1].length() - 1);
        temp = temp[1].split(",");
           
                Point p;
                int length;
                int width;
                try {
                  
                   p = new Point(temp[0] + "," + temp[1]);
                    length = Integer.parseInt(temp[2]);
                    width = Integer.parseInt(temp[3]);
                    return new Rectangle(
                            IDShape, p, length, width);
                } catch (Exception e) {
                    System.err.println("err de creation");
                
            }
        
        return null;
    }
   
    private Shape createTriangle(
            final String IDShape, final String[]  temp2) {
     
        String[]  temp =  temp2[1].split("Triangle");
       
        temp[1] =  temp[1].substring(1,  temp[1].length() - 1);
            temp =  temp[1].split(",");
           
            Point[] point = {null, null, null};
            try {
                
                point[0] = new Point( temp[0] + "," +  temp[1]);
                point[1] = new Point( temp[2] + "," +  temp[3]);
                point[2] = new Point( temp[4] + "," +  temp[5]);
                return new Triangle(IDShape, point[0], point[1], point[2]);
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("err de creation");
            
        }
        return null;
    }
 
    private Shape createGroupe(
            final String IDShape, final String[] temp2) {
        String[] temp= temp2[1].split("Groupe");
      
        	temp[1] = temp[1].substring(1, temp[1].length() - 1);
            temp = temp[1].split(",");
            return createComposantsGroupe(IDShape, temp);
       
    }
   
    private Shape createComposantsGroupe(
            final String IDShape, final String[] temp) {
        Groupofshapes gf = new Groupofshapes(IDShape);
        for (String s : temp) {
            Shape f = this.getshape(s);
            if (f != null) {
                gf.add(f);
            } else {
                return null;
            }
        }
        return gf;
    }
  
    private Shape getshape(final String IDShape) {
    	daobddfactory factory = new daobddfactory();
        daoabstract <Cercle> daoCe = factory.getDaoCercle();
        daoabstract <Square> daoCa = factory.getDaoSquare();
        daoabstract <Rectangle> daoR = factory.getDaoRectangle();
        daoabstract <Triangle> daoT = factory.getDaoTriangle();
        daoabstract <Groupofshapes> daoG = factory.getDaoGroupeForme();
        Shape f = daoCe.find(IDShape);
        if (f == null) {
            f = daoCa.find(IDShape);
        }
        if (f == null) {
            f = daoR.find(IDShape);
        }
        if (f == null) {
            f = daoT.find(IDShape);
        }
        if (f == null) {
            f = daoG.find(IDShape);
        }
        if (f == null) {
            System.err.println("Aucune Shape n'existe à ce nom : "
                    + IDShape);
        }
        factory.close();
        return f;
    }
  
    private Shape create(final String cmd2) {
        String[] temp;
        temp = cmd2.split("=");
        temp[0] = temp[0].trim();
        String IDShape = temp[0];
       
        	temp[1] = temp[1].replace(" ", "");
            Shape f = null;
            if (temp[1].contains("Cercle")) {
                f = this.createCercle(IDShape, temp);
            } else if (temp[1].contains("Square")) {
                f = this.createSquare(IDShape, temp);
            } else if (temp[1].contains("Rectangle")) {
                f = this.createRectangle(IDShape, temp);
            } else if (temp[1].contains("Triangle")) {
                f = this.createTriangle(IDShape, temp);
            } else if (temp[1].contains("Groupe")) {
                f = this.createGroupe(IDShape, temp);
            }
            return f;
        
        
    }
    
    private Cmd move(final String cmd2) {
      
        String cmd = cmd2.replace(" ", "");
        String[] temp = cmd.split("move");
        
        	temp[1] = temp[1].substring(1, temp[1].length() - 1);
            temp = temp[1].split(",");
          
                String IDShape;
                Point deplacement;
                try {
                    IDShape = temp[0];
                    deplacement = new Point(temp[1] + "," + temp[2]);
                    Shape f = this.getshape(IDShape);
                    if (f != null) {
                        return new movecmd(f, deplacement);
                    }
                } catch (Exception e) {
                    System.err.println("non exist cmd");
                    e.printStackTrace();
                }
            
       
        return null;
    }
   
  
 
}
