package msweeper;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class msweeperScore extends JPanel{
	private String str = "<html><body>"
			+ "<center>�o�ߎ���</center><br/>"
			+ "<center>0000</center><br/><br/>"
			+ "<center>�n�C�X�R�A</center><br/>"
			+ "<center>10</center><br/><br/>"
			+ "<center>5�b��Ɏ��̃Q�[�����X�^�[�g���܂�</center><br> "
			+ "</body></html>";
	msweeperScore(){
		this.setPreferredSize(new Dimension(400,400));
		JLabel label1 = new JLabel(str);
		this.add(label1);
	}
}
