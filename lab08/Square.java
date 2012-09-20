package lab08;

public class Square {
	private int x;
	private int y;
	
    public Square() {
    }
	
    public Square(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    @Override
	public String toString() {
		return "Row: [" + x + "], Column: [" + y+"]";
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Square) {
			Square c = (Square)obj;
			return (c.x==x && c.y==y);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return 9*x+y;
	}
    
}
