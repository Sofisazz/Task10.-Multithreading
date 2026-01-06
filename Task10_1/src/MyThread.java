public class MyThread extends Thread{

    MyThread() {
        super();
    }

    public void run() {
        PrintName.printThreadName();
    }

}
