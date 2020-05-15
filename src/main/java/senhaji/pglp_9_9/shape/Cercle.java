package senhaji.pglp_9_9.shape;

public class Cercle extends Shape {
  
    @Override
	public String getnameshape() {
		// TODO Auto-generated method stub
		return super.getnameshape();
	}

	@Override
	public void setnameshape(String newshapename) {
		// TODO Auto-generated method stub
		super.setnameshape(newshapename);
	}

	@Override
	public String getNameshape() {
		// TODO Auto-generated method stub
		return super.getNameshape();
	}

	@Override
	public void setNameshape(String nameshape) {
		// TODO Auto-generated method stub
		super.setNameshape(nameshape);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

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
