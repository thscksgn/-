import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;

public class TetrisGui {
	static JPanel backGround[][] = new JPanel[20][10];
	static boolean bck[][] = new boolean[21][10];
	static ArrayList<Block> list = new ArrayList<Block>();
	static Thread thread;
	static Block block;
	
	public static void main(String[] args) {	
		JFrame frame = new JFrame("테트리스");
		frame.setLocation(550, 30);
		frame.setPreferredSize(new Dimension(400,840));
		Container contentPane = frame.getContentPane();
		JPanel mainPanel = new JPanel(); // 메인패널
		mainPanel.setLayout(null);
		mainPanel.setBorder(new LineBorder(Color.BLACK, 4));
		contentPane.add(mainPanel);
		int y = 0;
		int x = 0;
		for (int cnt1 = 0; cnt1 < 20; cnt1++)  {
			for (int cnt2 = 0; cnt2 < 10; cnt2++)  {
				bck[cnt1][cnt2] = true;
				backGround[cnt1][cnt2] = new JPanel();
				backGround[cnt1][cnt2].setSize(40, 40);
				backGround[cnt1][cnt2].setBorder(new LineBorder(Color.BLACK, 1));
				backGround[cnt1][cnt2].setBackground(Color.WHITE);
				backGround[cnt1][cnt2].setLocation(x, y);
				mainPanel.add(backGround[cnt1][cnt2]);
				x += 40;
			}
			y += 40;
			x = 0;
		}
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		list.add(new Fuck());
		list.add(new Nemo());
		Random random = new Random();
		
		frame.addKeyListener(new KeyListener() {

	        @Override

	        public void keyTyped(KeyEvent e) {                        // 키보드 버튼이 눌렸다 떨어질때

	        }

	        @Override

	        public void keyReleased(KeyEvent e) {                    // 키보드 버튼이 떨어질때

	        }

	        @Override

	        public void keyPressed(KeyEvent e) {                    // 키보드 버튼이 눌릴때
	            switch(e.getKeyCode()) {
	            	case KeyEvent.VK_UP:
	            		System.out.println("업");
	            		block.rotate();
	            		break;

	                case KeyEvent.VK_LEFT:
	                	System.out.println("레프트");
	                	block.leftMove();
	                	break;

	                case KeyEvent.VK_RIGHT:
	                	System.out.println("라이트");
	                	block.rightMove();
	                	break;

	                case KeyEvent.VK_DOWN:
	                	System.out.println("다운");
	                	block.downMove();
	                	break;

	                case KeyEvent.VK_SPACE:
	                	System.out.println("스페이스");
	                	break;
	            }
	        }
	    });	
		block = list.get(random.nextInt(2));
		thread = new Thread(block);
		thread.start();
	}
}
