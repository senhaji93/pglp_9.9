
package senhaji.pglp_9_9.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import senhaji.pglp_9_9.shape.Point;
import senhaji.pglp_9_9.shape.Triangle;


public class daobddtriangle extends daoabstract <Triangle> {
  
    private final Connection connect;
 
    public daobddtriangle(final Connection c) {
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
   
    public Triangle create(final Triangle object) {
       
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "INSERT INTO Shape"
                    + " (IDShape)"
                    + " VALUES(?)");
                    prepare.setString(1, object.getnameshape());
                    prepare.executeUpdate();
            prepare = connect.prepareStatement(
                    "INSERT INTO Triangle"
                    + " (IDShape,"
                    + "point1_x,point1_y,"
                    + "point2_x,point2_y,"
                    + "point3_x,point3_y)"
                    + " VALUES(?, ?, ?, ?, ?, ?, ?)");
            prepare.setString(1, object.getnameshape());
            prepare.setInt(2, object.getPoint(0).getX());
            prepare.setInt(3, object.getPoint(0).getY());
            prepare.setInt(4, object.getPoint(1).getX());
            prepare.setInt(5, object.getPoint(1).getY());
            prepare.setInt(6, object.getPoint(2).getX());
            prepare.setInt(7, object.getPoint(2).getY());
            prepare.executeUpdate();
        } catch (SQLException e) {
            return null;
        }
        return object;
    }
  
    public Triangle find(final String id) {
        
        Triangle find = null;
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "SELECT * FROM Triangle WHERE IDShape = ?");
            prepare.setString(1, id);
            ResultSet result = prepare.executeQuery();
            if (result.next()) {
                Point[] p = {
                    new Point(
                            result.getInt("point1_x"),
                            result.getInt("point1_y")),
                    new Point(
                            result.getInt("point2_x"),
                            result.getInt("point2_y")),
                    new Point(
                            result.getInt("point3_x"),
                            result.getInt("point3_y")),
                };
                find = new Triangle(id, p[0], p[1], p[2]);
            }
        } catch (SQLException e) {
            return null;
        }
        return find;
    }
  
    public ArrayList<Triangle> findAll() {
        ArrayList<Triangle> find = new ArrayList<Triangle>();
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "SELECT IDShape FROM Triangle");
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                find.add(this.find(result.getString("IDShape")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<Triangle>();
        }
        return find;
    }
 
    public Triangle update(final Triangle object) {
        
        final Triangle before = this.find(object.getnameshape());
        if (before != null) {
            try {
                PreparedStatement prepare = connect.prepareStatement(
                "UPDATE Triangle SET point1_x = ?, point1_y = ?, "
                + "point2_x = ?, point2_y = ?, point3_x = ?, point3_y = ?"
                + " WHERE IDShape = ?");
                prepare.setInt(1, object.getPoint(0).getX());
                prepare.setInt(2, object.getPoint(0).getY());
                prepare.setInt(3, object.getPoint(1).getX());
                prepare.setInt(4, object.getPoint(1).getY());
                prepare.setInt(5, object.getPoint(2).getX());
                prepare.setInt(6, object.getPoint(2).getY());
                prepare.setString(7, object.getnameshape());
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
  
    public void delete(final Triangle object) {
     
        try {
            this.deleteComposant(object.getnameshape());
            PreparedStatement prepare = connect.prepareStatement(
                    "DELETE FROM Triangle WHERE IDShape = ?");
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
