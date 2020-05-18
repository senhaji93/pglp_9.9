package senhaji.pglp_9_9.shape;

public class Rectangle extends Shape {
   
    private Point P;
   
    private int length;
  
    private int width;
   
    public Rectangle(final String nameshape, final Point p,
            final int lengthRectangle, final int widthRectangle)
            throws Exception {
        super(nameshape);
        this.P = p.clone();
        this.setwidth(widthRectangle);
        this.setlength(lengthRectangle);
        
        
    }
   
	public void movepoint(final int x, final int y) {
        P.movep(x, y);
    }
   
    public void affiche() {
        super.affiche();
        System.out.println("Rectangle (length = " + length + ", width = " + width+ ", Point  = " + P + ")");
    }
   
    public Point getP() {
        return P.clone();
    }
  
    public void setTP(final Point p) {
        this.P = p.clone();
    }
  
    public int getwidth() {
        return width;
    }
   
    public void setwidth(final int widthRectangle) throws Exception {
        if (widthRectangle > 0) {
            this.width = widthRectangle;
        } else {
            throw new Exception();
        }
    }
    
    public int getlength() {
        return length;
    }
   
    public void setlength(final int lengthRectangle) throws Exception {
        if (lengthRectangle > 0) {
            this.length = lengthRectangle;
        } else {
            throw new Exception();
        }
    }
}
