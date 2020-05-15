package senhaji.pglp_9_9.shape;

import java.io.CharConversionException;

public class Point {
	  private int x;
	   
	    private int y;
	    
	    public Point() {
	        x = 0;
	        y = 0;
	    }
	    public Point(final int xp, final int yp) {
	        x = xp;
	        y = yp;
	    }
	   
	    public void movep(final int xp, final int yp) {
	        x += xp;
	        y += yp;
	    }
	   
		  public Point clone() {
		        return new Point(x, y);
		    }
		  
		
		@Override
		public String toString() {
			return "Point [ getX()=" + getX() + ", getY()=" + getY()+"]";
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
		 public Point(final String Point) throws CharConversionException {
		        Point.replace(" ", "");
		        if (Point.charAt(0) != '('
		        || Point.charAt(Point.length() - 1) != ')') {
		            System.err.println(Point);
		            throw new CharConversionException();
		        }
		        String Point2 = Point.substring(1, Point.length() - 1);
		        String[] PointSplit = Point2.split(",");
		        if (PointSplit.length != 2) {
		            System.err.println(Point);
		            throw new CharConversionException();
		        }
		        try {
		            x = Integer.parseInt(PointSplit[0]);
		            y = Integer.parseInt(PointSplit[1]);
		        } catch (NumberFormatException e) {
		            e.printStackTrace();
		            throw e;
		        }
		    }
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return super.hashCode();
		}
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
}
