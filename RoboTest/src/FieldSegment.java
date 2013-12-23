import java.util.ArrayList;


public class FieldSegment {
	private int id;
	
	private boolean obstacleStatus;
	public boolean visited;
	final private float centerX;
	final private float centerY;
	private int heuristic;
	private int range;
	private int comefrom;
	
	public FieldSegment(int id, float centerX, float centerY){
		this.id = id;
		
		this.centerX = centerX;
		this.centerY = centerY;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHeuristic() {
		return heuristic;
	}

	public void setHeuristic(int heuristic) {
		this.heuristic = heuristic;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getComefrom() {
		return comefrom;
	}

	public void setComefrom(int comefrom) {
		this.comefrom = comefrom;
	}

	public float getCenterX() {
		return centerX;
	}

	public float getCenterY() {
		return centerY;
	}
	
	public int getValue(){
		return heuristic + range;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
}




