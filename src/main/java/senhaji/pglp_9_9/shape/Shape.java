package senhaji.pglp_9_9.shape;

public abstract class Shape {
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
