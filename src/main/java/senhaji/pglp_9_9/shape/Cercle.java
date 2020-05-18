package senhaji.pglp_9_9.shape;

public class Cercle extends Shape {
  
    private Point centre;
	private int rayon;
  
    public Cercle(final String nameshape, final Point p,
            final int Rcircle) throws Exception {
        super(nameshape);
        centre = p.clone();
        this.setRayon(Rcircle);
    }
   
    public void movepoint(final int x, final int y) {
        centre.movep(x, y);
    }
   
    public void affiche() {
        super.affiche();
        System.out.println("Circle ("
                + "centre = " + centre + ", rayon = " + rayon + ")");
    }
  
    public int getRayon() {
        return rayon;
    }
  
    public void setRayon(final int R) throws Exception {
        if (R > 0) {
            this.rayon = R;
        } else {
        	System.out.println("rayon must be >0");
            throw new Exception();
        }
    }
  
    public Point getCentre() {
        return centre.clone();
    }
   
    public void setCentre(final Point center) {
        this.centre = center.clone();
    }
}
