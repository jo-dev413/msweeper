package msweeper;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class msweeperScore extends JPanel{
	private String str = "<html><body>"
			+ "<center>経過時間</center><br/>"
			+ "<center>0000</center><br/><br/>"
			+ "<center>ハイスコア</center><br/>"
			+ "<center>10</center><br/><br/>"
			+ "<center>5秒後に次のゲームがスタートします</center><br> "
			+ "</body></html>";
	msweeperScore(){
		this.setPreferredSize(new Dimension(400,400));
		JLabel label1 = new JLabel(str);
		this.add(label1);
	}
}
