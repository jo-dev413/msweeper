package msweeper;

import javax.swing.JFrame;

/**
 * 描画スレッドを提供するJFrameを継承したクラス。本クラス上でゲームは処理される。
 * @author jo
 */
public class msweeperView extends JFrame implements Runnable {
	
	/**
	 * セットするMの数
	 */
	private int bom;
	
	/**
	 *　セットするボードの大きさ
	 */
	private int len;
	
	/**
	 * ハイスコア
	 */
	private long highscore;
	
	/**
	 * このクラスが動作するスレッド
	 */
	Thread thread = null;
	
	/**
	 * 画面サイズを400*400で設定
	 * ✖ボタンで終了するように設定
	 */
	msweeperView(){
		this.setBounds(0, 0, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * 変数の初期化とスレッドの起動
	 * @param len　ボードの大きさ
	 * @param bom　Mの数
	 */
	public void init(int len,int bom) {
		this.bom = bom;
		this.len = len;
		this.highscore = 10000;
		Thread view = new Thread(this);
		view.start();
	}
	
	/**
	 * ゲーム処理
	 */
	@Override
	public void run(){
		
		//時間計測を行うタイマ
		MyTimer time;
		
		//ゲーム処理が行われるボード
		msweeperBoard board;
		
		while(true) { 
			
			//タイマ生成
			time = new MyTimer();
			
			//ボードを生成
			board = new msweeperBoard(this.len,this.bom);
			
			//ボードを追加（ゲームスタート）
			this.add(board);
			
			//Frameの可視化
			this.setVisible(true);
			
			//時間計測開始
			time.start();
			
			//再描画
			this.repaint();
			
			//ゲームが継続不可状態になるまで無限ループ
			while(board.getGameState()){
				repaint();	//再描画
			}
			
			//
			time.TimerStop();
			
			//2秒間描画停止
			waitSec(2);
			
			//ゲームボード内のマスを破棄
			board.clear();
			
			//再描画
			this.repaint();
			
			//ゲームオーバかゲームクリアか
			
			//ゲームクリアの場合
			if(board.getGameClear()) {
				this.remove(board);	//ゲームボードを破棄
				scoreView(time.getTime(),true);	//クリアスコアを表示
			}
			//ゲームオーバの場合
			else {
				this.remove(board);	//ゲームボードを破棄
				scoreView(time.getTime(),false);	//ゲームオーバを知らせる
			}
		  }
	  }
	
	/**
	 * スコアもしくはゲームオーバーの旨を表示する
	 * @param time ゲーム開始から終了までの経過時間
	 * @param clear　ゲームをクリアしたかどうか
	 */
	private void scoreView(long time,boolean clear) {
		
		//表示用のパネルを準備
		msweeperScore msc;
		
		//ハイスコア更新チェック
		setHighScore(time);
		
		//表示用パネル生成
		msc = new msweeperScore();
		
		//ハイスコアのテキスト生成
		msc.makeHighScorStr(this.highscore);
		
		//クリアタイムのテキスト生成
		msc.makeTimeStr(time);
		
		//クリアの場合
		if(clear) {
			//クリアスコアとハイスコアを表示
			msc.makePanelClear();
		}
		//ゲームオーバの場合
		else {
			//ゲームオーバの旨を伝える
			msc.makePanelFalse();
		}
		
		//フレームにパネルを追加（可視化）
		this.add(msc);
		
		//5秒間描画スレッドを停止
		waitSec(5);
		
		//スコア表示用のパネルを破棄
		remove(msc);
	}
	  
	/**
	 * 1秒間描画スレッドを停止する。
	 * @param sec　停止する時間(s)
	 */
	  private void waitSec(int sec) {
			try {
				thread.sleep(sec * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	  }
	  
	  /**
	   * ゲーム終了時の経過時間がハイスコアを下回ればハイスコアを上書きする
	   * @param score ゲーム終了時の経過時間
	   */
	  private void setHighScore(long score) {
		  if(this.highscore > score) {
			  this.highscore = score;
		  }
	  }
}
