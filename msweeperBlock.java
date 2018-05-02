package msweeper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class msweeperBlock extends JButton implements Image_path,ActionListener {
	
	private int x,y;
	private boolean bom;
	private int num;
	private boolean state;
	private msweeperBoard board;
	
	msweeperBlock(msweeperBoard board,int x,int y){
		super();
		bom = false;
		num = 0;
		state = false;
		this.board = board;
		this.x = x;
		this.y = y;
		this.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		this.open();
		board.openBlock(this.x, this.y);
	}
	
	public void numAdder() {
		this.num++;
	}

	public boolean getBomFlag() {
		return this.bom;
	}
	
	public void open() {
		state = true;
		this.setEnabled(false);
		if(this.bom) {
			this.setText("M");
			board.setGameStateEnd();
		}else if(num != 0){
			this.setText(Integer.toString(num));
		}
	}
	
	public boolean getState() {
		return state;
	}
	
	public int getNum() {
		return num;
	}
	
	public void setBom() {
		this.bom = true;
		this.setText("BOM");
	}
}
