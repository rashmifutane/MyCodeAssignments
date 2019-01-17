package client.test;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

public class OddEven {


    public static void main(String[] args) {
        final OddEvenMain oddEvenMain = new OddEvenMain();
        final Odd odd = new Odd(oddEvenMain);
        final Even even = new Even(oddEvenMain);
        odd.start();
        even.start();
    }

}

class Odd extends Thread {

    final OddEvenMain oddEvenMain;

    Odd(OddEvenMain m) {
        this.oddEvenMain = m;
    }

    @Override
    public void run() {
        oddEvenMain.printOdd();
    }
}

class Even extends Thread {
    final OddEvenMain oddEvenMain;

    Even(OddEvenMain m) {
        this.oddEvenMain = m;
    }


    @Override
    public void run() {
        oddEvenMain.printEven();
    }

}

class OddEvenMain {

     AtomicBoolean isOdd = new AtomicBoolean(false);
    int count = 1;
    int maxCount = 20;

    public void printEven() {


            while (count < maxCount) {
                synchronized(this) {  //synchronised on odd even object
                while (isOdd.get()) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                isOdd = new AtomicBoolean(true);;
                System.out.println("printing even number" + count);
                count++;
                    notifyAll();
            }
        }
    }

    public void printOdd() {

            while (count < maxCount) {
                synchronized (this) {
                while (!isOdd.get()) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                isOdd = new AtomicBoolean(false);;
                System.out.println("printing odd number" + count);
                count++;
                    notifyAll();
            }
        }
    }


}
