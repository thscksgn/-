import java.awt.*;
import javax.swing.*;
import java.util.*;

public abstract class Block implements Runnable {
	int XY[][] = new int[3][2];
	int x = 1;
	int y = 5;
	int rotateCnt = 0;
	Color blank = Color.WHITE;
	Color color = new Color(244,211,99);
	
	Block ()  {
		TetrisGui.backGround[x][y].setBackground(color);
	}
	
	abstract void setDefaultPoint ();
	abstract boolean checkDefaultPointY(int y, int rotateCnt);
	abstract boolean checkDefaultPointX(int x, int rotateCnt);
	
	void leftMove()  {
		if (checkDefaultPointY(y-1, rotateCnt))  {
			setClearBag();
			y = y - 1;
			setDefaultPoint ();
			setBlock();
		}
		else  {
			return;
		}	
	}
	
	void rightMove()  {
		if (checkDefaultPointY(y+1, rotateCnt))  {
			setClearBag();
			y = y + 1;
			setDefaultPoint ();
			setBlock();
		}
		else  {
			return;
		}
	}
	
	void rotate()  {
		if (rotateCnt == 3)  {
			if (checkDefaultPointY(y, 0) && checkDefaultPointX(x, 0))  {
				setClearBag();
				rotateCnt = 0;
				setDefaultPoint ();
				setBlock();
			}
			else  {
				return;
			}
		}
		
		else  {
			if (checkDefaultPointY(y, rotateCnt+1) && checkDefaultPointX(x, rotateCnt+1))  {
				setClearBag();
				rotateCnt += 1;
				setDefaultPoint ();
				setBlock();
			}
			else  {
				return;
			}
		}
	}
	
	void downMove()  {
		if (checkDefaultPointX(x+1, rotateCnt))  {
			setClearBag();
			x = x + 1;
			setDefaultPoint ();
			setBlock();
		}
		else  {
			return;
		}
	}
	
	public void run()  {  // @@@
		while (checkDefaultPointX(x+1, rotateCnt))  {
			downMove();
			try  {
				Thread.sleep(1000);
			}
			catch (InterruptedException e)  {
				System.out.println(e.getMessage());
			}
		}
		addBck();
		System.out.println("³¡");
	}
	
	void setClearBag ()  {
		TetrisGui.backGround[x][y].setBackground(blank);
		for (int cnt = 0; cnt < 3; cnt++)  {
			TetrisGui.backGround[XY[cnt][0]][XY[cnt][1]].setBackground(blank);
		}
	}
	
	void setBlock ()  {
		TetrisGui.backGround[x][y].setBackground(color);
		TetrisGui.backGround[XY[0][0]][XY[0][1]].setBackground(color);
		TetrisGui.backGround[XY[1][0]][XY[1][1]].setBackground(color);
		TetrisGui.backGround[XY[2][0]][XY[2][1]].setBackground(color);
	}
	
	void addBck ()  {
		TetrisGui.bck[x][y] = false;
		TetrisGui.bck[XY[0][0]][XY[0][1]] = false;
		TetrisGui.bck[XY[1][0]][XY[1][1]] = false;
		TetrisGui.bck[XY[2][0]][XY[2][1]] = false;
	}
	
	boolean blockCheckColum (int y)  { // ??
		this.y += y;
		setDefaultPoint();
		for (int cnt = 0; cnt < 3; cnt++)  {
			if (XY[cnt][1] < 0 || XY[cnt][1] > 9)  {
				this.y += y * -1;
				return false;
			}
		}
		return true;
	}

}
