package tennis_one;

public class NamedPlayer implements Player {

	final public String name;

	public NamedPlayer(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}
