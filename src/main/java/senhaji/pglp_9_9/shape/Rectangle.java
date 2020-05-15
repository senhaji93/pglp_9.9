package senhaji.pglp_9_9.shape;

public class Rectangle extends Shape {
   
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
