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
 * 
 * @author jo
 *　Mainクラス。
 *　コマンドラインからゲームのフィールドサイズとMの数を受け取る
 *　その後描画スレッドを立ち上げる。
 */
public class msweeperMain {
	/**
	 * @param args
	 * mainメソッド
	 * プログラム実行時に呼び出されるメソッド。
	 * このメソッドが終了するとプログラム自体も終了する。
	 */
	public static void main(String[] args){
		ViewThread view = new ViewThread();
		view.init(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
	}
}