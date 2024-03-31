package ex1;

public class Talkative implements Runnable {
    private int num;

    public Talkative(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(num + " " + (i + 1));
        }
    }
}
