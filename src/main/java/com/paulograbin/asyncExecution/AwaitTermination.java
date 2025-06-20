package com.paulograbin.asyncExecution;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class AwaitTermination {

    public static void main(String[] args) throws InterruptedException {
//        killThreads();
//        allowThreadsToFinish();

        useFutures();
    }

    private static void useFutures() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Integer> future1 = executorService.submit(() -> {
            Thread.sleep(3000);
            return 23;
        });

        Future<Integer> future2 = executorService.submit(() -> {
            Thread.sleep(2000);
            return 31;
        });

        executorService.shutdown();

        try {
//            Change the timeout number below
            if (executorService.awaitTermination(4, TimeUnit.SECONDS)) {
                System.out.println(future1.get());
                System.out.println(future2.get());
            } else {
                System.out.println("Tasks did not complete before timeout");
            }

            System.out.println("Done waiting");
        } catch (InterruptedException e) {
            System.err.println("Thread interrupted");
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            System.err.println("Task execution failed " + e.getCause());
        }

        System.out.println("Execution completed");
    }

    public static void killThreads() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        MyTask t1 = new MyTask(100, 2000);
        MyTask t2 = new MyTask(200, 4000);

        executorService.submit(t1);
        executorService.submit(t2);

//        shutdownNow() will interrupt all tasks in executorService
        executorService.shutdownNow();

        boolean b = executorService.awaitTermination(3, TimeUnit.SECONDS);

        if (b) {
            System.out.println("All tasks completed!");
        } else {
            System.out.println("Execution timed out");
        }
    }

    public static void allowThreadsToFinish() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        MyTask t1 = new MyTask(100, 2000);
        MyTask t2 = new MyTask(200, 4000);

        executorService.submit(t1);
        executorService.submit(t2);

        //        shutdownNow() will continue but allow tasks to complete
        executorService.shutdown();

        boolean b = executorService.awaitTermination(3, TimeUnit.SECONDS);

        if (b) {
            System.out.println("All tasks completed!");
        } else {
            System.out.println("Execution timed out");
        }
    }

    static class MyTask extends Thread {

        private final int id;
        private final int duration;

        public MyTask(int id, int duration) {
            this.id = id;
            this.duration = duration;
        }

        @Override
        public void run() {
            System.out.println(id + " pausing for " + duration + " ms");

            try {
                Thread.sleep(duration);
                System.out.println("Task " + id + " completed");
            } catch (InterruptedException e) {
                System.err.println("Task " + id + " interrupted");
            }
        }

        @Override
        public void start() {
            System.out.println("Starting task " + id);

            super.start();
        }

        @Override
        public void interrupt() {
            System.out.println("Interrupting");

            super.interrupt();
        }
    }
}
