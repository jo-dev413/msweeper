package msweeper;

import java.awt.Button;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * 
 * @author jo
 *
 */
public class msweeperMain {
	/**
	 * mainメソッド
	 * プログラム実行時に呼び出されるメソッド。
	 * このメソッドが終了するとプログラム自体も終了する。
	 * @param args
	 */
	public static void main(String args[]){
		ThreadTest test = new ThreadTest();
		test.init();
	}
}

class ThreadTest extends JFrame implements Runnable{
	  Thread thread = null;

	  public void init(){
		this.setBounds(0, 0, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
		thread = new Thread(this);
	    thread.start();
	  }

	  public void run(){
		  
		  msweeperBoard board;
		  
		  while(true) {
			
			board = new msweeperBoard();
			
			this.add(board);
			
			this.setVisible(true);
			
			this.repaint();
			
			while(board.getGameState()){
				repaint();
			}	
			try {
				thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			board.clear();
			
			this.repaint();
			
			this.remove(board);
			
			msweeperScore msc = new msweeperScore();
			
			this.add(msc);
			
			try {
				thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			remove(msc);
		  }
	  }
}