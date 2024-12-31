package com.cleo.algorithms.multiThreadingAndProcessing;

public class NewThread {

    public void newThread(){
        Thread newThread = new Thread(()->{});
    //    newThread.start();
        System.out.println("New    Thread: " + newThread.getState() + " " + newThread.getName());
    }
    public void runnableThread(){
        Thread newThread = new Thread(()->{});
            newThread.start();

        System.out.println("Runnable Thread: " + newThread.getState() + " " + newThread.getName());
    }

    public void blockedThread() throws InterruptedException{
        Thread t1 = new Thread(new SyncCode());
        Thread t2 = new Thread(new SyncCode());
        t1.start();
        Thread.sleep(2000);
        t2.start();
        Thread.sleep(2000);

        System.out.println("Blocked Thread: " + t1.getState() + " " +t1.getName());

        System.out.println("Blocked Thread: " + t2.getState() + " " +t2.getName());

        System.exit(0);


    }

    static class SyncCode implements Runnable{
        @Override
        public void run() {
            System.out.println("Current thread: " + Thread.currentThread().getName() + " is in run method");
            computeFibonacci(1000);

        }
        public static int computeFibonacci(int n){
            System.out.println("Thread: " + Thread.currentThread().getName() + " " + Thread.currentThread().getState());
            if(n<2)return n;
            else return computeFibonacci(n-1)+computeFibonacci(n-2);

        }
    }





    public static void main(String[] args) throws InterruptedException {
            NewThread threads = new NewThread();
            threads.runnableThread();
            threads.newThread();
            threads.blockedThread();
    }
}
