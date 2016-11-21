
public class Nemo extends Block  {
	
	
	Nemo ()  {
		super();
		setDefaultPoint();
		TetrisGui.backGround[XY[0][0]][XY[0][1]].setBackground(color);
		TetrisGui.backGround[XY[1][0]][XY[1][1]].setBackground(color);
		TetrisGui.backGround[XY[2][0]][XY[2][1]].setBackground(color);
		
	}
	
	public void setDefaultPoint ()  {
			XY[0][0] = x; 
			XY[0][1] = y+1;
			XY[1][0] = x-1;
			XY[1][1] = y+1;
			XY[2][0] = x-1;
			XY[2][1] = y;
	}
	
	boolean checkDefaultPointY (int y, int rotateCnt)  {
		if (y < 0 | y+1 > 9)
			return false;
		if (TetrisGui.bck[x][y] == false | TetrisGui.bck[x][y+1] == false | TetrisGui.bck[x-1][y+1] == false | TetrisGui.bck[x-1][y] == false)
			return false;
		else
			return true;
	}
	
	boolean checkDefaultPointX (int x, int rotateCnt)  {
		if (x > 19 | TetrisGui.bck[x][y] == false | TetrisGui.bck[x][y+1] == false | TetrisGui.bck[x-1][y+1] == false | TetrisGui.bck[x-1][y] == false)
			return false;
		else
			return true;
	}
	
	
	

}
