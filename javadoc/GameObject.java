package msweeper;

/**
 * Sweeper���\������ۂɕK�v�Ȓ萔�ꗗ
 * @author jo
 */
public interface GameObject {
	/**
	 * �}�X�ڂ̎��͂��J���邽�߂�X���W��index�萔
	 */
	int peripheralBlockX[] = {-1,0,1,-1,1,-1,0,1};
	
	/**
	 * �}�X�ڂ̎��͂��J���邽�߂�Y���W��index�萔
	 */
	int peripheralBlockY[] = {-1,-1,-1,0,0,1,1,1};
}