package msweeper;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;

/**
 * 
 * @author jo
 *�@msweeper�̃Q�[���p�l���ɑ�������JFrame���p�������I�u�W�F�N�g�B
 */
public class msweeperBoard extends JPanel implements GameObject{
	
	/**
	 * �J�����}�X�ڂ̐���ێ�
	 */
	int openBlock;
	
	/**
	 * �Q�[�����N���A���ꂽ���ǂ���
	 */
	boolean clearFlag;
	
	/**
	 * M�̐ݒu��
	 */
	int bomnum;
	
	/**
	 * �c���̑傫��
	 */
	int len;
	
	/**
	 * msweeperBlock������z��B
	 */
	msweeperBlock map[][];
	
	/**
	 * �Q�[�����p���\�ł��邩�ǂ���
	 */
	private boolean gameState;
	
	/**
	 * �ϐ��̏�����
	 * �c���̑傫��������
	 * ���e�̐ݒu��������
	 * �{�[�h���Q�[�����J�n�ł����ԂɂȂ�悤�ɐݒ�
	 */
	msweeperBoard(int len,int bom){
		super();
		GridLayout layout = new GridLayout(len,len);
		this.setLayout(layout);
		this.setPreferredSize(new Dimension(400,400));
		this.len = len;
		map = new msweeperBlock[this.len][this.len];
		setButton();
		this.bomnum = bom;
		setBom();
		setNum();
		this.gameState = true;
		this.openBlock = 0;
		this.clearFlag = false;
	}
	
	/**
	 * gameState�̃Q�b�^�[
	 * @return�@�Q�[�����p���\�ł����true
	 */
	public boolean getGameState() {
		return gameState;
	}
	
	/**
	 * clearFlag�̃Q�b�^�[
	 * @return�@�Q�[���N���A�Ȃ�true
	 */
	public boolean getGameClear() {
		return clearFlag;
	}
	
	/**
	 * gameState��false��ݒ肵�Ă��ׂẴ}�X�ڂ𑀍�s�\�ɂ���
	 */
	public void setGameStateEnd() {
		this.gameState = false;
		for(int i = 0;i < len;i++) {
			for(int j = 0;j < len;j++) {
				map[i][j].setClickOK(false); 
			}
		}
	}
	
	/**
	 * �z�u���ꂽ�I�u�W�F�N�g�����ׂĔj������
	 */
	public void clear() {
		this.removeAll();
	}
	
	/**
	 * �{�^��(msweeperBlock)���p�l����ɔz�u����
	 * �z�u���ꂽ�{�^���𑀍�ł���悤�ɔz��Ɋi�[���ĕێ�����
	 */
	private void setButton(){
		for(int i = 0;i < len;i++) {
			for(int j = 0;j < len;j++) {
				msweeperBlock msb = new msweeperBlock(this,i,j);
				msb.setMargin(new Insets(0,0,0,0));
				map[i][j] = msb;
				this.add(msb);
			}
		}
	}
	
	/**
	 * ���e���Z�b�g����
	 * �V���b�t���ɂ�Collections.shuffle��p����
	 */
	private void setBom() {
		ArrayList <Boolean> bom = new ArrayList<>();
		
		for(int i = 0;i < bomnum;i++) {
			bom.add(true);
		}
		for(int i = 0;i < (len * len) - bomnum;i++) {
			bom.add(false);
		}
		
		Collections.shuffle(bom);
		
		for(int i = 0,index = 0;i < len;i++) {
			for(int j = 0;j < len;j++,index++) {
				if(bom.get(index)) {
					map[i][j].setBom();
				}
			}
		}
	}
	
	/**
	 * ���e�̈ʒu�����o���A���͂ɔԍ���U��֐�(makeNum)���Ăяo��
	 */
	private void setNum() {
		for(int i = 0;i < len;i++) {
			for(int j = 0;j < len;j++){
				if(map[i][j].getBomFlag()) {
					makeNum(i,j);
				}
			}
		}
	}
	
	/**
	 * ���e���͂̍��W�̔ԍ���+1����
	 * @param x�@���e�̍��WX
	 * @param y�@���e�̍��WY
	 */
	private void makeNum(int x,int y) {
		for(int i = 0;i < 8;i++) {
			if(x + peripheralBlockX[i] >= 0 && y + peripheralBlockY[i] >= 0 && x + peripheralBlockX[i] < len && y + peripheralBlockY[i] < len){
				map[x + peripheralBlockX[i]][y + peripheralBlockY[i]].numAdder();
			}
		}
	}
	
	/**
	 * �}�X�ڂ��J���A���g�̃}�X�ڂ��󔒂������ꍇ�A���ӂ̃}�X�ڂ��J���B
	 * �������ċA�I�ɍs�������I�[�v������������
	 * @param x�@�J���}�X�̍��WX
	 * @param y�@�J���}�X�̍��WY
	 */
	public void openBlock(int x,int y) {
        if (!(inLenge(x,y))) return;
        map[x][y].open();
        this.openBlock++;
        this.gameCon();
        if(map[x][y].getNum() == 0 && map[x][y].getBomFlag() == false) {
            for(int i = 0;i < 8;i++) {
                int cx = x + peripheralBlockX[i], cy = y + peripheralBlockY[i];
                if(inLenge(cx,cy)) {
                    if (!map[cx][cy].getState()) openBlock(cx, cy);
                }
            }
        }
    }

	/**
	 * �Q�[�����N���A����Ă��邩�ǂ�������
	 * �N���A����Ă���ꍇ�̓Q�[�����p���s��Ԃ�
	 */
	private void gameCon() {
		if(this.openBlock == (len * len)-bomnum) {
			this.clearFlag = true;
			this.setGameStateEnd();
		}
	}
	
	/**
	 * �{�[�h�̏c���Ɏ��܂邩�ǂ�������B
	 * @param x ���WX
	 * @param y�@���WY
	 * @return�@�͈͓��Ȃ�true
	 */
	private boolean inLenge(int x,int y) {
		if(x >= 0 && x < len) {
			if(y >= 0 && y < len) {
				return true;
			}
		}
		return false;
	}
}
	

