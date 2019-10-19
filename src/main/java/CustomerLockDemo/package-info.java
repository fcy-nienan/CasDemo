package CustomerLockDemo;
/*
* 自己写的CAS自增和Atomic Integer的自增耗时比较
*
* 12个线程自增10000000次
* Atomic Integer的稳定在2S左右
* 自己写的达到10S以上
* FcyAtomicInteger中的代码全是复制AtomicInteger中的(除了Unsafe的获取方式不同,Unsafe对象我们不能直接获取,只能通过反射)
* 主要代码如下:如果自己写while循环则耗时10S
* 但如果用Unsafe的方法直接调用耗时2S
* 有点纳闷。。
* public final int getAndIncrement() {
        Object var1=this;
        long var2=valueOffset;
        int var4=1;
        int var5;
        do {
            var5 = unsafe.getIntVolatile(var1, var2);
        } while(!unsafe.compareAndSwapInt(var1, var2, var5, var5 + var4));

        return var5;
//        return unsafe.getAndAddInt(this, valueOffset, 1);
    }
*
*
*
* */