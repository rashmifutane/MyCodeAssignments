package client.test;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.net.SocketImpl;

public class OddEvenByThreads {

    public static void main(String args[]) {
        Thread t1 = new Thread(new OddThread(10, true));
        Thread t2 = new Thread(new EvenThread(10, false));
        t1.start();
        t2.start();
    }
}


class OddThread implements Runnable {

    int cnt;
    Boolean oddFlag;
    public OddThread(final int count, final Boolean addFlag) {
        cnt = count;
        oddFlag = addFlag;
    }

    @Override
    public void run() {
        int n = 1;
        synchronized(this){
        while (n < cnt) {
            if (n % 2 == 1  && oddFlag) {
                System.out.println("odd numver" + n);
                n ++;
                oddFlag.notify();
            }else {
                try {
                    oddFlag.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        }
    }
}


class EvenThread implements Runnable {

    int cnt;
    Boolean flag;
    public EvenThread(final int count, final Boolean flg) {
        cnt = count;
        flag =  flg;
    }

    @Override
    public void run() {
        int n = 2;
        synchronized(this){
            while (n < cnt) {
                if (!flag) {
                    System.out.println("even numver" + n);
                    n++;
                    flag.notify();
                } else {
                    try {
                        flag.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}


