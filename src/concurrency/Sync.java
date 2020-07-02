package concurrency;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

class Sync extends Thread {
    List nums = new CopyOnWriteArrayList<>();

    Sync(String name) {
        super(name);
    }

    @Override 
    public void run() {
        Random rand = new Random();

        synchronized (this) {

            for (int i = 0; i < 100; i++) {
                int randInt = rand.nextInt(100);
                this.nums.add(randInt);
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Sync syncThread = new Sync("sync thread");
        syncThread.start();

        Sync syncThread2 = new Sync("sync thread");
        syncThread2.start();

        Sync syncThread3 = new Sync("sync thread");
        syncThread3.start();

        Sync syncThread4 = new Sync("sync thread");
        syncThread4.start();

        Sync syncThread5 = new Sync("sync thread");
        syncThread5.start();

        syncThread.join();
        System.out.println(syncThread.nums);
        //this prints out an empty list. write some code that will allow the data generated in the syncThread to show up  here.
        // There is a brute force way and a more sophisticated way.
        // Either or will work, but strive for sophistication :)

    }
    
}