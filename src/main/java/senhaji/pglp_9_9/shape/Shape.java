package senhaji.pglp_9_9.shape;

public abstract class Shape {
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

	private String nameshape;
    
    public String getnameshape() {
        return nameshape + "";
    }
   
    public void setnameshape(final String newshapename) {
    	nameshape = newshapename + "";
    }
   
    public String getNameshape() {
		return nameshape;
	}

	public void setNameshape(String nameshape) {
		this.nameshape = nameshape;
	}



	protected Shape(final String newshapename) {
        this.nameshape = newshapename;
    }
   
    public abstract void movepoint(int x, int y);
  
    public void affiche() {
        System.out.print(nameshape + " : ");
    }
}
