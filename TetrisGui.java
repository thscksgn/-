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
		JFrame frame = new JFrame("��Ʈ����");
		frame.setLocation(550, 30);
		frame.setPreferredSize(new Dimension(400,840));
		Container contentPane = frame.getContentPane();
		JPanel mainPanel = new JPanel(); // �����г�
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

	        public void keyTyped(KeyEvent e) {                        // Ű���� ��ư�� ���ȴ� ��������

	        }

	        @Override

	        public void keyReleased(KeyEvent e) {                    // Ű���� ��ư�� ��������

	        }

	        @Override

	        public void keyPressed(KeyEvent e) {                    // Ű���� ��ư�� ������
	            switch(e.getKeyCode()) {
	            	case KeyEvent.VK_UP:
	            		System.out.println("��");
	            		block.rotate();
	            		break;

	                case KeyEvent.VK_LEFT:
	                	System.out.println("����Ʈ");
	                	block.leftMove();
	                	break;

	                case KeyEvent.VK_RIGHT:
	                	System.out.println("����Ʈ");
	                	block.rightMove();
	                	break;

	                case KeyEvent.VK_DOWN:
	                	System.out.println("�ٿ�");
	                	block.downMove();
	                	break;

	                case KeyEvent.VK_SPACE:
	                	System.out.println("�����̽�");
	                	break;
	            }
	        }
	    });	
		block = list.get(random.nextInt(2));
		thread = new Thread(block);
		thread.start();
	}
}
