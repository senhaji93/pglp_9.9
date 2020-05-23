
package senhaji.pglp_9_9.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import senhaji.pglp_9_9.shape.Square;
import senhaji.pglp_9_9.shape.Cercle;
import senhaji.pglp_9_9.shape.Shape;
import senhaji.pglp_9_9.shape.Groupofshapes;
import senhaji.pglp_9_9.shape.Rectangle;
import senhaji.pglp_9_9.shape.Triangle;

public class daobddgrshape extends daoabstract<Groupofshapes> {
  
    private final Connection connect;
   
    public daobddgrshape(final Connection c) {
        connect = c;
    }
    
    public void createComposition(
            final String idGroupe, final String idComposant) {
     
        try {
            PreparedStatement prepare = connect.prepareStatement(
            "INSERT INTO Composition"
            + " (idGroupe, idComposant)"
            + " VALUES(?, ?)");
            prepare.setString(1, idGroupe);
            prepare.setString(2, idComposant);
            prepare.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    public ArrayList<Shape> findComposition(final String id) {
      
        ArrayList<Shape> find = new ArrayList<Shape>();
        daobddfactory factory = new daobddfactory();
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "SELECT idComposant "
                    + "FROM Composition WHERE idGroupe = ?");
            prepare.setString(1, id);
            ResultSet result = prepare.executeQuery();
            daoabstract <Cercle> daoCe = factory.getDaoCercle();
            daoabstract <Square> daoCa = factory.getDaoSquare();
            daoabstract <Rectangle> daoR = factory.getDaoRectangle();
            daoabstract <Triangle> daoT = factory.getDaoTriangle();
            while (result.next()) {
                Shape f = daoCe.find(result.getString("idComposant"));
                if (f == null) {
                    f = daoCa.find(result.getString("idComposant"));
                }
                if (f == null) {
                    f = daoR.find(result.getString("idComposant"));
                }
                if (f == null) {
                    f = daoT.find(result.getString("idComposant"));
                }
                if (f == null) {
                    f = this.find(result.getString("idComposant"));
                }
                find.add(f);
            }
            factory.close();
        } catch (SQLException e) {
            factory.close();
            return new ArrayList<Shape>();
        }
        return find;
    }
   
    public void deleteComposition(final String id) {
        
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "DELETE FROM Composition WHERE idGroupe = ?");
            prepare.setString(1, id);
            prepare.executeUpdate();
        } catch (SQLException e) {
        }
    }
   
    private void deleteComposant(final String id) {
       
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "DELETE FROM Composition WHERE idComposant = ?");
            prepare.setString(1, id);
            prepare.executeUpdate();
        } catch (SQLException e) {
        }
    }
  
    public Groupofshapes create(final Groupofshapes object) {
       
    	daobddfactory factory = new daobddfactory();
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "INSERT INTO Shape"
                    + " (IDShape)"
                    + " VALUES(?)");
            prepare.setString(1, object.getnameshape());
            prepare.executeUpdate();
            prepare = connect.prepareStatement(
                    "INSERT INTO GroupeShape"
                    + " (IDShape)"
                    + " VALUES(?)");
            prepare.setString(1, object.getnameshape());
            prepare.executeUpdate();
            for (Shape f : object.getList()) {
                if (f.getClass() == Cercle.class) {
                	daoabstract <Cercle> dao = factory.getDaoCercle();
                    dao.create((Cercle) f);
                } else if (f.getClass() == Square.class) {
                	daoabstract <Square> dao = factory.getDaoSquare();
                    dao.create((Square) f);
                } else if (f.getClass() == Rectangle.class) {
                	daoabstract <Rectangle> dao = factory.getDaoRectangle();
                    dao.create((Rectangle) f);
                } else if (f.getClass() == Triangle.class) {
                	daoabstract <Triangle> dao = factory.getDaoTriangle();
                    dao.create((Triangle) f);
                } else {
                    this.create((Groupofshapes) f);
                }
                this.createComposition(
                        object.getnameshape(), f.getnameshape());
            }
            factory.close();
        } catch (SQLException e) {
            factory.close();
            return null;
        }
        return object;
    }
   
    public Groupofshapes find(final String id) {
        
        Groupofshapes find = null;
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "SELECT * FROM GroupeShape WHERE IDShape = ?");
            prepare.setString(1, id);
            ResultSet result = prepare.executeQuery();
            if (result.next()) {
                find = new Groupofshapes(id);
                ArrayList<Shape> list = findComposition(id);
                for (Shape f : list) {
                    find.add(f);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return find;
    }
   
    public ArrayList<Groupofshapes> findAll() {
        ArrayList<Groupofshapes> find = new ArrayList<Groupofshapes>();
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "SELECT IDShape FROM GroupeShape");
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                find.add(this.find(result.getString("IDShape")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<Groupofshapes>();
        }
        return find;
    }
  
    public Groupofshapes update(final Groupofshapes object) {
        ArrayList<Shape> contenu = this.findComposition(
                object.getnameshape());
        if (!contenu.isEmpty()) {
            this.deleteComposition(object.getnameshape());
            daobddfactory factory = new daobddfactory();
            for (Shape f : object.getList()) {
                if (f.getClass() == Cercle.class) {
                	daoabstract <Cercle> dao = factory.getDaoCercle();
                    dao.create((Cercle) f);
                } else if (f.getClass() == Square.class) {
                	daoabstract <Square> dao = factory.getDaoSquare();
                    dao.create((Square) f);
                } else if (f.getClass() == Rectangle.class) {
                	daoabstract <Rectangle> dao = factory.getDaoRectangle();
                    dao.create((Rectangle) f);
                } else if (f.getClass() == Triangle.class) {
                	daoabstract <Triangle> dao = factory.getDaoTriangle();
                    dao.create((Triangle) f);
                } else {
                    this.create((Groupofshapes) f);
                }
                this.createComposition(
                        object.getnameshape(), f.getnameshape());
            }
            factory.close();
        } else {
            return null;
        }
        return object;
    }

    public void delete(final Groupofshapes object) {
       
        try {
            this.deleteComposition(object.getnameshape());
            this.deleteComposant(object.getnameshape());
            PreparedStatement prepare = connect.prepareStatement(
                    "DELETE FROM GroupeShape WHERE IDShape = ?");
            prepare.setString(1, object.getnameshape());
            prepare.executeUpdate();
            prepare = connect.prepareStatement(
                    "DELETE FROM Shape WHERE IDShape = ?");
            prepare.setString(1, object.getnameshape());
            prepare.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
