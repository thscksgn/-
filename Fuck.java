import java.awt.*;
import javax.swing.*;

public class Fuck extends Block  {
	
	
	Fuck ()  {
		super();
		setDefaultPoint();
		TetrisGui.backGround[XY[0][0]][XY[0][1]].setBackground(color);
		TetrisGui.backGround[XY[1][0]][XY[1][1]].setBackground(color);
		TetrisGui.backGround[XY[2][0]][XY[2][1]].setBackground(color);
	}
	
	public void setDefaultPoint ()  {
		switch (rotateCnt)  {
			case 0: // 정방향
				XY[0][0] = x; 
				XY[0][1] = y-1;
				XY[1][0] = x;
				XY[1][1] = y+1;
				XY[2][0] = x-1;
				XY[2][1] = y;
				break;
			
			case 1: // 회전1(시계방향)
				XY[0][0] = x+1; 
				XY[0][1] = y;
				XY[1][0] = x;
				XY[1][1] = y+1;
				XY[2][0] = x-1;
				XY[2][1] = y;
				break;
			
			case 2:
				XY[0][0] = x; 
				XY[0][1] = y-1;
				XY[1][0] = x;
				XY[1][1] = y+1;
				XY[2][0] = x+1;
				XY[2][1] = y;
				break;
			
			case 3:
				XY[0][0] = x; 
				XY[0][1] = y-1;
				XY[1][0] = x+1;
				XY[1][1] = y;
				XY[2][0] = x-1;
				XY[2][1] = y;
				break;
		}
		
	}
	
	boolean checkDefaultPointY (int y, int rotateCnt)  {
		switch (rotateCnt)  {
			case 0:
				if (y-1 < 0 | y+1 > 9)
					return false;
				if (TetrisGui.bck[x][y] == false | TetrisGui.bck[x][y-1] == false | TetrisGui.bck[x][y+1] == false | TetrisGui.bck[x-1][y] == false)
					return false;
				else
					return true;
				
			case 1:
				if (y < 0 | y+1 > 9)
					return false;
				if (TetrisGui.bck[x][y] == false | TetrisGui.bck[x+1][y] == false | TetrisGui.bck[x][y+1] == false | TetrisGui.bck[x-1][y] == false)
					return false;
				else
					return true;
				
			case 2:
				if (y-1 < 0 | y+1 > 9)
					return false;
				if (TetrisGui.bck[x][y] == false | TetrisGui.bck[x][y-1] == false | TetrisGui.bck[x][y+1] == false | TetrisGui.bck[x+1][y] == false)
					return false;
				else
					return true;
				
			case 3:
				if (y-1 < 0 | y > 9)
					return false;
				if (TetrisGui.bck[x][y] == false | TetrisGui.bck[x][y-1] == false | TetrisGui.bck[x+1][y] == false | TetrisGui.bck[x-1][y] == false)
					return false;
				else
					return true;
		}
		return true;
	}
	
	boolean checkDefaultPointX (int x, int rotateCnt)  {
		switch (rotateCnt)  {
		case 0:
			if (x > 19 | TetrisGui.bck[x][y] == false | TetrisGui.bck[x][y-1] == false | TetrisGui.bck[x][y+1] == false | TetrisGui.bck[x-1][y] == false)
				return false;
			else
				return true;
			
		case 1:
			if (x+1 > 19 | TetrisGui.bck[x][y] == false | TetrisGui.bck[x+1][y] == false | TetrisGui.bck[x][y+1] == false | TetrisGui.bck[x-1][y] == false)
				return false;
			else
				return true;
			
		case 2:
			if (x+1 > 19 | TetrisGui.bck[x][y] == false | TetrisGui.bck[x][y-1] == false | TetrisGui.bck[x][y+1] == false | TetrisGui.bck[x+1][y] == false)
				return false;
			else
				return true;
			
		case 3:
			if (x+1 > 19 | TetrisGui.bck[x][y] == false | TetrisGui.bck[x][y-1] == false | TetrisGui.bck[x+1][y] == false | TetrisGui.bck[x-1][y] == false)
				return false;
			else
				return true;
	}
	return true;
	}

}
