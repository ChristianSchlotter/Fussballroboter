import java.util.ArrayList;


public class Field {
	//Das ganze Spielfeld. Array mit Felder in 2D
	
		 
			private FieldSegment[][] field;
			final private int countLine;
			final private int countColumn;
			final int lengthX = 5000;
			final int lengthY = 3000;
			private Roboter ownRobot;
			private ArrayList<FieldSegment> driveWay = new ArrayList<FieldSegment>();
			
		public Field(int countColumn , int countLine){  //Anzahl Spalten und Zeilen
			this.countLine = countLine ;
			this.countColumn = countColumn ;
			
			
			field = new FieldSegment[countColumn][countLine];
			int i = 0;
			
			for(int counterColumn = 0; counterColumn < countColumn; counterColumn++ ){ //Spalte
				for(int counterLine = 0; counterLine < countLine; counterLine ++){ // Zeile
					
					float centerY = ((lengthY / countLine) * counterLine) + ((lengthY / countLine) / 2);
					float centerX = ((lengthX / countColumn) * counterColumn) + ((lengthX / countColumn) / 2);
			 
					 
					field[counterColumn][counterLine] = new FieldSegment(i, centerX , centerY);
					i ++;
				}
				
				
			}
			
		}
		
		public void addOwnRoboter(String sopiasIP, int sopiasPort, float x, float y, float angle){
			ownRobot = new Roboter(sopiasIP, sopiasPort, x, y, angle, countColumn, countLine);
		}
		
		public FieldSegment getFieltElement(int colum, int line){
			return field[colum][line];
		}
		
		public int getCountLine(){
			return countLine;
		}
		
		public int getCountColumn(){
			return countColumn;
		}
		
		
		
		public void addDriveSegment(FieldSegment driveSegment) {
			driveWay.add(driveSegment);
		}
		
		public void driveOwnRobotDriveWay(){
			for (int i = 0; i < driveWay.size(); i++) {
				ownRobot.driveRobot(driveWay.get(i));
			}
		}
		

}
