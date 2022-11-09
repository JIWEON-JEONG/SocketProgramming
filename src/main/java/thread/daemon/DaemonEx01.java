package thread.daemon;

public class DaemonEx01 {

    // 자신이 태어나는 곳의 쓰레드가 죽었을때 같이 죽도록.
    // 스레드가 뻔뻔하게 살아있을때, daemon 으로 처리.
    public static void main(String[] args) {
        Thread notiThread = new Thread(new Notification(), "Noti Thread");
        notiThread.setDaemon(true);
        notiThread.start();
        System.out.println("Daemon? " + notiThread.isDaemon());
    }

}
