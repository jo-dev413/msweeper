package msweeper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * 
 * @author joe-c
 *
 */
public class msweeperBlock extends JButton implements ActionListener {
	/**
	 * 
	 */
	private int x,y;
	
	/**
	 * 
	 */
	private boolean bom;
	
	/**
	 * 
	 */
	private int num;
	
	/**
	 * 
	 */
	private boolean state;
	
	/**
	 * 
	 */
	private msweeperBoard board;
	
	private boolean clickOK;
	
	/**
	 * 
	 * @param board
	 * @param x
	 * @param y
	 */
	msweeperBlock(msweeperBoard board,int x,int y){
		super();
		bom = false;
		num = 0;
		state = false;
		this.clickOK = true;
		this.board = board;
		this.x = x;
		this.y = y;
		this.addActionListener(this);
	}
	
	/**
	 * 
	 */
	public void actionPerformed(ActionEvent e){
		this.open();
		board.openBlock(this.x, this.y);
	}
	
	/**
	 * 
	 */
	public void numAdder() {
		this.num++;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getBomFlag() {
		return this.bom;
	}
	
	/**
	 * 
	 */
	public void open() {
		if(this.clickOK) {
			state = true;
			this.setEnabled(false);
			if(this.bom) {
				this.setText("M");
				board.setGameStateEnd();
			}else if(num != 0){
				this.setText(Integer.toString(num));
			}
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getState() {
		return state;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getNum() {
		return num;
	}
	
	/**
	 * 
	 */
	public void setBom() {
		this.bom = true;
	}

	public void setClickOK(boolean b) {
		this.clickOK = b;
	}
}
