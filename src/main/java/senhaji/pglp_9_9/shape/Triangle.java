package senhaji.pglp_9_9.shape;


public class Triangle extends Shape  {
   
    private Point[] points;
    
    public Triangle(final String newshapename, final Point p1,
            final Point p2, final Point p3) {
        super(newshapename);
     
        points = new Point[3];
        points[0] = p1.clone();
        points[1] = p2.clone();
        points[2] = p3.clone();
    }
 
    public void movepoint(final int x, final int y) {
        
        for (int i = 0; i <3; i++) {
            points[i].movep(x, y);
        }
    }
  
    public void affiche() {
        super.affiche();
        System.out.println("Triangle ("
                + "Point des points = " + points[0] + ", "
                + points[1] + ", " + points[2] + ")");
    }
   
    public Point getPoint(final int index) {
        if (index < 0 || index > 2) {
            throw new IndexOutOfBoundsException();
        } else {
            return points[index].clone();
        }
    }
}
