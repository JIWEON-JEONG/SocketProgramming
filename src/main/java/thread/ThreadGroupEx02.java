package thread;

import thread.threadEx.CountDown;

public class ThreadGroupEx02 {

    //스레드 지맘대로 실행 되는 이유 : 각자 실행 하고, 운영체제 스케쥴링에 따라서 다르게 실행된다.
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup timer = new ThreadGroup("Timer");

        ThreadGroup suwon_timer = new ThreadGroup(timer, "Suwon Timer");
        ThreadGroup jeju_timer = new ThreadGroup(timer, "Jeju Timer ");

        Thread suwonCountDown = new Thread(suwon_timer, new CountDown(), "Suwon CountDown");
        Thread jejuCountDown = new Thread(jeju_timer, new CountDown(), "Jeju CountDown");

        suwonCountDown.start();

//        suwonCountDown.join();

        jejuCountDown.start();
    }
}
