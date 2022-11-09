package thread.threadEx;

public class CountDown implements Runnable {
    @Override
    public void run() {
        for (int i = 10; i > -1; i--) {
            String name = Thread.currentThread().getName();
            String group = Thread.currentThread().getThreadGroup().getName();

            System.out.println(name + " : " + i + ", " + group);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
