package senhaji.pglp_9_9.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import senhaji.pglp_9_9.shape.Cercle;
import senhaji.pglp_9_9.shape.Point;

public class Daobbdcircle extends daoabstract <Cercle> {
   
    private final Connection connect;
   
    public Daobbdcircle(final Connection c) {
        connect = c;
    }
   
    private void deleteComposant(final String id) {
      
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "DELETE FROM Composition WHERE idComposant = ?");
            prepare.setString(1, id);
            prepare.executeUpdate();
            
        } catch (SQLException e) {
        	  System.out.println("not delet");
        }
    }
    
    public Cercle create(final Cercle object) {
     
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "INSERT INTO Shape"
                    + " (IDShape)"
                    + " VALUES(?)");
                    prepare.setString(1, object.getnameshape());
                    prepare.executeUpdate();
            prepare = connect.prepareStatement(
                    "INSERT INTO Cercle"
                    + " (IDShape,P_x,P_y,rayon)"
                    + " VALUES(?, ?, ?, ?)");
            prepare.setString(1, object.getnameshape());
            prepare.setInt(2, object.getCentre().getX());
            prepare.setInt(3, object.getCentre().getY());
            prepare.setInt(4, object.getRayon());
            prepare.executeUpdate();
            System.out.println("created");
        } catch (SQLException e) {
            return null;
        }
        return object;
    }
   
    public Cercle find(final String id) {
      
        Cercle find = null;
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "SELECT * FROM Cercle WHERE IDShape = ?");
            prepare.setString(1, id);
            ResultSet result = prepare.executeQuery();
            if (result.next()) {
                Point centre = new Point(
                        result.getInt("P_x"),
                        result.getInt("P_y"));
                System.out.println("found");
                try {
                    find = new Cercle(id, centre, result.getInt("rayon"));
                } catch (Exception e) {
                	  System.out.println("not find");
                    e.printStackTrace();
                    return null;
                }
            }
        } catch (SQLException e) {
        	  System.out.println("not find");
            e.printStackTrace();
            return null;
        }
        return find;
    }
   
    public ArrayList<Cercle> findAll() {
        ArrayList<Cercle> find = new ArrayList<Cercle>();
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "SELECT IDShape FROM Cercle");
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                find.add(this.find(result.getString("IDShape")));
            }
        } catch (SQLException e) {
        	  System.out.println("not find");
            e.printStackTrace();
            return new ArrayList<Cercle>();
        }
        return find;
    }

    @Override
    public Cercle update(final Cercle object) {
      
        final Cercle before = this.find(object.getnameshape());
        if (before != null) {
            try {
                PreparedStatement prepare = connect.prepareStatement(
                "UPDATE Cercle SET P_x = ?, P_y = ?, "
                + "rayon = ? WHERE IDShape = ?");
                prepare.setInt(1, object.getCentre().getX());
                prepare.setInt(2, object.getCentre().getY());
                prepare.setInt(3, object.getRayon());
                prepare.setString(4, object.getnameshape());
                prepare.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                return before;
            }
        } else {
            return null;
        }
        return object;
    }
    public void delete(final Cercle object) {
    
        try {
            this.deleteComposant(object.getnameshape());
            PreparedStatement prepare = connect.prepareStatement(
                    "DELETE FROM Cercle WHERE IDShape = ?");
            prepare.setString(1, object.getnameshape());
            prepare.executeUpdate();
            prepare = connect.prepareStatement(
                    "DELETE FROM Shape WHERE IDShape = ?");
            prepare.setString(1, object.getnameshape());
            prepare.executeUpdate();
        } catch (SQLException e) {
        	  System.out.println("not delet");
            e.printStackTrace();
        }
    }
}
