package msweeper;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * �Q�[���I������̃X�R�A�\�����s��
 * HTML�^�O��p���ĕ�����̐��`���s�������\������
 * @author joe-c
 */
public class msweeperScore extends JPanel{
	
	/**
	 * �Q�[���I�[�o�܂��̓N���A�ɗv��������
	 */
	private long time;
	
	/**
	 * �A�����čs���Ă���ꍇ�̃n�C�X�R�A�i���ԁj
	 */
	private long highScore;
	
	/**
	 * �Q�[���I�[�o�܂��̓N���A�ɗv�������Ԃ�\�����镶����
	 */
	private String timeStr;
	
	/**
	 * �A�����čs���Ă���ꍇ�̃n�C�X�R�A�i���ԁj��\�����镶����
	 */
	private String highScoreStr;

	/**
	 * HTML�̐擪
	 */
	private String strHead = "<html><body><br/>";
	
	/**
	 * �Q�[���I�[�o�����ۂɕ\�����镶����
	 */
	private String gameover = "<center>GAME OVER</center><br>";
	
	/**
	 * HTML�̖���
	 */
	private String strEnd = "<center>5�b��Ɏ��̃Q�[�����X�^�[�g���܂�</center><br> "
			+ "</body></html>";
	
	/**
	 * �p�l���̃T�C�Y��400*400�Őݒ�
	 * ������̏�����
	 */
	msweeperScore(){
		this.setPreferredSize(new Dimension(400,400));
		this.timeStr = "";
		this.highScoreStr = "";
	}

	/**
	 * ���v���Ԃ�\�����镶����𐶐�
	 * @param time�@�o�ߎ���
	 */
	public void makeTimeStr(long time) {
		this.time = time;
		this.timeStr += "<center>�N���A����</center><br/><center>";
		this.timeStr += Long.toString(this.time);
		this.timeStr += "�b</center><br/><br/>";
	}	
	
	/**
	 * �n�C�X�R�A��\�����镶����𐶐�
	 * @param highScore�@�n�C�X�R�A
	 */
	public void makeHighScorStr(long highScore) {
		this.highScore = highScore;
		this.highScoreStr += "<center>�n�C�X�R�A</center><br/><center>";
		this.highScoreStr += Long.toString(this.highScore);
		this.highScoreStr += "�b</center><br/><br/>";
	}	
	
	/**
	 * �Q�[�����N���A�����ۂɎg�p���镶����𐶐�
	 */
	public void makePanelClear() {
		String view = this.strHead + this.timeStr + this.highScoreStr + this.strEnd;
		JLabel label1 = new JLabel(view);
		this.add(label1);
	}
	
	/**
	 * �Q�[���I�[�o�����ۂɎg�p���镶����𐶐�
	 */
	public void makePanelFalse() {
		String view = this.strHead + this.gameover + this.strEnd;
		JLabel label1 = new JLabel(view);
		this.add(label1);
	}
}
