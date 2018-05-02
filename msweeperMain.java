package msweeper;

import javax.swing.JFrame;

public class msweeperMain {
	public static void main(String args[]){
		JFrame view = new JFrame();
		view.setBounds(0,0,400,400);
		
		msweeperBoard board = new msweeperBoard();
		msweeperScore score = new msweeperScore();
		
		view.setVisible(true);
		view.add(board);
		//view.add(score);
		
		while(board.getGameState()) {
			//System.out.println("Con");
		}
		System.out.println("End");
		
	}
}
