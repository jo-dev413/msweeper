package msweeper;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * ゲーム終了時後のスコア表示を行う
 * HTMLタグを用いて文字列の整形を行いそれを表示する
 * @author joe-c
 */
public class msweeperScore extends JPanel{
	
	/**
	 * ゲームオーバまたはクリアに要した時間
	 */
	private long time;
	
	/**
	 * 連続して行われている場合のハイスコア（時間）
	 */
	private long highScore;
	
	/**
	 * ゲームオーバまたはクリアに要した時間を表示する文字列
	 */
	private String timeStr;
	
	/**
	 * 連続して行われている場合のハイスコア（時間）を表示する文字列
	 */
	private String highScoreStr;

	/**
	 * HTMLの先頭
	 */
	private String strHead = "<html><body><br/>";
	
	/**
	 * ゲームオーバした際に表示する文字列
	 */
	private String gameover = "<center>GAME OVER</center><br>";
	
	/**
	 * HTMLの末尾
	 */
	private String strEnd = "<center>5秒後に次のゲームがスタートします</center><br> "
			+ "</body></html>";
	
	/**
	 * パネルのサイズを400*400で設定
	 * 文字列の初期化
	 */
	msweeperScore(){
		this.setPreferredSize(new Dimension(400,400));
		this.timeStr = "";
		this.highScoreStr = "";
	}

	/**
	 * 所要時間を表示する文字列を生成
	 * @param time　経過時間
	 */
	public void makeTimeStr(long time) {
		this.time = time;
		this.timeStr += "<center>クリア時間</center><br/><center>";
		this.timeStr += Long.toString(this.time);
		this.timeStr += "秒</center><br/><br/>";
	}	
	
	/**
	 * ハイスコアを表示する文字列を生成
	 * @param highScore　ハイスコア
	 */
	public void makeHighScorStr(long highScore) {
		this.highScore = highScore;
		this.highScoreStr += "<center>ハイスコア</center><br/><center>";
		this.highScoreStr += Long.toString(this.highScore);
		this.highScoreStr += "秒</center><br/><br/>";
	}	
	
	/**
	 * ゲームをクリアした際に使用する文字列を生成
	 */
	public void makePanelClear() {
		String view = this.strHead + this.timeStr + this.highScoreStr + this.strEnd;
		JLabel label1 = new JLabel(view);
		this.add(label1);
	}
	
	/**
	 * ゲームオーバした際に使用する文字列を生成
	 */
	public void makePanelFalse() {
		String view = this.strHead + this.gameover + this.strEnd;
		JLabel label1 = new JLabel(view);
		this.add(label1);
	}
}
