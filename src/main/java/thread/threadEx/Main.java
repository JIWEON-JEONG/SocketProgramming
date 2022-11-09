package thread.threadEx;

public class Main {
    public static void main1(String[] args) {
        ThreadEx01 a1 = new ThreadEx01("A1");
        ThreadEx01 b1 = new ThreadEx01("B1");
        ThreadEx01 c1 = new ThreadEx01("C1");
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

class ThreadEx01 extends Thread{

    public ThreadEx01(String name) {
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

