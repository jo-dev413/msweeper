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
 *　msweeperのゲームパネルに相当するJFrameを継承したオブジェクト。
 */
public class msweeperBoard extends JPanel implements GameObject{
	
	/**
	 * 開いたマス目の数を保持
	 */
	int openBlock;
	
	/**
	 * ゲームがクリアされたかどうか
	 */
	boolean clearFlag;
	
	/**
	 * Mの設置数
	 */
	int bomnum;
	
	/**
	 * 縦横の大きさ
	 */
	int len;
	
	/**
	 * msweeperBlockを入れる配列。
	 */
	msweeperBlock map[][];
	
	/**
	 * ゲームが継続可能であるかどうか
	 */
	private boolean gameState;
	
	/**
	 * 変数の初期化
	 * 縦横の大きさを決定
	 * 爆弾の設置数を決定
	 * ボードがゲームを開始できる状態になるように設定
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
	 * gameStateのゲッター
	 * @return　ゲームが継続可能であればtrue
	 */
	public boolean getGameState() {
		return gameState;
	}
	
	/**
	 * clearFlagのゲッター
	 * @return　ゲームクリアならtrue
	 */
	public boolean getGameClear() {
		return clearFlag;
	}
	
	/**
	 * gameStateにfalseを設定してすべてのマス目を操作不可能にする
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
	 * 配置されたオブジェクトをすべて破棄する
	 */
	public void clear() {
		this.removeAll();
	}
	
	/**
	 * ボタン(msweeperBlock)をパネル上に配置する
	 * 配置されたボタンを操作できるように配列に格納して保持する
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
	 * 爆弾をセットする
	 * シャッフルにはCollections.shuffleを用いる
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
	 * 爆弾の位置を検出し、周囲に番号を振る関数(makeNum)を呼び出す
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
	 * 爆弾周囲の座標の番号を+1する
	 * @param x　爆弾の座標X
	 * @param y　爆弾の座標Y
	 */
	private void makeNum(int x,int y) {
		for(int i = 0;i < 8;i++) {
			if(x + peripheralBlockX[i] >= 0 && y + peripheralBlockY[i] >= 0 && x + peripheralBlockX[i] < len && y + peripheralBlockY[i] < len){
				map[x + peripheralBlockX[i]][y + peripheralBlockY[i]].numAdder();
			}
		}
	}
	
	/**
	 * マス目を開き、自身のマス目が空白だった場合、周辺のマス目を開く。
	 * 処理を再帰的に行い自動オープン処理を実装
	 * @param x　開くマスの座標X
	 * @param y　開くマスの座標Y
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
	 * ゲームがクリアされているかどうか判定
	 * クリアされている場合はゲームを継続不可状態へ
	 */
	private void gameCon() {
		if(this.openBlock == (len * len)-bomnum) {
			this.clearFlag = true;
			this.setGameStateEnd();
		}
	}
	
	/**
	 * ボードの縦横に収まるかどうか判定。
	 * @param x 座標X
	 * @param y　座標Y
	 * @return　範囲内ならtrue
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
	

