import sopias2libraries.*;


public class Roboter extends CommunicationLibrary  {
	private CStatus cStatus;
	private String sopiasIP; 
	private int sopiasPort;
	private int fieldPositionColumn;
	private int fieldPositionLine;
	private int fieldCountColumn;
	private int fieldCountLine;
	
	
	
	
	public Roboter(String sopiasIP, int sopiasPort, float x, float y, float angle, int fieltCountColumn, int fieltCountLine ){
		cStatus = new CStatus();
		cStatus.x = x;
		cStatus.y = y;
		cStatus.angle = angle;
		this.sopiasIP = sopiasIP;
		this.sopiasPort = sopiasPort;
		this.fieldCountColumn  = fieltCountColumn;
		this.fieldCountLine = fieltCountLine;
		calculateFieldPosition();
		
	}
	
	public CStatus getCStatus(){
		return cStatus;
	}
	
	public int connectRobot(){
		return connectRobot(sopiasIP, sopiasPort, cStatus.x, cStatus.y, cStatus.angle);
	}
	
	public void calculateFieldPosition(){
		float wideFieldX = 5000 / fieldCountColumn; //5000 = breite Spielfeld
		float heightFieldY = 3000 / fieldCountLine; //3000 = höhe Spielfeld 
		
		
		fieldPositionColumn = (int) ( (cStatus.x + 2500) / wideFieldX); //2500 = negativer Bereich
		fieldPositionLine = (int) ( (1500 + cStatus.y) / heightFieldY); // 1500 = negativer Bereich
		
	}
	
	public void driveRobot(FieldSegment fieldSegment){
		float x = Math.abs( fieldSegment.getCenterX() - (cStatus.x + 2500) ); 
		float y = Math.abs( fieldSegment.getCenterY() - (cStatus.y + 1500) );
		float angle = (float) Math.tan(x / y);
		float distance = (float) Math.sqrt(x * x + y * y);
		rotateRobot(angle);
		driveRobot(distance);
		getOpponentStatus(cStatus);
		calculateFieldPosition();
		
	}
	
	public int getFieldPosColumn(){
		return fieldPositionColumn;
	}
	
	public int getFieldPosLine() {
		return fieldPositionLine;
	}
}
