package msweeper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * 
 * @author jo
 * msweeperBoardの1マスに配置されるJButtonを継承したオブジェクト。
 * 
 */
public class msweeperBlock extends JButton implements ActionListener {
	
	/**
	 *	インスタンス化されたオブジェクトの座標 
	 */
	private int x,y;
	
	/**
	 * Mを持っているか
	 */
	private boolean bom;
	
	/**
	 * Mの周りにあった場合に表示される数
	 */
	private int num;
	
	/**
	 * ボタンが押されているかどうか
	 */
	private boolean state;
	
	/**
	 * コールバック先
	 */
	private msweeperBoard board;
	
	/**
	 * クリック可能かどうか
	 */
	private boolean clickOK;
	
	/**
	 * 変数の初期化とアクションリスナーの追加
	 * @param board　コールバック先
	 * @param x　座標X
	 * @param y　座標Y
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
	 * プレス検出
	 * 検出後コールバック
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
	 * bomのゲッター
	 * @return　自身がMかどうか
	 */
	public boolean getBomFlag() {
		return this.bom;
	}
	
	/**
	 * 自身のマス目を開く
	 * 開いたときに状態を表す文字を表示
	 * 爆弾　　  ： M
	 * Mの周囲  ： Mの数に応じた数字
	 * その他　   ： 空文字
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
	 * stateのゲッター
	 * @return　プレス済みかどうか
	 */
	public boolean getState() {
		return state;
	}
	
	/**
	 * numのゲッター
	 * @return　周囲のMの数
	 */
	public int getNum() {
		return num;
	}
	
	/**
	 * bomのセッター
	 */
	public void setBom() {
		this.bom = true;
	}

	/**
	 * clickOKのセッター
	 * @param b　プレスの許可or禁止
	 */
	public void setClickOK(boolean b) {
		this.clickOK = b;
	}
}
