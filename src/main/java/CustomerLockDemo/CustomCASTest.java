package CustomerLockDemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
public class CustomCASTest{
    public static void main(String args[]) throws InterruptedException {
        int threadCount=12;
        int count=10000000;
        long start,end;

        AtomicInteger atomicInteger=new AtomicInteger();
        FcyAtomicInteger fcyAtomicInteger=new FcyAtomicInteger();
        CountDownLatch integerLatch=new CountDownLatch(threadCount);
        CountDownLatch fcyLatch=new CountDownLatch(threadCount);

        start=System.currentTimeMillis();
        for (int i=0;i<threadCount;i++){
            AtomicThread thread=new AtomicThread(atomicInteger,integerLatch,count);
            thread.start();
        }
        integerLatch.await();
        end=System.currentTimeMillis();
        System.out.println(atomicInteger.get()+"   cost time:"+(end-start));





        start=System.currentTimeMillis();
        for (int i=0;i<threadCount;i++){
            FcyAtomicThread thread=new FcyAtomicThread(fcyAtomicInteger,fcyLatch,count);
            thread.start();
        }
        fcyLatch.await();
        end=System.currentTimeMillis();
        System.out.println(fcyAtomicInteger.get()+"   cost time:"+(end-start));


    }
}

