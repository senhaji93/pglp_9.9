
package senhaji.pglp_9_9.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import senhaji.pglp_9_9.shape.Point;
import senhaji.pglp_9_9.shape.Rectangle;

public class daobddrect extends daoabstract <Rectangle> {
    
    private final Connection connect;
   
    public daobddrect(final Connection c) {
        connect = c;
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
    
    public Rectangle create(final Rectangle object) {
       
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "INSERT INTO Shape"
                    + " (IDShape)"
                    + " VALUES(?)");
                    prepare.setString(1, object.getnameshape());
                    prepare.executeUpdate();
            prepare = connect.prepareStatement(
                    "INSERT INTO Rectangle"
                    + " (IDShape,P_x,P_y,length,width)"
                    + " VALUES(?, ?, ?, ?, ?)");
            prepare.setString(1, object.getnameshape());
            prepare.setInt(2, object.getP().getX());
            prepare.setInt(3, object.getP().getY());
            prepare.setInt(4, object.getwidth());
            prepare.setInt(5, object.getlength());
            prepare.executeUpdate();
        } catch (SQLException e) {
            return null;
        }
        return object;
    }
   
    public Rectangle find(final String id) {
      
        Rectangle find = null;
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "SELECT * FROM Rectangle WHERE IDShape = ?");
            prepare.setString(1, id);
            ResultSet result = prepare.executeQuery();
            if (result.next()) {
                Point p = new Point(
                        result.getInt("P_x"),
                        result.getInt("P_y")
                );
                try {
                    find = new Rectangle(id, p,
                            result.getInt("length"),
                            result.getInt("width")
                    );
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return find;
    }
  
    public ArrayList<Rectangle> findAll() {
        ArrayList<Rectangle> find = new ArrayList<Rectangle>();
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "SELECT IDShape FROM Rectangle");
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                find.add(this.find(result.getString("IDShape")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<Rectangle>();
        }
        return find;
    }
   
    public Rectangle update(final Rectangle object) {
      
        final Rectangle before = this.find(object.getnameshape());
        if (before != null) {
            try {
                PreparedStatement prepare = connect.prepareStatement(
                "UPDATE Rectangle SET P_x = ?, P_y = ?, "
                + "length = ?, width = ? WHERE IDShape = ?");
                prepare.setInt(1, object.getP().getX());
                prepare.setInt(2, object.getP().getY());
                prepare.setInt(3, object.getlength());
                prepare.setInt(4, object.getwidth());
                prepare.setString(5, object.getnameshape());
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
   
    public void delete(final Rectangle object) {
       
        try {
            this.deleteComposant(object.getnameshape());
            PreparedStatement prepare = connect.prepareStatement(
                    "DELETE FROM Rectangle WHERE IDShape = ?");
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

