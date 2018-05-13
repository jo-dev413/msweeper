package msweeper;

/**
 * Sweeperを構成する際に必要な定数一覧
 * @author jo
 */
public interface GameObject {
	/**
	 * マス目の周囲を開けるためのX座標のindex定数
	 */
	int peripheralBlockX[] = {-1,0,1,-1,1,-1,0,1};
	
	/**
	 * マス目の周囲を開けるためのY座標のindex定数
	 */
	int peripheralBlockY[] = {-1,-1,-1,0,0,1,1,1};
}