package client.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;

public class ProducerConsumerProblem {


    public static void main( String[] args) {
        final Queue<Integer> queue = new LinkedList<>();
        final Producer producer = new Producer(queue);
        final Consumer consumer = new Consumer(queue);
        producer.start();
        consumer.start();
    }

}

class Producer extends Thread {

    private Queue<Integer> queue;

    Producer(Queue<Integer> q) {
        this.queue = q;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (queue) {
                while (queue.size() == 10) {
                    try {
                        System.out.println("waiting in producer since queue is full");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                    System.out.println("adding element to queue");
                    //Random random = new Random();
                    //int i = random.nextInt();
                    queue.add(1);
                    queue.notifyAll();
            }
        }
    }
}

     class Consumer extends Thread {
         private Queue<Integer> queue;

         Consumer(Queue<Integer> q) {
             this.queue = q;
         }

         public void run() {

             while (true) {
                 synchronized (queue) {
                     while (queue.isEmpty()) {
                         try {
                             System.out.println("waiting in consumer since queue is empty");
                             queue.wait();

                         } catch (InterruptedException e) {
                             e.printStackTrace();
                         }
                     }
                         final Integer remove = queue.remove();
                         System.out.println("removing" + remove);
                         queue.notifyAll();


                 }
             }
         }
     }

//class Producer extends Thread {
  //  private Queue<Integer> queue;
    //private int maxSize;
//
//    public Producer(Queue<Integer> queue) {
//        //super(name);
//        this.queue = queue;
//        //this.maxSize = maxSize;
//    }
//
//    @Override
//    public void run() {
//        while (true) {
//            synchronized (queue) {
//                while (queue.size() == 10) {
//                    try {
//                        System.out.println("Queue is full, " + "Producer thread waiting for " + "consumer to take something from queue");
//                        queue.wait();
//                    } catch (Exception ex) {
//                        ex.printStackTrace();
//                    }
//                }
//                Random random = new Random();
//                int i = random.nextInt();
//                System.out.println("Producing value : " + i);
//                queue.add(i);
//                queue.notifyAll();
//            }
//        }
//    }
//}

//class Consumer extends Thread {
//    private Queue<Integer> queue;
//   // private int maxSize;
//
//    public Consumer(Queue<Integer> queue) {
//      //  super(name);
//        this.queue = queue;
//        //this.maxSize = maxSize;
//    }
//
//    @Override
//    public void run() {
//        while (true) {
//            synchronized (queue) {
//                while (queue.isEmpty()) {
//                    System.out.println("Queue is empty," + "Consumer thread is waiting" + " for producer thread to put something in queue");
//                    try {
//                        queue.wait();
//                    } catch (Exception ex) {
//                        ex.printStackTrace();
//                    }
//                }
//                System.out.println("Consuming value : " + queue.remove());
//                queue.notifyAll();
//            }
//        }
//    }
//}

