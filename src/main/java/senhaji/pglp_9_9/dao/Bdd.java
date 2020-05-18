package senhaji.pglp_9_9.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public abstract class Bdd {
 
    private static String nameBdd = "data";
   
 
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:derby:" + nameBdd + ";create=false");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
   
    public static void crateTables() throws Exception {
        Connection connect = Bdd.getConnection();
        Statement stat = null;
        try {
            stat = connect.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            stat.execute("drop table Composition");
        } catch (SQLException e) {
        }
        try {
            stat.execute("drop table GroupeShape");
        } catch (SQLException e) {
        }
        try {
            stat.execute("drop table Cercle");
        } catch (SQLException e) {
        }
        try {
            stat.execute("drop table Rectangle");
        } catch (SQLException e) {
        }
        try {
            stat.execute("drop table Square");
        } catch (SQLException e) {
        }
        try {
            stat.execute("drop table Triangle");
        } catch (SQLException e) {
        }
        try {
            stat.execute("drop table Shape");
        } catch (SQLException e) {
        }
        ///////////////////////////////
        try {
        String table3 = "create table Shape ("
                + "IDShape varchar(30) primary key"
                + ")";
       
        stat.execute(table3);} catch (SQLException e) {
        }
        //////////////////////////////
        try {
        String table1 = "create table Triangle ("
                + "IDShape varchar(30) primary key,"
                + "point1_x int,"
                + "point1_y int,"
                + "point2_x int,"
                + "point2_y int,"
                + "point3_x int,"
                + "point3_y int,"
                + "foreign key (IDShape) references Shape (IDShape)"
                + ")";
      
        stat.execute(table1);} catch (SQLException e) {
        }
        /////////////////////////////
        try {
        String table2 = "create table Square ("
                + "IDShape varchar(30) primary key,"
                + "P_x int,"
                + "P_y int,"
                + "length int,"
                + "foreign key (IDShape) references Shape (IDShape)"
                + ")";
      
        stat.execute(table2);} catch (SQLException e) {
        }
        try {
        /////////////////////
        String table4 = "create table Rectangle ("
                + "IDShape varchar(30) primary key,"
                + "P_x int,"
                + "P_y int,"
                + "length int,"
                + "width int,"
                + "foreign key (IDShape) references Shape (IDShape)"
                + ")";
    
        stat.execute(table4);} catch (SQLException e) {
        }
        //////////
        try {
        String table = "create table Cercle ("
                + "IDShape varchar(30) primary key,"
                + "P_x int,"
                + "P_y int,"
                + "rayon int,"
                + "foreign key (IDShape) references Shape (IDShape)"
                + ")";
      
        stat.execute(table);} catch (SQLException e) {
        }
        ////////////////////
        try {
        String table5 = "create table GroupeShape ("
                + "IDShape varchar(30) primary key,"
                + "foreign key (IDShape) references Shape (IDShape)"
                + ")";
       
        stat.execute(table5);} catch (SQLException e) {
        }
        ///////////////////
        try {
        String table6 = "create table Composition ("
                + "idGroupe varchar(30),"
                + "idComposant varchar(30),"
                + "primary key (idGroupe, idComposant),"
                + "foreign key (idGroupe) references "
                + "GroupeShape (IDShape),"
                + "foreign key (idComposant) "
                + "references Shape (IDShape)"
                + ")";
       
        stat.execute(table6);} catch (SQLException e) {
        }
        
        connect.close();
    }
   
    public static void createDataBase()  {
        Connection c;
        try {
            c = DriverManager.getConnection(
                "jdbc:derby:" + nameBdd + ";create=true");
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
   

  
  
 
    
   
  
  
  
   
  
}