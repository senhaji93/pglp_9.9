
 package senhaji.pglp_9_9.dao;

 import java.sql.Connection;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.util.ArrayList;

 import senhaji.pglp_9_9.shape.Square;
 import senhaji.pglp_9_9.shape.Point;

 public class  daobddsquare extends daoabstract <Square> {
     
     private final Connection connect;
     
     public  daobddsquare(final Connection c) {
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
     
     public Square create(final Square object) {
        
         try {
             PreparedStatement prepare = connect.prepareStatement(
                     "INSERT INTO Shape"
                     + " (IDShape)"
                     + " VALUES(?)");
                     prepare.setString(1, object.getnameshape());
                     prepare.executeUpdate();
             prepare = connect.prepareStatement(
                     "INSERT INTO Square"
                     + " (IDShape,P_x,P_y,length)"
                     + " VALUES(?, ?, ?, ?)");
             prepare.setString(1, object.getnameshape());
             prepare.setInt(2, object.getP().getX());
             prepare.setInt(3, object.getP().getY());
             prepare.setInt(4, object.getlength());
             prepare.executeUpdate();
         } catch (SQLException e) {
             return null;
         }
         return object;
     }
    
     public Square find(final String id) {
       
         Square find = null;
         try {
             PreparedStatement prepare = connect.prepareStatement(
                     "SELECT * FROM Square WHERE IDShape = ?");
             prepare.setString(1, id);
             ResultSet result = prepare.executeQuery();
             if (result.next()) {
                 Point p = new Point(result.getInt("P_x"),
                         result.getInt("P_y"));
                 try {
                     find = new Square(id, p, result.getInt("length"));
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
   
     public ArrayList<Square> findAll() {
         ArrayList<Square> find = new ArrayList<Square>();
         try {
             PreparedStatement prepare = connect.prepareStatement(
                     "SELECT IDShape FROM Square");
             ResultSet result = prepare.executeQuery();
             while (result.next()) {
                 find.add(this.find(result.getString("IDShape")));
             }
         } catch (SQLException e) {
             e.printStackTrace();
             return new ArrayList<Square>();
         }
         return find;
     }
    
     public Square update(final Square object) {
         
         final Square before = this.find(object.getnameshape());
         if (before != null) {
             try {
                 PreparedStatement prepare = connect.prepareStatement(
                 "UPDATE Square SET P_x = ?, P_y = ?, "
                 + "length = ? WHERE IDShape = ?");
                 prepare.setInt(1, object.getP().getX());
                 prepare.setInt(2, object.getP().getY());
                 prepare.setInt(3, object.getlength());
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
   
     public void delete(final Square object) {
       
         try {
             this.deleteComposant(object.getnameshape());
             PreparedStatement prepare = connect.prepareStatement(
                     "DELETE FROM Square WHERE IDShape = ?");
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
