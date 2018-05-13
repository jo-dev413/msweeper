package msweeper;

import javax.swing.JFrame;

/**
 * 
 * @author jo
 * 描画スレッドを提供するクラス。本クラス上でゲームは処理される。
 */
public class ViewThread extends JFrame implements Runnable {
	
	private int bom;
	private int len;
	
	private long highscore;
	
	Thread thread = null;
	
	ViewThread(){
		this.setBounds(0, 0, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void init(int len,int bom) {
		this.bom = bom;
		this.len = len;
		this.highscore = 10000;
		Thread view = new Thread(this);
		view.start();
	}
	
	@Override
	public void run(){
		MyTimer time;
		msweeperBoard board;
		
		while(true) { 
			
			time = new MyTimer();
			
			time.start();
			
			board = new msweeperBoard(this.len,this.bom);
			
			this.add(board);
			
			this.setVisible(true);
			
			this.repaint();
			
			while(board.getGameState()){
				repaint();
			}
			
			time.TimerStop();
			
			waitSec(2);
			
			board.clear();
			
			this.repaint();
			
			if(board.getGameClear()) {
				this.remove(board);
				scoreView(time.getTime(),true);
			}
			else {
				this.remove(board);
				scoreView(time.getTime(),false);
			}
		  }
	  }
	
	private void scoreView(long time,boolean clear) {
		
		msweeperScore msc;
		
		setHighScore(time);
		
		msc = new msweeperScore();
		
		msc.makeHighScorStr(this.highscore);
		
		msc.makeTimeStr(time);
		
		if(clear) {
			msc.makePanelClear();
		}else {
			msc.makePanelFalse();
		}
		this.add(msc);
		
		waitSec(5);
		
		remove(msc);
	}
	  
	/**
	 * 1秒間描画スレッドを停止する。
	 * @param sec　停止する時間(s)
	 */
	  private void waitSec(int sec) {
			try {
				thread.sleep(sec * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	  }
	  
	  private void setHighScore(long score) {
		  if(this.highscore > score) {
			  this.highscore = score;
		  }
	  }
}
