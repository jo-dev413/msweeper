package msweeper;

/**
 * 
 * @author jo
 * 1秒経過をカウントするタイマー機能を持つ。
 * 別スレッドで動作する。
 */
public class MyTimer extends Thread {
	
	/**
	 * trueのとき時間計測許可
	 * falseのときは時間計測を行わない
	 */
	private boolean countFlag;
	
	/**
	 * 経過時間を保持
	 */
	private long time;
	
	/**
	 * フィールド変数を初期化
	 */
	MyTimer(){
		countFlag = true;
		time = 0;
	}
	
	/**
	 * 	一秒ごとに変数timeをインクリメントする
	 */
    public void run() {
    	while(countFlag) {
    		try {
    			sleep(1000);
    			time++;
    		} catch (InterruptedException e) {	
    		}
    	}
    }
	
    /**
     * countFlagをfalseにすることによって時間計測をストップする
     */
	public void TimerStop() {
		countFlag = false;
	}
	
	/**
	 * 
	 * .計測時間を戻り値とする
	 * 
	 * @return　計測時間
	 */
	public long getTime() {
		return time;
	}
}
