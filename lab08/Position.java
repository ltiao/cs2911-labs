package lab08;

public class Position {
	private int x;
	private int y;
	
    public Position() {
    }
	
    public Position(int x, int y) {
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
		if(obj instanceof Position) {
			Position c = (Position)obj;
			return (c.x==x && c.y==y);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return x+y;
	}
    
}
