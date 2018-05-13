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
 * Mainクラス。
 *　コマンドラインからゲームのフィールドサイズとMの数を受け取る
 *　その後描画スレッドを立ち上げる。
 * @author jo
 */
public class msweeperMain {
	/**
	 * @param args
	 * mainメソッド
	 * プログラム実行時に呼び出されるメソッド。
	 * このメソッドが終了するとプログラム自体も終了する。
	 */
	public static void main(String[] args){
		msweeperView view = new msweeperView();
		view.init(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
	}
}