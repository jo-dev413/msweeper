package msweeper;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class msweeperScore extends JPanel{
	
	private long time;
	private long highScore;
	
	private String timeStr;
	private String highScoreStr;
	
	
	private String strHead = "<html><body>";
	
	private String strEnd = "<center>5秒後に次のゲームがスタートします</center><br> "
			+ "</body></html>";
	
	msweeperScore(){
		
		this.setPreferredSize(new Dimension(400,400));
		
		this.timeStr = "";
		this.highScoreStr = "";
	}

	public void makeTimeStr(long time) {
		this.time = time;
		this.timeStr += "<center>経過時間</center><br/><center>";
		this.timeStr += Long.toString(this.time);
		this.timeStr += "</center><br/><br/>";
	}	
	
	public void makeHighScorStr(long highScore) {
		this.highScore = highScore;
		this.highScoreStr += "<center>ハイスコア</center><br/><center>";
		this.highScoreStr += Long.toString(this.highScore);
		this.highScoreStr += "</center><br/><br/>";
	}	
	
	public void makePanel() {
		String view = this.strHead + this.timeStr + this.highScoreStr + this.strEnd;
		JLabel label1 = new JLabel(view);
		this.add(label1);
	}
}
