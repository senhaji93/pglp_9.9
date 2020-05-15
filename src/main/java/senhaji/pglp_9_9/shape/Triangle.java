package senhaji.pglp_9_9.shape;


public class Triangle extends Shape  {
   
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
