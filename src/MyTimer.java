package msweeper;

/**
 * 
 * @author jo
 * 1�b�o�߂��J�E���g����^�C�}�[�@�\�����B
 * �ʃX���b�h�œ��삷��B
 */
public class MyTimer extends Thread {
	
	/**
	 * true�̂Ƃ����Ԍv������
	 * false�̂Ƃ��͎��Ԍv�����s��Ȃ�
	 */
	private boolean countFlag;
	
	/**
	 * �o�ߎ��Ԃ�ێ�
	 */
	private long time;
	
	/**
	 * �t�B�[���h�ϐ���������
	 */
	MyTimer(){
		countFlag = true;
		time = 0;
	}
	
	/**
	 * 	��b���Ƃɕϐ�time���C���N�������g����
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
     * countFlag��false�ɂ��邱�Ƃɂ���Ď��Ԍv�����X�g�b�v����
     */
	public void TimerStop() {
		countFlag = false;
	}
	
	/**
	 * 
	 * .�v�����Ԃ�߂�l�Ƃ���
	 * 
	 * @return�@�v������
	 */
	public long getTime() {
		return time;
	}
}
