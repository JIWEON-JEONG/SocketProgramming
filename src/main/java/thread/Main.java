package thread;

public class Main {
    public static void main1(String[] args) {
        ThreadEx a1 = new ThreadEx("A1");
        ThreadEx b1 = new ThreadEx("B1");
        ThreadEx c1 = new ThreadEx("C1");
        a1.start();
        b1.start();
        c1.start();
    }

    public static void main(String[] args) {
        Thread a1 = new Thread(new CountDown(), "A1");
        Thread b1 = new Thread(new CountDown(), "B1");
        Thread c1 = new Thread(new CountDown(), "C1");
        a1.start();
        b1.start();
        c1.start();
    }

    public static void countDown(String name) {
        for (int i = 10; i > -1; i--) {
            System.out.println(name + " : " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

class ThreadEx extends Thread{

    public ThreadEx(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 10; i > -1; i--) {
            System.out.println(getName() + " : " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class CountDown implements Runnable {
    @Override
    public void run() {
        for (int i = 10; i > -1; i--) {
            String name = Thread.currentThread().getName();
            System.out.println(name + " : " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}