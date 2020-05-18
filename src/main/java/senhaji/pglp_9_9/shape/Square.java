package senhaji.pglp_9_9.shape;


public class Square extends Shape {
  
    private Point P;

    private int length;
  
    public Square(final String newshapename, final Point p,
            final int lengthSquare) throws Exception {
        super(newshapename);
        this.P = p.clone();
        this.setlength(lengthSquare);
    }
   
    public void movepoint(final int x, final int y) {
        P.movep(x, y);
    }
   
    public void affiche() {
        super.affiche();
        System.out.println("Square (length = "
                + length
                + ", Point= " + P + ")");
    }
  
    public Point getP() {
        return P.clone();
    }
  
    public void setP(final Point p) {
        this.P = p.clone();
    }

    public int getlength() {
        return length;
    }
   
    public void setlength(final int lengthSquare) throws Exception {
        if (lengthSquare > 0) {
            this.length = lengthSquare;
        } else {
        	System.out.println("must be >0");
            throw new Exception();
        }
    }
}
