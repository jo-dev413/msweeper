package msweeper;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;

public class msweeperBoard extends JPanel implements GameObject{
	
	msweeperBlock map[][] = new msweeperBlock[8][8];
	private boolean gameState;
	
	msweeperBoard(){
		super();
		GridLayout layout = new GridLayout(8,8);
		this.setLayout(layout);
		this.setPreferredSize(new Dimension(400,400));
		setButton();
		setBom();
		setNum();
		this.gameState = true;
	}
	
	public boolean getGameState() {
		return gameState;
	}
	
	public void setGameStateEnd() {
		this.gameState = false;
	}
	
	private void setButton(){
		for(int i = 0;i < 8;i++) {
			for(int j = 0;j < 8;j++) {
				msweeperBlock msb = new msweeperBlock(this,i,j);
				msb.setPreferredSize(new Dimension(50,50));
				msb.setMargin(new Insets(0,0,0,0));
				map[i][j] = msb;
				this.add(msb);
			}
		}
	}
	
	private void setBom() {
		ArrayList <Boolean> bom = new ArrayList<>();
		for(int i = 0;i < 10;i++) {
			bom.add(true);
		}
		for(int i = 0;i < 54;i++) {
			bom.add(false);
		}
		
		Collections.shuffle(bom);
		
		System.out.println(bom);
		for(int i = 0,index = 0;i < 8;i++) {
			for(int j = 0;j < 8;j++,index++) {
				if(bom.get(index)) {
					map[i][j].setBom();
				}
			}
		}
	}
	
	private void setNum() {
		for(int i = 0;i < 8;i++) {
			for(int j = 0;j < 8;j++){
				if(map[i][j].getBomFlag()) {
					makeNum(i,j);
				}
			}
		}
	}
	
	private void makeNum(int x,int y) {
		for(int i = 0;i < 8;i++) {
			if(x + peripheralBlockX[i] >= 0 && y + peripheralBlockY[i] >= 0 && x + peripheralBlockX[i] < 8 && y + peripheralBlockY[i] < 8){
				map[x + peripheralBlockX[i]][y + peripheralBlockY[i]].numAdder();
			}
		}
	}
	
	public void openBlock(int x,int y) {
        if (!(inLenge(x,y))) return;
        map[x][y].open();
        if(map[x][y].getNum() == 0 && map[x][y].getBomFlag() == false) {
            for(int i = 0;i < 8;i++) {
                int cx = x + peripheralBlockX[i], cy = y + peripheralBlockY[i];
                if(inLenge(cx,cy)) {
                    if (!map[cx][cy].getState()) openBlock(cx, cy);
                }
            }
        }
    }
	
	private boolean inLenge(int x,int y) {
		if(x >= 0 && x < 8) {
			if(y >= 0 && y < 8) {
				return true;
			}
		}
		return false;
	}
}
	

