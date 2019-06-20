package kata.tennis;

public class Player {

	private  int tracker = 0;
	private  int setTracker = 0;
	private int tiebrekTracker = 0;
	
	private String name;

	Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTracker() {
		return tracker;
	}

	public void setTracker(int tracker) {
		this.tracker = tracker;
	}

	public int getSetTracker() {
		return setTracker;
	}

	public void setSetTracker(int setTracker) {
		this.setTracker = setTracker;
	}

	public int getTiebrekTracker() {
		return tiebrekTracker;
	}

	public void setTiebrekTracker(int tiebrekTracker) {
		this.tiebrekTracker = tiebrekTracker;
	}
}
