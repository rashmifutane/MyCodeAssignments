package client.test;

import java.util.LinkedList;
import java.util.Queue;

public class ThreadPool {
    Queue<Task> taskQueue;
    int numberOfWorkerThreads;
    Thread[] workerThreads; //array of threads

    public ThreadPool(final int numberOfWorkerThreads) {
        this.taskQueue = new LinkedList<>();
        this.numberOfWorkerThreads = numberOfWorkerThreads;
        workerThreads = new WorkerThread[numberOfWorkerThreads];

        for (int i = 0; i < numberOfWorkerThreads; i++) {
            workerThreads[i] = new WorkerThread();
            workerThreads[i].start();
        }

    }

    public void execute(Task task) {
        synchronized (taskQueue) {

            taskQueue.add(task);
            taskQueue.notify();
        }
    }


    private class WorkerThread extends Thread {
        Task task;

        @Override
        public void run() {

            while (true) {
                synchronized (taskQueue) {
                    while (taskQueue.isEmpty()) {
                        try {
                            taskQueue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //threadpool is not empty get the task from queue
                    task = taskQueue.poll(); //gives first element of the queue
                    task.run();
                }

            }
        }
    }

    private static class Task implements Runnable {

        private int n;

        public Task(int taskNumber) {
            n = taskNumber;
        }

        @Override
        public void run() {
            System.out.println("running task " + n);
        }
    }

    public static void main(String[] args) {

        ThreadPool pool = new ThreadPool(7);

        for (int i = 0; i < 5; i++) {
            Task task = new Task(i);
            pool.execute(task);
        }

    }

    //create blocking queue create array of worker threads in constructor and call run of worker threads
    //execute method add task to blocking queue and notify
    //main create tasks and call execute for each task in loop
    //task is a runnable its run method does something
    //worker thread extends thread and runnable method synchronised on blocking queue wait if queue is empty else poll task and call run

}
