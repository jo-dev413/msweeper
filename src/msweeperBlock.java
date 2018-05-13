package msweeper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * 
 * @author jo
 * msweeperBoard��1�}�X�ɔz�u�����JButton���p�������I�u�W�F�N�g�B
 * 
 */
public class msweeperBlock extends JButton implements ActionListener {
	
	/**
	 *	�C���X�^���X�����ꂽ�I�u�W�F�N�g�̍��W 
	 */
	private int x,y;
	
	/**
	 * M�������Ă��邩
	 */
	private boolean bom;
	
	/**
	 * M�̎���ɂ������ꍇ�ɕ\������鐔
	 */
	private int num;
	
	/**
	 * �{�^����������Ă��邩�ǂ���
	 */
	private boolean state;
	
	/**
	 * �R�[���o�b�N��
	 */
	private msweeperBoard board;
	
	/**
	 * �N���b�N�\���ǂ���
	 */
	private boolean clickOK;
	
	/**
	 * �ϐ��̏������ƃA�N�V�������X�i�[�̒ǉ�
	 * @param board�@�R�[���o�b�N��
	 * @param x�@���WX
	 * @param y�@���WY
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
	 * �v���X���o
	 * ���o��R�[���o�b�N
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
	 * bom�̃Q�b�^�[
	 * @return�@���g��M���ǂ���
	 */
	public boolean getBomFlag() {
		return this.bom;
	}
	
	/**
	 * ���g�̃}�X�ڂ��J��
	 * �J�����Ƃ��ɏ�Ԃ�\��������\��
	 * ���e�@�@  �F M
	 * M�̎���  �F M�̐��ɉ���������
	 * ���̑��@   �F �󕶎�
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
	 * state�̃Q�b�^�[
	 * @return�@�v���X�ς݂��ǂ���
	 */
	public boolean getState() {
		return state;
	}
	
	/**
	 * num�̃Q�b�^�[
	 * @return�@���͂�M�̐�
	 */
	public int getNum() {
		return num;
	}
	
	/**
	 * bom�̃Z�b�^�[
	 */
	public void setBom() {
		this.bom = true;
	}

	/**
	 * clickOK�̃Z�b�^�[
	 * @param b�@�v���X�̋���or�֎~
	 */
	public void setClickOK(boolean b) {
		this.clickOK = b;
	}
}
