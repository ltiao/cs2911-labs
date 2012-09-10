package lab02;

public class NanoTimer implements Timer
{
	public enum State {
		STOPPED, SUSPENDED, RUNNING
	}
	public static long currentTime ()
	{
		return System.nanoTime ();
	}
		
	private Interval elapsed = new NanoInterval(0);
	private long start_timestamp = 0;
	private long suspend_timestamp = 0;
	private long stop_timestamp = 0;
	private State state = State.STOPPED;
	
	public void start ()
	{
		if (state == State.SUSPENDED) {
			state = State.RUNNING;		
		} else if (state == State.STOPPED) {
			state = State.RUNNING;
			elapsed = new NanoInterval(0);
			start_timestamp = currentTime();
		} else if (state == State.RUNNING) {
			elapsed = new NanoInterval(0);
		}
	}

	public Interval elapsed ()
	{
		if (state == State.RUNNING) {
			elapsed = elapsed.add(start_timestamp, currentTime());
			start_timestamp = currentTime();
			return elapsed;
		}
		else if (state == State.SUSPENDED) {
			elapsed = elapsed.add(start_timestamp, suspend_timestamp);
			return elapsed;
		} else {
			if ( stop_timestamp > 0 ) {
				elapsed = elapsed.add(start_timestamp, stop_timestamp);
				return elapsed;
			}
			return new NanoInterval(0);	
		}
	}
	
	public void stop ()
	{
		if (state == State.RUNNING) {
			stop_timestamp = currentTime();
		}
		state = State.STOPPED;
	}

	public void suspend ()
	{
		if (state == State.RUNNING) {
			state = State.SUSPENDED;
			suspend_timestamp = currentTime();
		}
	}

	public void resume ()
	{
		if (state == State.SUSPENDED) {
			state = State.RUNNING;
			suspend_timestamp = 0;
			start_timestamp = currentTime();
		}
	}
	
}