package study.thread;

public class JoinExample {
    private static class SumThread extends Thread {
        private long sum;

        public long getSum() {
            return sum;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 100; i++) {
                sum += i;
            }
        }
    }

    public static void main(String[] args) {
        SumThread sumThread = new SumThread();
        sumThread.start();

        try {
            sumThread.join();
        } catch (InterruptedException e) {}

        System.out.println("1 ~ 100 합: " + sumThread.getSum());
    }
}
