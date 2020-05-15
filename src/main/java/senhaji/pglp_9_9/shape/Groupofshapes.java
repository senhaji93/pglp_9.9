package senhaji.pglp_9_9.shape;

import java.util.ArrayList;

public class Groupofshapes extends Shape  {

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

	private ArrayList<Shape> Shapes;
  
    public Groupofshapes(final String shapename) {
        super(shapename);
        Shapes = new ArrayList<Shape>();
    }
   
    public void movepoint(final int x, final int y) {
        for (Shape f : Shapes) {
            f.movepoint(x, y);
        }
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

	public ArrayList<Shape> getShapes() {
		return Shapes;
	}

	public void setShapes(ArrayList<Shape> shapes) {
		Shapes = shapes;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public void affiche() {
        super.affiche();
        System.out.println("Groupe (");
        for (Shape f : Shapes) {
            f.affiche();
        }
        System.out.println(")");
    }
 
    public void add(final Shape f) {
        if (!Shapes.contains(f) && f != this) {
            Shapes.add(f);
        }
    }
   
    public void remove(final Shape f) {
        Shapes.remove(f);
    }
   
    public void reset() {
        while (!Shapes.isEmpty()) {
            Shapes.remove(0);
        }
    }
   
    @SuppressWarnings("unchecked")
    public ArrayList<Shape> getList() {
        return (ArrayList<Shape>) Shapes.clone();
    }
}
