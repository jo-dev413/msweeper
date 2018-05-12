package msweeper;

public class MyTimer extends Thread {
	
	/**
	 * 
	 */
	boolean countFlag;
	
	/**
	 * 
	 */
	long time;
	
	/**
	 * 
	 */
	MyTimer(){
		countFlag = true;
		time = 0;
	}
	
	/**
	 * 
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
     * 
     */
	public void TimerStop() {
		countFlag = false;
	}
	
	/**
	 * 
	 * @return
	 */
	public long getTime() {
		return time;
	}
}
