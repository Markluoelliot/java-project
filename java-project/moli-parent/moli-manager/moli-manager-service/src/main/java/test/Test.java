package test;

public class Test {
    public static void main(String[] args) throws InterruptedException {
		System.out.println("xianchenggongzuo");
		Thread thread = new Thread (new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					System.out.println("ziixancheng");
					try {
						Thread.currentThread().sleep(2000);
					}catch(Exception e) {
						e.printStackTrace();
						
					}
				}
			}
		});
		thread.setDaemon(true);
		thread.start();
		//Thread.sleep(Long.MAX_VALUE);
	}
}
