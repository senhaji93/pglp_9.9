package senhaji.pglp_9_9;

import java.io.File;
import java.util.Scanner;

import  senhaji.pglp_9_9.dao.Bdd;
import senhaji.pglp_9_9.command.Cmd;
import senhaji.pglp_9_9.command.DrawingTUI;

public class App {
   
    private static Scanner Sc;
    
    private static DrawingTUI drawingTUI;
    
    public App() {
        drawingTUI= new DrawingTUI();
        Sc = new Scanner(System.in);
    }
    

    public static void main(final String[] args) throws Exception {
        try {
        	 System.out.println("chargement base de donne .... ");
         
        
                Bdd.createDataBase();
                Bdd.crateTables();
                System.out.println("\n chargement  okey ");
            App app = new App();
            System.out.println("Senhaji abdellatif 21506613");
            System.out.println("--------------------------------Manuel d'utilisation------------------------------------------");
            System.out.println("pour Créer un cercle :IDShape = Cercle((x,y), rayon)\n");
            System.out.println("pour Créer un rectangle :IDShape = Rectangle((x,y), length, width)\n");
            System.out.println( "pour Créer un triangle :IDShape = Triangle((x,y), (x,y), (x,y))\n");
            System.out.println(  "pour cree un groupe de Shape(s) :IDShape = Groupe(IDShape, IDShape2,IDShape3,IDShape4,...)\n");
            System.out.println("pour Créer un carré  :IDShape = Square((x,y), width)\n");
            System.out.println("pour move Shape ou un groupe :move(IDShape, (x,y))\n");
            
            
            String cmd = Sc.nextLine();
            Cmd c;
            while (!cmd.equalsIgnoreCase("exit")) {
                c = drawingTUI.nextCommand(cmd);
                if (c != null) {
                    c.execute();
                }
                drawingTUI.show();
                cmd = Sc.nextLine();
            }
          
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
