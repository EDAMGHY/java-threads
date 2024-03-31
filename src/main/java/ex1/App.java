package ex1;

public class App {
    public static void main(String[] args) {
        Talkative talkative1 = new Talkative(1);
        Talkative talkative2 = new Talkative(2);
        Talkative talkative3 = new Talkative(3);
        Talkative talkative4 = new Talkative(4);
        Talkative talkative5 = new Talkative(5);
        Talkative talkative6 = new Talkative(6);
        Talkative talkative7 = new Talkative(7);
        Talkative talkative8 = new Talkative(8);
        Talkative talkative9 = new Talkative(9);
        Talkative talkative10 = new Talkative(10);

        Thread thread1 = new Thread(talkative1);
        Thread thread2 = new Thread(talkative2);
        Thread thread3 = new Thread(talkative3);
        Thread thread4 = new Thread(talkative4);
        Thread thread5 = new Thread(talkative5);
        Thread thread6 = new Thread(talkative6);
        Thread thread7 = new Thread(talkative7);
        Thread thread8 = new Thread(talkative8);
        Thread thread9 = new Thread(talkative9);
        Thread thread10 = new Thread(talkative10);


        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();


    }
}
