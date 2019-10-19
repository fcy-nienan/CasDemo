package CustomerLockDemo;

import java.util.concurrent.CountDownLatch;

public class FcyAtomicThread extends Thread{
    private FcyAtomicInteger integer;
    private CountDownLatch latch;
    private int count;
    public FcyAtomicThread(FcyAtomicInteger i,CountDownLatch latch,int count){
        this.integer=i;
        this.latch=latch;
        this.count=count;
    }
    @Override
    public void run() {
        for (int i=0;i<count;i++) {
            integer.getAndIncrement();
        }
        latch.countDown();
    }
}
