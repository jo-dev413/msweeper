package msweeper;

import java.awt.Button;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 * Main�N���X�B
 *�@�R�}���h���C������Q�[���̃t�B�[���h�T�C�Y��M�̐����󂯎��
 *�@���̌�`��X���b�h�𗧂��グ��B
 * @author jo
 */
public class msweeperMain {
	/**
	 * @param args
	 * main���\�b�h
	 * �v���O�������s���ɌĂяo����郁�\�b�h�B
	 * ���̃��\�b�h���I������ƃv���O�������̂��I������B
	 */
	public static void main(String[] args){
		msweeperView view = new msweeperView();
		view.init(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
	}
}